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
<<<<<<< HEAD
    private WechatApi wechatApi;

    @ApiOperation(value = "测试",notes="添加用户操作")
    @GetMapping("/test")
    public String add() throws WxErrorException {
        User user = new User();
        user.setUsername("323232");
        user.setPassword("123456");
        userService.save(user);
=======
    @Autowired
    private WechatApi wechatApi;
    @Autowired
    private AliConfig aliConfig;
    @ApiOperation(value = "测试",notes="添加用户操作")
    @GetMapping("/test")
    public String add() throws WxErrorException {
//        User user = new User();
//        user.setUsername("323232");
//        user.setPassword("123456");
        Menu m1 = new Menu("郑荣泽");
        Menu m11 = new Menu("java", EventType.view.name(),"https://www.baidu.com");
        Menu m12 = new Menu("mysql", EventType.view.name(),"https://www.baidu.com");
        Menu m13 = new Menu("商务合作", EventType.view.name(),"https://www.baidu.com");
        Menu m2 = new Menu("团队");
        Menu m21 = new Menu("团队信息", EventType.view.name(),"https://www.baidu.com");
        Menu m3 = new Menu("潮衫");
        Menu m31 = new Menu("短袖", EventType.view.name(),"https://www.baidu.com");
        Menu m32 = new Menu("短裤", EventType.view.name(),"https://www.baidu.com");
        Menu m33 = new Menu("长袖", EventType.view.name(),"https://www.baidu.com");
        Menu m34 = new Menu("风衣", EventType.view.name(),"https://www.baidu.com");
        Menu m35 = new Menu("小程序", EventType.view.name(),"https://www.baidu.com");
        m1.setSubButtons(Arrays.asList(m11,m12,m13));
        m2.setSubButtons(Arrays.asList(m21));
        m3.setSubButtons(Arrays.asList(m31,m32,m33,m34));
        List<Menu> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        wechatApi.createMenu(list);
//        userService.save(user);

>>>>>>> a54e1a8d53334c72395b986158e43b73a1ee0191
        return "success";
    }
}
