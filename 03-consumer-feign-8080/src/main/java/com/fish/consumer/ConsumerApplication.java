package com.fish.consumer;

import com.fish.consumer.irule.CustomRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

//指定service接口所在的包，开启openfeign客户端
@EnableFeignClients(basePackages = "com.fish.consumer.service")
@SpringBootApplication
@EnableEurekaClient
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    //设置负载均衡算法为"随机算法"
/*    @Bean
    public IRule loadBalanceRule(){
        return new RandomRule();
    }*/

    @Bean
    public IRule loadBalanceRule(){
        //指定要排除的server的端口号
        List<Integer> posts = new ArrayList<>();
        posts.add(8082);
        return new CustomRule(posts);
    }


}

