package com.mc;

import com.mc.entity.User;
import com.mc.service.UserService;
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
	public void contextLoads() {
		String ss = "http://locoasdoasdas/%s";

		System.out.println(String.format(ss,"headPic/defaultFactoryIcon1.png"));
	}

	@Test
	public void test(){
//		Long start = System.currentTimeMillis();
//		List<User> list = new ArrayList<User>();
//		User user;
//		for (int i=1;i<15000;i++){
//			user = new User();
//			user.setId(i);
//			user.setUsername("test" + i);
//			user.setPassword("password"+i);
//			list.add(user);
//		}
//		userService.inse(list);
//		Long end = System.currentTimeMillis();
//		System.out.println("---------------------------"+(start - end) + "-------------------------------");

		Long start1 = System.currentTimeMillis();
		List<Integer> list1 = new ArrayList<>();
		for (int i=1;i<15000;i++){
			list1.add(i);
		}
		userService.delete(list1);
		Long end1 = System.currentTimeMillis();
		System.out.println("---------------------------"+(start1 - end1) + "-------------------------------");
	}
}
