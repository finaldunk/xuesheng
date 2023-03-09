package com.sm.model.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class St_Sc_Co {
    private long Id;
    private String Name;
    private String Sex;
    private String status;
    private int Grade;
    private String Letter;
    private int Phone;
    private String Place;


    private Long Scid;
    private int Course_Id;
    private int Score;
    private int Pank;

    private Integer Cid;
    private String Cname;
    private String Cteacher;
    private String Introduce;
    private Double Credit;
    private int People;

    public St_Sc_Co(long id, String name, String sex, String status, int grade, String letter, int phone, String place, Long scid, int course_Id, int score, int pank, int cid, String cname, String cteacher, String introduce, Double credit, int people) {
        Id = id;
        Name = name;
        Sex = sex;
        this.status = status;
        Grade = grade;
        Letter = letter;
        Phone = phone;
        Place = place;
        Scid = scid;
        Course_Id = course_Id;
        Score = score;
        Pank = pank;
        Cid = cid;
        Cname = cname;
        Cteacher = cteacher;
        Introduce = introduce;
        Credit = credit;
        People = people;
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

    public long getId() {
        return Id;
    }

    public void setId(int id) {
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

    public Long getScid() {
        return Scid;
    }

    public void setScid(Long scid) {
        Scid = scid;
    }

    public int getCourse_Id() {
        return Course_Id;
    }

    public void setCourse_Id(int course_Id) {
        Course_Id = course_Id;
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

    @Override
    public String toString() {
        return "St_Sc_Co{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Sex='" + Sex + '\'' +
                ", status='" + status + '\'' +
                ", Grade=" + Grade +
                ", Letter='" + Letter + '\'' +
                ", Phone=" + Phone +
                ", Place='" + Place + '\'' +
                ", Scid=" + Scid +
                ", Course_Id=" + Course_Id +
                ", Score=" + Score +
                ", Pank=" + Pank +
                ", Cid=" + Cid +
                ", Cname='" + Cname + '\'' +
                ", Cteacher='" + Cteacher + '\'' +
                ", Introduce='" + Introduce + '\'' +
                ", Credit=" + Credit +
                ", People=" + People +
                '}';
    }
}
