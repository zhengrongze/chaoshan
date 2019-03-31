package com.mc.controller.wechat;

import com.mc.EventType;
import com.mc.wechat.api.WechatApi;
import com.mc.wechat.vo.menu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ButtonController {
    @Autowired
    private WechatApi wechatApi;
    @GetMapping(value = "button")
    public String button(){
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
        return "success";
    }
}
