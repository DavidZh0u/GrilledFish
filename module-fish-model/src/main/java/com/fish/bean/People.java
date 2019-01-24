package com.fish.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: 周大伟
 * @Date: 2018/12/25 13:51
 */
@Data
@Component
@ConfigurationProperties(prefix = "david")
@PropertySource(value = "classpath:config/david.properties",encoding = "UTF-8")
public class People {

    private String name;

    private String sex;

    private String age;

}
