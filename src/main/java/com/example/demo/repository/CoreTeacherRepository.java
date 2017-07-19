package com.example.demo.repository;

import com.example.demo.model.CoreTeacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Ido on 2017/7/14.
 */
public interface CoreTeacherRepository extends CrudRepository<CoreTeacher,Long> {
    String teacher_info = " ct.id,ct.accountID, ct.type,ct.auditStatus,ct.certification,ct.stars,ct.availableServices,ct.careerStartTime,ct.updatedTime ,ct.createdTime ";
    @Query(value = "select "+teacher_info+"from core_teacher ct where ct.id = :id ",nativeQuery = true)
    public List<Object[]> findById(@Param("id") Long id);
    @Query(value = "select "+teacher_info+"from core_teacher ct  ",nativeQuery = true)
    public List<Object[]> fingAll();
}
