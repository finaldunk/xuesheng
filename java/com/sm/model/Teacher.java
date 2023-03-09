package com.sm.model;

import com.baomidou.mybatisplus.annotation.TableField;

public class Teacher {
    private long Tid;
    private String Tname;
    private String Temil;
    private int Tphone;

    @TableField(exist = false)
    private UserForm userForm;

    public UserForm getUserForm() {
        return userForm;
    }

    public void setUserForm(UserForm userForm) {
        this.userForm = userForm;
    }

    public Teacher(long tid) {
        Tid = tid;
    }

    public Teacher(int tid, String tname, String temil, int tphone) {
        Tid = tid;
        Tname = tname;
        Temil = temil;
        Tphone = tphone;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "Tid=" + Tid +
                ", Tname='" + Tname + '\'' +
                ", Temil='" + Temil + '\'' +
                ", Tphone=" + Tphone +
                ", userForm=" + userForm +
                '}';
    }

    public long getTid() {
        return Tid;
    }

    public void setTid(int tid) {
        Tid = tid;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public String getTemil() {
        return Temil;
    }

    public void setTemil(String temil) {
        Temil = temil;
    }

    public int getTphone() {
        return Tphone;
    }

    public void setTphone(int tphone) {
        Tphone = tphone;
    }
}
