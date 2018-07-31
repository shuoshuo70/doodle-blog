package com.doodle.blog.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Log implements Serializable {
    private int logId;
    private String action;
    private int userId;
    private Date createTime;
}
