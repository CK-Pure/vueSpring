package com.example.datamanage.service;

import com.example.datamanage.entity.User;
import com.example.datamanage.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    public int save(User user){
        if (user.getId() == null) {
            return userMapper.insert(user);
        }else {
            return userMapper.update(user);
        }
    }
}
