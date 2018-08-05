package com.doodle.blog.controller;

import com.doodle.blog.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AuthException.class)
    public String authException(Exception e) {
        log.error("Auth Exception: " + e.getMessage());
        e.printStackTrace();
        return "error/400";
    }

    @ExceptionHandler(value = Exception.class)
    public String exception(Exception e) {
        log.error("Exception: " + e.getMessage());
        e.printStackTrace();
        return "error/404";
    }
}
