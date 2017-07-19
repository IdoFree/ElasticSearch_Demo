package com.example.demo.service;

import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Ido on 2017/7/18.
 */
public interface ElasticDataPreparator {
    public static <T> String  getJsonString(Object obj){
        Gson gson = new Gson();
        return gson.toJson(obj);
    }


    public static <T> String  getBulkJsonString(List<T> l,Class<T> clz,String... idMethodName) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Gson gson = new Gson();
        StringBuilder sb = new StringBuilder();
//        T t = clz.newInstance();
        Method getIdMethod = clz.getMethod("getId");
        Type returnType = getIdMethod.getReturnType();

        Number id  ;
        for(T o : l){
            try {
                 id = (Long) getIdMethod.invoke(o );
            }catch (ClassCastException e){
                id = (Integer) getIdMethod.invoke(o );
            }

            sb.append("{ \"index\" : { \"_index\" : \"xswy\", \"_type\" : \"core_teacher\",\"_id\" :"+id+" } }\n");
            sb.append(gson.toJson(o)).append("\n");
        }
        return sb.toString();
    }


    public static void toJsonFile(String jsonStr,String fileName) throws IOException {
        File outFile = new File(fileName);
        if(!outFile.exists()){
            outFile.createNewFile();
        }
//        String jsonStr  = getJsonString(source);
        OutputStream os = new FileOutputStream(fileName);
        os.write(jsonStr.getBytes());
        os.close();
    }
}
