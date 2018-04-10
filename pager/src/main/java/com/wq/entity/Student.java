package com.wq.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by wuqingvika on 2018/4/10.
 */
public class Student implements Serializable{
    private int id;
    private String name;
    private int age;
    private int gender;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student() {
    }

    public Student(int id, String name, int age, int gender, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public Student(Map<String, Object> map) {
        this.id = (Integer)map.get("id");
        this.name = (String)map.get("name");
        this.age = (Integer) map.get("age");
        this.gender = (Integer)map.get("gender");
        this.address = (String)map.get("address");
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }
}
