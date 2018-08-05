package com.doodle.blog.mapper;

import com.doodle.blog.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertUser() {
        User user = new User("userName", "nickName", "password", "email");
        Assert.assertEquals(1, userMapper.insertUser(user));
    }

    @Test
    public void queryUserByName() {
        Assert.assertEquals(null, userMapper.queryUserByName("u"));
        Assert.assertEquals("userName", userMapper.queryUserByName("userName").getUserName());
    }

    @Test
    public void queryUserById() {
        Assert.assertEquals(null, userMapper.queryUserById(0));
        Assert.assertEquals(1, userMapper.queryUserById(1).getUserId());
    }

    @Test
    public void updatePassword() {
        Assert.assertEquals(1, userMapper.updatePassword(1, "xxx"));
        Assert.assertEquals(0, userMapper.updatePassword(0, "xxx"));
    }

    @Test
    public void updateNickName() {
        Assert.assertEquals(1, userMapper.updateNickName(1, "hah"));
        Assert.assertEquals(0, userMapper.updateNickName(0, "ww"));
    }
}