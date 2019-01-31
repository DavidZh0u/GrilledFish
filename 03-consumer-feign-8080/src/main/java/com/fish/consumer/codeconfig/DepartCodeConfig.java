package com.fish.consumer.codeconfig;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 周大伟
 * @Date: 2019/1/29 16:41
 */
@Configuration
public class DepartCodeConfig {

    //开启消费者端的负载均衡，默认是轮询策略
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
