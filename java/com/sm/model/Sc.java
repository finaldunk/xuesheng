package com.sm.model;

import com.baomidou.mybatisplus.annotation.TableField;

import java.util.List;

public class Sc {
    private long Id;
    private int Course_id;
    private int Score;
    private int Pank;

    @TableField(exist = false)
    List<Student> studentList;

    @TableField(exist = false)
    List<Course> courseList;

    public Sc(long id, int course_id) {
        Id = id;
        Course_id = course_id;
    }

    public Sc(long id, int cid, int score) {
        this.Id = id;
        this.Course_id = cid;
        this.Score = score;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Sc(long id, int courseid, String score, String pank) {
        Id = id;
        Course_id = courseid;
        if(score==null){
            Score=0;
        }else {
            Score = Integer.parseInt(score);
        }

        if(pank==null){
            Pank=0;
        }else {
            Pank = Integer.parseInt(pank);
        }
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public int getCourse_id() {
        return Course_id;
    }

    public void setCourse_id(int course_id) {
        Course_id = course_id;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public int getPank() {
        return Pank;
    }

    public void setPank(int pank) {
        Pank = pank;
    }


    public Sc(long id, int course_id, int score, int pank, List<Student> studentList, List<Course> courseList) {
        Id = id;
        Course_id = course_id;
        Score = score;
        Pank = pank;
        this.studentList = studentList;
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Sc{" +
                "Id=" + Id +
                ", Course_id=" + Course_id +
                ", Score=" + Score +
                ", Pank=" + Pank +
                ", studentList=" + studentList +
                ", courseList=" + courseList +
                '}';
    }

    public String toString1() {
        return "Sc{" +
                "Id=" + Id +
                ", Course_id=" + Course_id +
                ", Score=" + Score +
                ", Pank=" + Pank +
                '}';
    }
}
