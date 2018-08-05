package com.doodle.blog.mapper;

import com.doodle.blog.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Insert("INSERT INTO USER (user_name, nick_name, password, email) VALUES (#{userName}, #{nickName}, " +
            "#{password}, #{email})")
    int insertUser(User user);

    @Select("SELECT user_id AS userId, user_name AS userName, nick_name AS nickName, password FROM USER " +
            "where user_name = #{userName}")
    User queryUserByName(String userName);

    @Select("SELECT user_id AS userId, user_name AS userName, nick_name AS nickName, password FROM USER " +
            "where user_id = #{userId}")
    User queryUserById(long userId);

    @Update("UPDATE USER SET password = #{password} WHERE user_id = #{userId}")
    int updatePassword(@Param("userId") long userId, @Param("password") String password);

    @Update("UPDATE USER SET nick_name = #{nickName} WHERE user_id = #{userId}")
    int updateNickName(@Param("userId")long userId, @Param("nickName") String nickName);
}
