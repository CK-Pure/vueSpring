package com.example.datamanage.controller;

import com.example.datamanage.entity.User;
import com.example.datamanage.mapper.UserMapper;
import com.example.datamanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;
    @GetMapping
    public List<User> index(){
        return userMapper.findAll();
    }

    @PostMapping
    public Integer save(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id){
        return userMapper.deleteById(id);
    }
}
