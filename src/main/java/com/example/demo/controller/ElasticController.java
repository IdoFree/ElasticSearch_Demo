package com.example.demo.controller;

import com.example.demo.controller.requestmodel.ElasticSearchRequest;
import com.example.demo.model.CoreTeacherSearchIndex;
import com.example.demo.service.CoreTeacherSearchIndexService;
import com.example.demo.service.impl.ElasticSearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by Ido on 2017/7/18.
 */
@RestController
@RequestMapping("elastic")
public class ElasticController {
    @Autowired
    private ElasticSearchServiceImpl service;

    @GetMapping("searchAll")
    public String searchAll(ElasticSearchRequest request) throws IOException {
        return service.searchAll();

    }

    @PostMapping("query")
    public String query(@RequestBody(required = false) ElasticSearchRequest request) throws IOException {
        request = new ElasticSearchRequest();
        CoreTeacherSearchIndex coreTeacherSearchIndex = new CoreTeacherSearchIndex();
        request.setTeacherSearchIndex(coreTeacherSearchIndex);
        request.getTeacherSearchIndex().setCityName("从化");
        request.getTeacherSearchIndex().setAvailableServices(new Byte("1"));
        return service.search(request);

    }

    @GetMapping("search")
    public String search(@RequestParam  String q ) throws IOException {
        return service.search(q);

    }
}
