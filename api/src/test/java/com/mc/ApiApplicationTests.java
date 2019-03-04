package com.mc;

import com.mc.service.redis.client.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiApplicationTests {
	@Autowired
	private RedisDao redisDao;
	@Test
	public void exits() {
		 redisDao.exists("sss");
	}

}
