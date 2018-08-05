package com.doodle.blog.controller;

import com.doodle.blog.model.User;
import com.doodle.blog.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("/auth")
@Slf4j
public class SignInController {

    @Resource
    private IUserService userService;

    @PostMapping("/login")
    public String login(@RequestParam String userName, @RequestParam String password) {
        User user = userService.login(userName, password);
        if (user != null) {
            return "SUCCESS";
        } else {
            return "FAIL";
        }
    }
}
