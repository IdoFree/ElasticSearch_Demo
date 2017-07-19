package com.example.demo.service;

import com.example.demo.model.CoreTeacher;
import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ido on 2017/7/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreTeacherTest {
    @Autowired
    private CoreTeacherService service;
//    @Test
    public void testGetById(){

        Assert.notNull(service.getById(1000l));
    }

//    @Test
    public void testFindAll(){
        List result = service.findAll();
        Assert.notNull(result,"empty result set");
        System.out.println(ElasticDataPreparator.getJsonString(result));
    }

    @Test
    public void testToJsonFile() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List result = service.findAll();
        Assert.notNull(result,"empty result set");
        ElasticDataPreparator.toJsonFile(ElasticDataPreparator.getBulkJsonString(result,CoreTeacher.class),"test.json");
    }
    @Test
    public void testGetBulkJsonString() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        TeacherRepository repository = new TeacherRepository();
        List<Teacher> teachers = new ArrayList<>(10);
        for(int i = 0; i < 10; i++){
            teachers.add(repository.getTeacher("name"+i,i));
        }
        print(ElasticDataPreparator.getBulkJsonString(teachers,Teacher.class));
    }

    private void print(String s){
        System.out.println(s);
    }


}
