package com.example.demo.service;

import com.google.gson.Gson;
import sun.jvm.hotspot.utilities.Assert;

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


     static <T> String  getBulkJsonString(List<T> l,Class<T> clz,String idMethodName,String index, String type) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Gson gson = new Gson();
        StringBuilder sb = new StringBuilder();
        String getIdMehodName = null;
         org.springframework.util.Assert.notNull(index,"index can not be null");
         org.springframework.util.Assert.notNull(type,"type can not be null");



        if(idMethodName != null){
            getIdMehodName = idMethodName;
        }else{
            getIdMehodName = "getId";
        }
        Method getIdMethod = clz.getMethod(getIdMehodName);
        Number id  ;
        for(T o : l){
            try {
                 id = (Long) getIdMethod.invoke(o );
            }catch (ClassCastException e){
                id = (Integer) getIdMethod.invoke(o );
            }

            sb.append("{ \"index\" : { \"_index\" : \""+index+"\", \"_type\" : \""+type+"\",\"_id\" :"+id+" } }\n");
            sb.append(gson.toJson(o)).append("\n");
        }
        return sb.toString();
    }


     static void toJsonFile(String jsonStr,String fileName) throws IOException {
        File outFile = new File(fileName);
        if(!outFile.exists()){
            outFile.createNewFile();
        }
        OutputStream os = new FileOutputStream(fileName);
        os.write(jsonStr.getBytes());
        os.close();
    }

    String getTeacherIndexJson() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
