package com.doodle.blog.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class User implements Serializable {
    private int userId;
    private String userName;
    private String nickName;
    private String password;
    private String email;
    private List<Article> articles;
}
