package com.mc.controller;

import com.mc.EventType;
import com.mc.config.ali.AliConfig;
import com.mc.entity.User;
import com.mc.redis.client.ICache;
import com.mc.service.UserService;
import com.mc.wechat.api.WechatApi;
import com.mc.wechat.vo.menu.Menu;
import io.swagger.annotations.ApiOperation;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
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
    @Autowired
    private ICache iCache;
    private WechatApi wechatApi;

    @ApiOperation(value = "测试",notes="添加用户操作")
    @GetMapping("/test")
    public String add() throws WxErrorException {
        User user = new User();
        user.setUsername("323232");
        user.setPassword("123456");
        userService.save(user);
        return "success";
    }
}
