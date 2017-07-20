package com.example.demo.controller.requestmodel;

import com.example.demo.model.CoreTeacherSearchIndex;

/**
 * Created by Ido on 2017/7/20.
 */
public class ElasticSearchRequest {
    private CoreTeacherSearchIndex teacherSearchIndex;
    private Integer size = 5;
    private Integer from = 0;

    public CoreTeacherSearchIndex getTeacherSearchIndex() {
        return teacherSearchIndex;
    }

    public void setTeacherSearchIndex(CoreTeacherSearchIndex teacherSearchIndex) {
        this.teacherSearchIndex = teacherSearchIndex;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }
}
