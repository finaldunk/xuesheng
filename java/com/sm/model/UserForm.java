package com.sm.model;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;


@Data
public class UserForm {
    private long username;
    private String password;
    private int Role;

    @TableField(exist = false)
    private String relName;



    public UserForm(long username, String password, int role) {
        this.username = username;
        this.password = password;
        Role = role;
    }

    public UserForm(long username, String password, int role, String relName) {
        this.username = username;
        this.password = password;
        Role = role;
        this.relName = relName;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "username=" + username +
                ", password='" + password + '\'' +
                ", Role=" + Role +
                ", relName='" + relName + '\'' +
                '}';
    }

    public long getUsername() {
        return username;
    }

    public String getRelName() {
        return relName;
    }

    public void setRelName(String relName) {
        this.relName = relName;
    }

    public void setUsername(long username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return Role;
    }

    public void setRole(int role) {
        Role = role;
    }
}
