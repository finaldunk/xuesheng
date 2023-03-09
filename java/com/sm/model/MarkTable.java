package com.sm.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "MarkTable")
public class MarkTable {

    private long Id;
    private int Course_id;

    float Pmark;
    float Kmark;
    float Fmark;

    public MarkTable() {
    }

    public MarkTable(long id, int course_Id, float PMark, float KMark, float FMark) {
        Id = id;
        Course_id = course_Id;
        this.Pmark = PMark;
        this.Kmark = KMark;
        this.Fmark = FMark;
    }

    public MarkTable(long id, int course_Id) {
        Id = id;
        Course_id = course_Id;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public int getCourse_Id() {
        return Course_id;
    }

    public void setCourse_Id(int course_Id) {
        Course_id = course_Id;
    }

    public float getPmark() {
        return Pmark;
    }

    public void setPmark(float pmark) {
        this.Pmark = pmark;
    }

    public float getKmark() {
        return Kmark;
    }

    public void setKmark(float kmark) {
        this.Kmark = kmark;
    }

    public float getFmark() {
        return Fmark;
    }

    public void setFmark(float fmark) {
        this.Fmark = fmark;
    }
}
