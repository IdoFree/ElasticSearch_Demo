package com.example.demo.model;

import javafx.util.Builder;

/**
 * Created by Ido on 2017/7/14.
 */
public class Teacher implements Builder<Teacher>{
    private int age;
    private String name;
    private String gender;
    private int id;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Teacher build() {

        this.gender="male";
        this.age = 18;
        return this;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", id=" + id +
                '}';
    }
}
