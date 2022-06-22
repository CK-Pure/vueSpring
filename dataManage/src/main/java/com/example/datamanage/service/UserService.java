package com.example.datamanage.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.datamanage.entity.User;
import com.example.datamanage.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {


    public Boolean saveUser(User user) {
        return saveOrUpdate(user);
    }
}
