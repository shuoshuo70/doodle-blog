package com.doodle.blog.service;

import com.doodle.blog.model.User;

public interface IUserService {
    int register(User user);

    User login(String userName, String password);

    int updatePassword(long userId, String newPassword);

    int updateNickName(long userId, String nickName);

    User findUser(long userId);

    boolean existUserName(String userName);

    boolean existNickName(String nickName);
}
