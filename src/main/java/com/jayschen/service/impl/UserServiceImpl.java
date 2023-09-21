package com.jayschen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jayschen.entity.User;
import com.jayschen.mapper.UserMapper;
import com.jayschen.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
