package com.sm.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.sql.Timestamp;

@Data
@TableName(value = "contactPick")
public class contactPick {
    String Tid;
    String Cid;
    java.sql.Timestamp Datetime;//修改时间

    public contactPick(String tid, String cid, java.sql.Timestamp datetime) {
        Tid = tid;
        Cid = cid;
        Datetime = datetime;
    }


    @Override
    public String toString() {
        return "contactPick{" +
                "Tid='" + Tid + '\'' +
                ", Cid='" + Cid + '\'' +
                ", Datetime=" + Datetime +
                '}';
    }

    public String getTid() {
        return Tid;
    }

    public void setTid(String tid) {
        Tid = tid;
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String cid) {
        Cid = cid;
    }

    public Timestamp getDatetime() {
        return Datetime;
    }

    public void setDatetime(Timestamp datetime) {
        Datetime = datetime;
    }
}
