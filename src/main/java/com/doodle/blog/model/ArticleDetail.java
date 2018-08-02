package com.doodle.blog.model;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class ArticleDetail implements Serializable {
    private long articleDetailId;
    private long articleId;
    private String content;
    private int likes;
    private int hits;
    private Timestamp modifyTime;
}
