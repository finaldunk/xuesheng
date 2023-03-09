package com.sm.model;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "pick")
public class pick {
    private String Tid;
    private String Pid;//产品编号
    private int Num;

    @Override
    public String toString() {
        return "pick{" +
                "Tid='" + Tid + '\'' +
                ", Pid='" + Pid + '\'' +
                ", Num=" + Num +
                '}';
    }

    public String getTid() {
        return Tid;
    }

    public void setTid(String tid) {
        Tid = tid;
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

    public pick(String tid, String pid, int num) {
        Tid = tid;
        Pid = pid;
        Num = num;
    }
}
