package com.fish.aop;

/**
 * @Author: 周大伟
 * @Date: 2019/1/7 14:12
 */

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ASTest {

}
