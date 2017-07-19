package com.example.demo;

import com.example.demo.model.ReturnObj;
import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.impl.ElasticSearchServiceImpl;
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
}
