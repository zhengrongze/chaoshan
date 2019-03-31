package com.mc.config.wechat;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName WechatConfig
 * @Author ZhengRongZe
 * @Date 2019/3/4 0:03
 **/
@Component
@PropertySource("classpath:wechat.properties")
@ConfigurationProperties(prefix = "wechat")
@Data
public class WechatConfig {
    private String AppId;
    private String appSecret;
    private String token;
}
