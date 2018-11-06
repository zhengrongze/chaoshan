package com.mc.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
@Component
public class HelloSender2 {
    @Autowired
    private AmqpTemplate amqpTemplate;
    //发送任务
    public void send(){
        String content = "hello" + new Date();
        System.out.println("sender2+ ........." + content);
        amqpTemplate.convertAndSend("hello",content);
    }
}