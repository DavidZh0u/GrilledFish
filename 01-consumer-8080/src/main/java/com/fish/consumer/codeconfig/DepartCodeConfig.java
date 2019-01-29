package com.fish.consumer.codeconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 周大伟
 * @Date: 2019/1/29 16:41
 */
@Configuration
public class DepartCodeConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
