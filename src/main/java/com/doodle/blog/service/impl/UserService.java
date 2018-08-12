package com.doodle.blog.service.impl;

import com.doodle.blog.exception.AuthException;
import com.doodle.blog.mapper.UserMapper;
import com.doodle.blog.model.User;
import com.doodle.blog.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.doodle.blog.util.EncryptUtil.*;

@Service
public class UserService implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional
    public int register(User user) {
        user.setPassword(md5Encode(user.getPassword()));
        return userMapper.insertUser(user);
    }

    @Override
    public User login(String userName, String password) {
        if (!existUserName(userName)) {
            throw new AuthException("不存在该用户，请检查用户名.");
        }

        User user = userMapper.queryUserByName(userName);
        if (!user.getPassword().equals(md5Encode(password))) {
            throw new AuthException("用户名或密码错误，请检查用户名和密码.");
        }

        return user;
    }

    @Override
    public int updatePassword(long userId, String newPassword) {
        return userMapper.updatePassword(userId, newPassword);
    }

    @Override
    public int updateNickName(long userId, String nickName) {
        return userMapper.updateNickName(userId, nickName);
    }

    @Override
    public User findUser(long userId) {
        User user = userMapper.queryUserById(userId);

        if (user == null) {
            throw new AuthException("不存在该用户.");
        }

        return user;
    }

    @Override
    public boolean existUserName(String userName) {
        return false;
    }

    @Override
    public boolean existNickName(String nickName) {
        return false;
    }
}
