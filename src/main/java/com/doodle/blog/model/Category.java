package com.doodle.blog.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Category implements Serializable {
    private long categoryId;
    private String categoryName;
    private long userId;
}
