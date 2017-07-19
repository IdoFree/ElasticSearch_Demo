package com.example.demo.service;

import com.example.demo.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Ido on 2017/7/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreTeacherSearchIndexTest {
    @Autowired
    private CoreTeacherSearchIndexService service;
    @Test
    public void testFindAll(){
        StringUtil.println(String.valueOf(service.findAll().size()));
    }
}
