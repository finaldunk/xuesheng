package com.sm.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vo {

   long Id;
   int Cid;
   String Name;
   String Cname;
   String Teacher;
   int Score;

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public int getCid() {
        return Cid;
    }

    public void setCid(int cid) {
        Cid = cid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String teacher) {
        Teacher = teacher;
    }


    public Vo(long id, int cid, String name, String cname) {
        Id = id;
        Cid = cid;
        Name = name;
        Cname = cname;
    }

    public Vo(long id, int cid, String name, String cname, int score) {
        Id = id;
        Cid = cid;
        Name = name;
        Cname = cname;
        Score = score;
    }
}
