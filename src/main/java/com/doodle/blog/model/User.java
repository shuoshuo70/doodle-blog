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
}
