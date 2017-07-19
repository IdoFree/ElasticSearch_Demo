package com.example.demo.service.impl;

import com.example.demo.model.CoreTeacher;
import com.example.demo.repository.CoreTeacherRepository;
import com.example.demo.service.CoreTeacherService;
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
public class CoreTeacherServiceImpl  implements CoreTeacherService{
    @Autowired
    private CoreTeacherRepository repository;

    @Override
    public CoreTeacher getById(Long id) {
        CoreTeacher teacher = new CoreTeacher();
        List<Object[]> rs = repository.findById(id);
        Assert.notEmpty(rs,"can not find teacher : id"+id);
        teacher.setAccountId((Integer) rs.get(0)[0]);
        return teacher;
    }

    @Override
    public List<CoreTeacher> findAll() {
        List<Object[]> rs = repository.fingAll();
        Assert.notEmpty(rs,"can not find any teacher ");
        List<CoreTeacher> resultList = new ArrayList<>(rs.size());
        for(Object[] teacherinfo: rs){
            resultList.add(resultSetToTeacher(teacherinfo));

        }
        return resultList;
    }

    private CoreTeacher resultSetToTeacher(Object[] teacherinfo){
        CoreTeacher ct = new CoreTeacher();
        ct.setId((Integer) teacherinfo[0]);
        ct.setAccountId((Integer) teacherinfo[1]);
        ct.setType( (Byte)teacherinfo[2]);
        ct.setAuditStatus((Byte) teacherinfo[3]);
        ct.setCertification((Byte) teacherinfo[4]);
        ct.setStars((Byte) teacherinfo[5]);
        ct.setAvailableServices((Byte) teacherinfo[6]);
        ct.setCareerStartTime((Date) teacherinfo[7]);
        ct.setUpdatedTime((Date) teacherinfo[8]);
        ct.setCreatedTime((Date) teacherinfo[9]);

        return ct;
    }
}
