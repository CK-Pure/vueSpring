package com.example.datamanage.mapper;

import com.example.datamanage.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from sys_user")
    List<User> findAll();

    @Insert("insert into sys_user(username,password,nickname,email,phone,address) "+
            "values(#{username},#{password},#{nickname},#{email},#{phone},#{address})")
    int insert(User user);


    int update(User user);

    @Delete("delete from sys_user where id=#{id}")
    Integer deleteById(@Param("id") Integer id);
}