package com.doodle.blog.model;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
public class User implements Serializable {
    private long userId;
    private String userName;
    private String nickName;
    private String password;
    private String email;
    private Timestamp createTime;
    private boolean isActive;

    public User(String userName, String nickName, String password, String email) {
        this.userName = userName;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
    }

    public User(long userId, String userName, String nickName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.nickName = nickName;
        this.password = password;
    }
}
