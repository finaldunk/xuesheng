package com.sm.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

@Data
public class Student {

    @TableId(value = "Id")
    private long Id;
    private String Name;
    private String Sex;
    private String status;
    private int Grade;
    private String Letter;
    private int Phone;
    private String Place;
    private int Age;



    //一对一，就令这里写对多的表
    @TableField(exist = false)
    private List<UserForm> userFormList;

    public List<UserForm> getUserFormList() {
        return userFormList;
    }

    public void setUserFormList(List<UserForm> userFormList) {
        this.userFormList = userFormList;
    }

    public Student(long id) {
        Id = id;
    }

    public Student(long id, String status) {
        Id = id;
        this.status = status;
    }

    public Student(long id, String status, int age) {
        Id = id;
        this.status = status;
        Age = age;
    }

    public Student(String name, int phone) {
        Name = name;
        Phone = phone;
    }

    public Student(long id, String name, String sex, String status, int grade, String letter, int phone, String place,int age) {
        Id = id;
        Name = name;
        Sex = sex;
        this.status = status;
        Grade = grade;
        Letter = letter;
        Phone = phone;
        Place = place;
        Age = age;
    }


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    public String getLetter() {
        return Letter;
    }

    public void setLetter(String letter) {
        Letter = letter;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Sex='" + Sex + '\'' +
                ", status='" + status + '\'' +
                ", Grade=" + Grade +
                ", Letter='" + Letter + '\'' +
                ", Phone=" + Phone +
                ", Place='" + Place + '\'' +
                ", Age=" + Age +
                ", userFormList=" + userFormList +
                '}';
    }
}
