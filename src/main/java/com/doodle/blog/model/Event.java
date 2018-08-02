package com.doodle.blog.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Event implements Serializable {
    private int eventId;
    private String eventName;
}
