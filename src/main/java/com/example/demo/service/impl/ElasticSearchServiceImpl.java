package com.example.demo.service.impl;

import com.example.demo.config.ElasticConfig;
import com.example.demo.controller.requestmodel.ElasticSearchRequest;
import com.example.demo.model.CoreTeacher;
import com.example.demo.model.CoreTeacherSearchIndex;
import com.example.demo.model.Teacher;
import com.example.demo.repository.CoreTeacherSearchIndexRepository;
import com.example.demo.service.CoreTeacherSearchIndexService;
import com.example.demo.service.ElasticDataPreparator;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

/**
 * Created by Ido on 2017/7/14.
 */
@Service
public class ElasticSearchServiceImpl  implements ElasticDataPreparator{
    private static  final String index = "test";
    private static final String type = "teacher";
    private static final String url = "http://localhost:9200";

    private static final int GET = 1;
    private static final int DELETE = 2;
    private static final int PUT = 3;
    private static final int POST = 4;

    @Autowired
    private ElasticConfig elasticConfig;
    @Autowired
    private CoreTeacherSearchIndexService service;

    private static String getTeacherUrl(){

        return url+"/"+index+"/"+type+"/";
    }

    public static <T> String index(T obj) throws IOException {
        //  serialize obj to json
        Gson gson = new Gson();
        String jsonString = gson.toJson(obj);
        // and to build the es get header
        StringBuilder esUrl = new StringBuilder();

        int id = ((Teacher)obj).getId();
        esUrl.append(getTeacherUrl()).append("/").append(id);
        //then put it to the queue or index directly into the es
        HttpClient client = HttpClientBuilder.create().build();
        HttpPut put = new HttpPut(esUrl.toString());
        put.setHeader("Content-Type","application/json");
        //set put body
        put.setEntity(new StringEntity(jsonString,"utf-8"));

        HttpResponse response = client.execute(put);
        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return result.toString();

    }


    public static <T> T get(int id,Class clz) throws IOException {
        // and to build the es get header
        StringBuilder esUrl = new StringBuilder();

        esUrl.append(getTeacherUrl()).append(id);
        //then put it to the queue or index directly into the es
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet put = new HttpGet(esUrl.toString());

        HttpResponse response = client.execute(put);
        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        Gson gson = new Gson();
        T rtv = gson.fromJson(result.toString(), (Class<T>) clz);
        return rtv;

    }

    @Override
    public String getTeacherIndexJson() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List result = service.findAll();
        if(Objects.isNull(result)){
            return "";
        }
        return ElasticDataPreparator.getBulkJsonString(result,CoreTeacherSearchIndex.class,"getTeacherID","xswy","core_teacher_search_index");
    }

    private String makeMatchCriteria(ElasticSearchRequest request){
        StringBuilder sb= new StringBuilder();
        Gson gson = new Gson();
        String jsonStr = gson.toJson(request.getTeacherSearchIndex());
        jsonStr = jsonStr.substring(1,jsonStr.length()-1);
        String ss[] = jsonStr.split(",")  ;

        for(String s : ss){
            sb.append("{ \"match\": { ").append(s).append("}},");
        }
        String reultWithLastComma =sb.toString();
        return reultWithLastComma.substring(0,reultWithLastComma.length()-1);
    }

    @Override
    public String search(ElasticSearchRequest request) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        Gson gson = new Gson();
        String searchCriteria = gson.toJson(request.getTeacherSearchIndex());
        //todo according the the request make the query String
        String reqStr  = "{\n" +
                "  \"query\": {\n" +
                "    \"bool\": {\n" +
                "      \"should\": [\n" +
                makeMatchCriteria(request)+
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "}";

        HttpPost post = (HttpPost) getHttpMethod(POST,"/_search?pretty");
        post.setEntity(new StringEntity(reqStr,"utf-8"));
        HttpResponse response = client.execute(post);
        return handlerResponse(response);
    }

    @Override
    public String search(String queryString ) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        String queryStr = "{\n" +
                "  \"query\": {\n" +
                "    \"multi_match\" : {\n" +
                "      \"query\":    \""+queryString+"\", \n" +
                "      \"fields\": [ \"_all\" ] \n" +
                "    }\n" +
                "  }\n" +
                "}";
        HttpPost post = (HttpPost) getHttpMethod(POST,"/_search?pretty");
        post.setEntity(new StringEntity(queryStr,"utf-8"));
        HttpResponse response = client.execute(post);
        return handlerResponse(response);
    }

    private String handlerResponse(HttpResponse response) throws IOException {
        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line).append("\n");
        }
        return result.toString();
    }

    private HttpRequestBase getHttpMethod(int method,String requestUrl)  {
        String url = elasticConfig.getHost()+requestUrl;
        HttpRequestBase httpMethod;
        switch (method){
            case GET:{
                httpMethod = new HttpGet(url);
                break;

            }
            case DELETE:{
                httpMethod = new HttpDelete(url);
                break;

            }

            case PUT:{
                httpMethod = new HttpPut(url);
                break;
            }
            case POST:{
                httpMethod = new HttpPost(url);
                break;
            }

            default:
                throw new RuntimeException("unsupport http method");
        }

        httpMethod.setHeader("Content-Type","application/json");
        httpMethod.setHeader("charset","utf-8");

        return httpMethod;
    }

    @Override
    public String searchAll() throws IOException {
        elasticConfig.getHost();

        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(getHttpMethod(GET,"/_search?pretty"));
        return handlerResponse(response);
    }

}
