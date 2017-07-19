package com.example.demo.service;

import com.example.demo.model.CoreTeacher;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ido on 2017/7/18.
 */
@Service
public interface CoreTeacherService {
    public CoreTeacher getById(Long id);

    public List<CoreTeacher> findAll();


}
