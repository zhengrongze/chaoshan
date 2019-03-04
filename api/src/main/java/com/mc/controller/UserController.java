package com.mc.controller;

import com.mc.entity.User;
import com.mc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Author ZhengRongZe
 * @Date 2018/7/25 22:51
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/test")
    public String add(){
        User user = new User();
        user.setUsername("rongze");
        user.setPassword("123456");
        userService.save(user);
        return "success";
    }
}
