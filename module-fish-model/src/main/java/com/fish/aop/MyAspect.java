package com.fish.aop;

import org.aspectj.lang.annotation.*;

/**
 * @Author: 周大伟
 * @Date: 2019/1/7 13:39
 */
@Aspect
public class MyAspect {

    @Pointcut("@annotation(com.fish.aop.ZJTest)")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(){
        System.out.println("before.......");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("after........");
    }

    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("afterReturning.......");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("afterThrowing........");
    }



}
