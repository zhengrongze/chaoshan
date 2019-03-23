package com.mc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@PropertySource(value = "classpath:ali.properties")
@SpringBootApplication(scanBasePackages = "com.mc")
@EnableTransactionManagement
@MapperScan("com.mc.mapper")
@ServletComponentScan//这个注解是过滤器的注解
@EnableSwagger2
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
}
