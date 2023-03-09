package com.sm.model.vo;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class co_pi_pr {
    String Tid;
    String Cid;
    private String Pid;//产品编号
    private int Num;
    private String Pname;
    private String Ben;//版本
    private float Price;

    @Override
    public String toString() {
        return "co_pi_pr{" +
                "Tid='" + Tid + '\'' +
                ", Cid='" + Cid + '\'' +
                ", Pid='" + Pid + '\'' +
                ", Num=" + Num +
                ", Pname='" + Pname + '\'' +
                ", Ben='" + Ben + '\'' +
                ", Price=" + Price +
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

    public String getPid() {
        return Pid;
    }

    public void setPid(String pid) {
        Pid = pid;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public String getBen() {
        return Ben;
    }

    public void setBen(String ben) {
        Ben = ben;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

}
