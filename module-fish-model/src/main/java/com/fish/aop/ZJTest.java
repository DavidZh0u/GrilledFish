package com.fish.aop;

import java.lang.annotation.*;

/**
 * @Author: 周大伟
 * @Date: 2019/1/7 13:50
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ZJTest {

}
