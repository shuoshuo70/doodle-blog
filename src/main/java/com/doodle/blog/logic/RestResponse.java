package com.doodle.blog.logic;

import lombok.Data;

import java.io.Serializable;

@Data
public class RestResponse<T> implements Serializable {

    private boolean success;

    private long responseTime;

    private String message;

    RestResponse(boolean success) {
        this.success = success;
        this.responseTime = System.currentTimeMillis() / 1000;
    }

    RestResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static <T> RestResponse success() {
        return new RestResponse(true);
    }

    public static <T> RestResponse fail() {
        return new RestResponse(false);
    }

    public static <T> RestResponse fail(String message) {
        return new RestResponse(false, message);
    }
}
