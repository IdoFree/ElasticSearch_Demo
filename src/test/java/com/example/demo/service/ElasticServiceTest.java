package com.example.demo.service;

import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.impl.ElasticSearchServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Ido on 2017/7/18.
 */
public class ElasticServiceTest {
    private  static ElasticDataPreparator elasticDataPreparator;

    @Test
    public void testToJson(){
        TeacherRepository repository = new TeacherRepository();

        System.out.println(ElasticDataPreparator.getJsonString(repository.getTeacher("testTeacher",1)));
    }
}
