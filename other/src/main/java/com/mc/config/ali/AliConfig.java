package com.mc.config.ali;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName AliConfig
 * @Author ZhengRongZe
 * @Date 2019/3/1 10:34
 **/
@Component
@PropertySource("classpath:ali.properties")
@ConfigurationProperties(prefix = "ali")
@Data
public class AliConfig {
    private String AppId;
    private String gatewayUrl;
    private String merchantPrivateKey;
    private String publicKey;
}
