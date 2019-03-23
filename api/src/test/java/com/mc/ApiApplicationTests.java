package com.mc;

import com.mc.entity.User;
import com.mc.service.UserService;
import com.mc.wechat.api.WechatApi;
import com.mc.wechat.api.WechatApiImpl;
import com.mc.wechat.vo.menu.Menu;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiApplicationTests {
	@Autowired
	private UserService userService;
	@Test
	public void exits() {
		User user = new User();
		user.setUsername("323232");
		user.setPassword("123456");
		userService.insertUser(user);
		System.out.println(user.getId());
	}

}
