package com.fish.aop;

import org.aopalliance.intercept.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: 周大伟
 * @Date: 2018/12/28 11:39
 */
public class MyInterceptor implements Interceptor {

    @Override
    public boolean before() {
        System.out.println("before ......");
        return true;
    }

    @Override
    public boolean useAround() {
        return true;
    }

    @Override
    public void after() {
        System.out.println("after .......");
    }

    @Override
    public Object around(Invocation invocation) throws Throwable {
        System.out.println("around before ......");

        Object obj = invocation.proceed();

        System.out.println("around after ...... ");
        return  obj;
    }

    @Override
    public void afterReturning() {
        System.out.println("afterReturning.......");
    }

    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing.......");
    }
}
