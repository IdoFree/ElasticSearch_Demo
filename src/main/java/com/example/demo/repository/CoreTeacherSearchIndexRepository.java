package com.example.demo.repository;

import com.example.demo.model.CoreTeacher;
import com.example.demo.model.CoreTeacherSearchIndex;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Ido on 2017/7/14.
 */
public interface CoreTeacherSearchIndexRepository extends CrudRepository<CoreTeacherSearchIndex,Long> {
    String  Core_Teacher_Search_Index =" ctsi.teacherID ,ctsi.phone ,ctsi.name ,ctsi.gender ,ctsi.type ,ctsi.stars ,ctsi.careerTime ,ctsi.availableServices ,ctsi.degree ,ctsi.university ,ctsi.major ,ctsi.students ,ctsi.lessons ,ctsi.scores ,ctsi.regionName ,ctsi.regionID ,ctsi.cityName ,ctsi.cityID ,ctsi.zoneName ,ctsi.zoneID ,ctsi.courseCategoryID ,ctsi.courseCategoryName ,ctsi.courseName ,ctsi.courseID ,ctsi.monday ,ctsi.tuesday ,ctsi.wednesday ,ctsi.thursday ,ctsi.friday ,ctsi.saturday ,ctsi.sunday ,ctsi.updatedTime ,ctsi.priceLowest ";
    @Query(value = "select "+Core_Teacher_Search_Index+"from core_teacher_search_index ctsi  ",nativeQuery = true)
    public List<Object[]> fingAll();
}
