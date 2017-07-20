package com.example.demo.service;

import com.example.demo.controller.requestmodel.ElasticSearchRequest;
import com.example.demo.model.CoreTeacherSearchIndex;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ido on 2017/7/18.
 */
@Service
public interface CoreTeacherSearchIndexService {

    public List<CoreTeacherSearchIndex> findAll();


}
