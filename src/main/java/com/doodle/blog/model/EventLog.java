package com.doodle.blog.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EventLog implements Serializable {
    private long logId;
    private int eventId;
    private long userId;
    private Date createTime;
}
