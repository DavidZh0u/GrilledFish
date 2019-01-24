package com.fish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
//开启AOP代理自动配置
@EnableAspectJAutoProxy
//开启异步支持
@EnableAsync
public class QuartzFishServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartzFishServerApplication.class, args);
    }

}

