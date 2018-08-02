package com.doodle.blog.model;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
public class Article implements Serializable {
    private long articleId;
    private long authorId;
    private String tagIds;
    private int categoryId;
    private String title;
    private Timestamp createTime;
    private boolean isDeleted;
}