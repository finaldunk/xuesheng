package com.sm.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Course {

    @TableId(value = "Cid")
    private int Cid;

    private long Tid;
    private String Cname;
    private String Cteacher;
    private String Introduce;
    private Double Credit;
    private int People;

    public Course() {
    }

    public Course(int cid, String cname, String cteacher, String introduce, Double credit, int people) {
        Cid = cid;
        Cname = cname;
        Cteacher = cteacher;
        Introduce = introduce;
        Credit = credit;
        People = people;
    }

    public Course(int cid, long tid, String cname, String cteacher, String introduce, Double credit, int people) {
        Cid = cid;
        Tid = tid;
        Cname = cname;
        Cteacher = cteacher;
        Introduce = introduce;
        Credit = credit;
        People = people;
    }

    public long getTid() {
        return Tid;
    }

    public void setTid(long tid) {
        Tid = tid;
    }

    public Course(int Cid) {
        this.Cid = Cid;
    }

    public int getCid() {
        return Cid;
    }

    public void setCid(int cid) {
        Cid = cid;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getCteacher() {
        return Cteacher;
    }

    public void setCteacher(String cteacher) {
        Cteacher = cteacher;
    }

    public String getIntroduce() {
        return Introduce;
    }

    public void setIntroduce(String introduce) {
        Introduce = introduce;
    }

    public Double getCredit() {
        return Credit;
    }

    public void setCredit(Double credit) {
        Credit = credit;
    }

    public int getPeople() {
        return People;
    }

    public void setPeople(int people) {
        People = people;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Cid=" + Cid +
                ", Tid=" + Tid +
                ", Cname='" + Cname + '\'' +
                ", Cteacher='" + Cteacher + '\'' +
                ", Introduce='" + Introduce + '\'' +
                ", Credit=" + Credit +
                ", People=" + People +
                '}';
    }
}
