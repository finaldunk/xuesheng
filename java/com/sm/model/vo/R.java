package com.sm.model.vo;

public class R {
    private Boolean flag;  //查看是否成功获得数据
    private Object data;   //数据空为null，同时flag返回false

    public R(){}

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    @Override
    public String toString() {
        return "R{" +
                "flag=" + flag +
                ", data=" + data +
                '}';
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    
}
