package com.doodle.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class Tag implements Serializable {
    private long tagId;
    private String tagName;
    private long userId;
    private Timestamp createTime;
}
