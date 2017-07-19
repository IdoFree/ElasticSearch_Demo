package com.example.demo.service.impl;

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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
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
}
