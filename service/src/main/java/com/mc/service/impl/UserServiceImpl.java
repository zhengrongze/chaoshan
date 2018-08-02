package com.mc.service.impl;

import com.mc.entity.User;
import com.mc.enums.ExceptionEnum;
import com.mc.exception.OverException;
import com.mc.mapper.UserMapper;
import com.mc.response.ResponseMessage;
import com.mc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName UserServiceImpl
 * @Author ZhengRongZe
 * @Date 2018/7/25 22:29
 **/
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public void add() {
        User user = new User();
        user.setUsername("rongze");
        user.setPassword("123456");
//        if(user.getUsername().equals("rongze")){
//            throw new OverException(ExceptionEnum.USER_NOT_EXIST);
//        }
        LOGGER.debug("=======DEBUG=======");
        LOGGER.info("========INFO====dss是打算大所大所===");
        LOGGER.warn("========WARN=======");
        LOGGER.error("=======ERROR=======");
        userMapper.insert(user);
    }
}
