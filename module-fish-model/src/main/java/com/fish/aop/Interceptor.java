package com.fish.aop;

import org.aopalliance.intercept.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: 周大伟
 * @Date: 2018/12/28 11:21
 */
public interface Interceptor {

    /**事前方法*/
    public boolean before();

    /**事后方法*/
    public void after();

    /***/
    public Object around(Invocation invocation)
        throws Throwable;

    /**事后返回方法，事件没有发生异常执行*/
    public void afterReturning();

    /**事后异常方法，当事件发生异常后执行*/
    public void afterThrowing();

    /**是否使用around方法取代原有的方法*/
    boolean useAround();


}
