package com.example.datamanage.service.impl;

import com.example.datamanage.entity.User;
import com.example.datamanage.mapper.UserMapper;
import com.example.datamanage.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author akashi
 * @since 2022-06-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
