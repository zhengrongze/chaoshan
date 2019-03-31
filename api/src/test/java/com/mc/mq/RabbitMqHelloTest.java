package com.mc.mq;

import com.mc.send.HelloSender;
import com.mc.send.HelloSender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {
    @Autowired
    private HelloSender helloSender;
    @Autowired
    private HelloSender2 helloSender2;
    @Test
    public void send()  throws Exception{
       Date date = new Date(System.currentTimeMillis());
        for (int i=0;i<10;i++){
            helloSender.send();
        }
        Date now = new Date(System.currentTimeMillis());
        System.out.println(now.getTime() - date.getTime()+"---------------------------------------------");
    }
}
