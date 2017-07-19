package com.example.demo.service.impl;

import com.example.demo.model.CoreTeacher;
import com.example.demo.model.CoreTeacherSearchIndex;
import com.example.demo.repository.CoreTeacherRepository;
import com.example.demo.repository.CoreTeacherSearchIndexRepository;
import com.example.demo.service.CoreTeacherSearchIndexService;
import com.example.demo.service.CoreTeacherService;
import com.example.demo.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ido on 2017/7/18.
 */
@Service
public class CoreTeacherSearchIndexServiceImpl implements CoreTeacherSearchIndexService {
    @Autowired
    private CoreTeacherSearchIndexRepository repository;


    @Override
    public List<CoreTeacherSearchIndex> findAll() {
        List<Object[]> rs = repository.fingAll();
        Assert.notEmpty(rs,"can not find any teacher ");
        List<CoreTeacherSearchIndex> resultList = new ArrayList<>(rs.size());
        for(Object[] teacherinfo: rs){
            try {
                resultList.add(resultSetToTeacher(teacherinfo));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return resultList;
    }

    private CoreTeacherSearchIndex resultSetToTeacher(Object[] teacherinfo) throws IllegalAccessException {
        CoreTeacherSearchIndex ct = new CoreTeacherSearchIndex();
        ObjectUtils.fillProperties(ct,teacherinfo);

        return ct;
    }
}
