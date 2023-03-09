package com.sm.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "product")
public class product {
    private String Pid;
    private String Pname;
    private String Ben;//版本
    private float Price;


    public product(String pid, String pname, float price) {
        Pid = pid;
        Pname = pname;
        Price = price;
    }

    public product(String pid, String pname, String ben, float price) {
        Pid = pid;
        Pname = pname;
        Ben = ben;
        Price = price;
    }

    public String getBen() {
        return Ben;
    }

    public void setBen(String ben) {
        Ben = ben;
    }

    public String getPid() {
        return Pid;
    }

    public void setPid(String pid) {
        Pid = pid;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "product{" +
                "Pid='" + Pid + '\'' +
                ", Pname='" + Pname + '\'' +
                ", Ben='" + Ben + '\'' +
                ", Price=" + Price +
                '}';
    }
}
