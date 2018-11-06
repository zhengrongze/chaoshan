package com.mc.controller;

import com.mc.entity.User;
import com.mc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

        userService.add();
        return "success";
    }
    @RequestMapping("/oneToOne")
    public List<User> oneToOne(){
        return userService.oneToOne();
    }
}
