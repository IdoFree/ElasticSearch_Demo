package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Ido on 2017/7/19.
 */
@Entity
@Table(name = "core_teacher_search_index")
public class CoreTeacherSearchIndex {
    @Id
    private Integer teacherID;
    private String phone;
    private String name;
    private Byte gender;
    private Byte type;
    private Byte stars;
    private Short careerTime;
    private Byte availableServices;
    private Integer degree;
    private String university;
    private String major;
    private Integer students;
    private Integer lessons;
    private BigDecimal scores;
    private String regionName;
    private Integer regionID;
    private String cityName;
    private Integer cityID;
    private String zoneName;
    private String zoneID;
    private String courseCategoryID;
    private String courseCategoryName;
    private String courseName;
    private String courseID;
    private Byte monday;
    private Byte tuesday;
    private Byte wednesday;
    private Byte thursday;
    private Byte friday;
    private Byte saturday;
    private Byte sunday;
    private Date updatedTime;
    private BigDecimal priceLowest;

    public Integer getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Integer teacherID) {
        this.teacherID = teacherID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStars() {
        return stars;
    }

    public void setStars(Byte stars) {
        this.stars = stars;
    }

    public Short getCareerTime() {
        return careerTime;
    }

    public void setCareerTime(Short careerTime) {
        this.careerTime = careerTime;
    }

    public Byte getAvailableServices() {
        return availableServices;
    }

    public void setAvailableServices(Byte availableServices) {
        this.availableServices = availableServices;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getStudents() {
        return students;
    }

    public void setStudents(Integer students) {
        this.students = students;
    }

    public Integer getLessons() {
        return lessons;
    }

    public void setLessons(Integer lessons) {
        this.lessons = lessons;
    }

    public BigDecimal getScores() {
        return scores;
    }

    public void setScores(BigDecimal scores) {
        this.scores = scores;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Integer getRegionID() {
        return regionID;
    }

    public void setRegionID(Integer regionID) {
        this.regionID = regionID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getZoneID() {
        return zoneID;
    }

    public void setZoneID(String zoneID) {
        this.zoneID = zoneID;
    }

    public String getCourseCategoryID() {
        return courseCategoryID;
    }

    public void setCourseCategoryID(String courseCategoryID) {
        this.courseCategoryID = courseCategoryID;
    }

    public String getCourseCategoryName() {
        return courseCategoryName;
    }

    public void setCourseCategoryName(String courseCategoryName) {
        this.courseCategoryName = courseCategoryName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public Byte getMonday() {
        return monday;
    }

    public void setMonday(Byte monday) {
        this.monday = monday;
    }

    public Byte getTuesday() {
        return tuesday;
    }

    public void setTuesday(Byte tuesday) {
        this.tuesday = tuesday;
    }

    public Byte getWednesday() {
        return wednesday;
    }

    public void setWednesday(Byte wednesday) {
        this.wednesday = wednesday;
    }

    public Byte getThursday() {
        return thursday;
    }

    public void setThursday(Byte thursday) {
        this.thursday = thursday;
    }

    public Byte getFriday() {
        return friday;
    }

    public void setFriday(Byte friday) {
        this.friday = friday;
    }

    public Byte getSaturday() {
        return saturday;
    }

    public void setSaturday(Byte saturday) {
        this.saturday = saturday;
    }

    public Byte getSunday() {
        return sunday;
    }

    public void setSunday(Byte sunday) {
        this.sunday = sunday;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public BigDecimal getPriceLowest() {
        return priceLowest;
    }

    public void setPriceLowest(BigDecimal priceLowest) {
        this.priceLowest = priceLowest;
    }
}
