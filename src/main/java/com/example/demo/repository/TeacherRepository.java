package com.example.demo.repository;

import com.example.demo.model.Teacher;

/**
 * Created by Ido on 2017/7/14.
 */
public class TeacherRepository {
    public Teacher getTeacher(String name,int id){
        Teacher t = new Teacher();
        t.build().setName(name);
        t.setId(id);
        return t;
    }
}
