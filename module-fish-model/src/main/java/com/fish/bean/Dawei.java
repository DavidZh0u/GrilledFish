package com.fish.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: 周大伟
 * @Date: 2018/12/25 16:31
 */
@Data
@Component
@ConfigurationProperties(prefix = "zhoudawei")
@PropertySource(value = "classpath:application.yml",encoding = "UTF-8")
public class Dawei {

    private String name;

    private String sex;

    private String age;

}
