package com.example.demo;

import com.example.demo.controller.requestmodel.ElasticSearchRequest;
import com.example.demo.model.CoreTeacherSearchIndex;
import com.example.demo.model.ReturnObj;
import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.impl.ElasticSearchServiceImpl;
import com.example.demo.util.StringUtil;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Ido on 2017/7/14.
 */

public class TestES {

//    @Test
    public void testIndex() throws IOException {
        TeacherRepository repository = new TeacherRepository();

        ElasticSearchServiceImpl.index(repository.getTeacher("testTeacher",1));


    }
    @Test
    public void testGet() throws IOException {
        TeacherRepository repository = new TeacherRepository();

        ReturnObj<Teacher> result = ElasticSearchServiceImpl.get(1, ReturnObj.class);
        Assert.assertNotNull(result);


    }


    @Test
    public void testGsonString(){
        Gson gson = new Gson();
        ElasticSearchRequest request = new ElasticSearchRequest();
        CoreTeacherSearchIndex coreTeacherSearchIndex = new CoreTeacherSearchIndex();
        request.setTeacherSearchIndex(coreTeacherSearchIndex);
        request.getTeacherSearchIndex().setCityName("广州");
        request.getTeacherSearchIndex().setAvailableServices(new Byte("1"));
        String jsonStr = gson.toJson(request.getTeacherSearchIndex());
        jsonStr = jsonStr.substring(1,jsonStr.length()-1);
        jsonStr.split(",")  ;
        StringUtil.println(jsonStr);
    }
}
