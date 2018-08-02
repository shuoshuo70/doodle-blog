package com.doodle.blog.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Comment implements Serializable {
    private long commentId;
    private long commenterId;
    private long articleId;
    private String content;
    private Date createTime;
    private boolean isDeleted;
}
