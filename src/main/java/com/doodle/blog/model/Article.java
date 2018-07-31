package com.doodle.blog.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Article implements Serializable {
    private String title;
    private String content;
    private int hits;
    private List<Integer> labelIds;
    private int userId;
    private Date createTime;
    private String status;
    private int commentCount;
}
