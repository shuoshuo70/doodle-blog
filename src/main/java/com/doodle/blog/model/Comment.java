package com.doodle.blog.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Comment implements Serializable {
    private int commentId;
    private String content;
    private int userId;
    private Date createTime;
}
