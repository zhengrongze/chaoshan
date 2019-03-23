package com.mc.service.impl;

import com.mc.entity.User;
import com.mc.mapper.UserMapper;
import com.mc.service.UserService;
import com.mc.utils.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Author ZhengRongZe
 * @Date 2018/7/25 22:29
 **/
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private Logger logger = Logger.getLogger(this.getClass());
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

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
