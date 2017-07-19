package com.example.demo.model;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by Ido on 2017/7/18.
 */
@Entity
@Table(name = "core_teacher")
public class CoreTeacher {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "accountID")
    private Integer accountId;

    private Byte type;

//    @Column(name = "auditStatus")
    private Byte auditStatus;

    private Byte certification;

    private Byte stars;

//    @Column(name = "availableServices")
    private Byte availableServices;

//    @Column(name = "careerStartTime",columnDefinition="datetime DEFAULT NULL")
    private Date careerStartTime;

//    @Column(name = "updatedTime",columnDefinition="timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'")
    private Date updatedTime;


//    @Column(name = "createdTime",columnDefinition="timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    private Date createdTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Byte getCertification() {
        return certification;
    }

    public void setCertification(Byte certification) {
        this.certification = certification;
    }

    public Byte getStars() {
        return stars;
    }

    public void setStars(Byte stars) {
        this.stars = stars;
    }

    public Byte getAvailableServices() {
        return availableServices;
    }

    public void setAvailableServices(Byte availableServices) {
        this.availableServices = availableServices;
    }

    public Date getCareerStartTime() {
        return careerStartTime;
    }

    public void setCareerStartTime(Date careerStartTime) {
        this.careerStartTime = careerStartTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
