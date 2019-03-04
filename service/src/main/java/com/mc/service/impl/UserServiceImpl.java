package com.mc.service.impl;

import com.mc.entity.User;
import com.mc.mapper.UserMapper;
import com.mc.service.BaseService;
import com.mc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName UserServiceImpl
 * @Author ZhengRongZe
 * @Date 2018/7/25 22:29
 **/
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private  Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Resource
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
        super.setMyMapper(userMapper);
    }
    @Transactional
    @Override
    public void save(User eniity) {
        userMapper.insert(eniity);
    }
}
