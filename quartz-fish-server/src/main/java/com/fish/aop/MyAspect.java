package com.fish.aop;

import com.fish.entity.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.naming.Name;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 周大伟
 * @Date: 2019/1/7 14:13
 */
@Aspect
@Component
public class MyAspect {

    @Pointcut("@annotation(com.fish.aop.ASTest)")
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

    @AfterReturning(pointcut = "pointCut()")
    public void afterReturning(JoinPoint jp){
        System.out.println("afterReturning............................start");
        System.out.println(jp.getArgs()[0]);
        System.out.println(jp.getKind());
        System.out.println(jp.getSignature().getName());
        System.out.println(jp.getSignature().getDeclaringTypeName());
        System.out.println(jp.getSignature().toLongString());
        System.out.println(jp.getSignature().toShortString());
        System.out.println(jp.getTarget().toString());

        //
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String getContextPath = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+getContextPath+"/";
        String getRemoteAddress=request.getRemoteAddr();
        String getServletPath =request.getServletPath();
        String getServletContext_getRealPath =request.getHttpServletMapping().getServletName();
//        String getServletContext_getRealPath = request.getContextPath();
        String getRequestURL =request.getRequestURL().toString();
        String getRequestURI =request.getRequestURI();
        String getQueryString = null;
        try {
            getQueryString = URLEncoder.encode(request.getQueryString(), "utf-8");
        }catch (UnsupportedEncodingException ex ){
            ex.printStackTrace();
        }
        String getRemoteUser =request.getRemoteUser();
        System.out.println("getContextPath:"+ getContextPath +"\n");
        System.out.println("basePath:"+basePath+"\n");
        System.out.println("getRemoteAddress:"+ getRemoteAddress +"\n");
        System.out.println("getServletPath:"+ getServletPath +"\n");
        System.out.println("getServletContext_getRealPath:"+ getServletContext_getRealPath +"\n");
        System.out.println("getRequestURL:"+ getRequestURL +"\n");
        System.out.println("getRequestURI:"+ getRequestURI +"\n");
        System.out.println("getQueryString:"+ getQueryString +"\n");
        System.out.println("getRemoteUser:"+ getRemoteUser +"\n");

        System.out.println("afterReturning............................end");
    }

    @AfterThrowing( pointcut = "pointCut()", throwing = "a")
    public void afterThrowing(JoinPoint point, Throwable a){
        System.out.println("AfterThrowing............................start");
        /*System.out.println("异常信息。。。"+a);*/
         System.out.println(a);

        for (Object str :a.getStackTrace()){
            System.out.println(str.toString());
        }

        System.out.println(point.getArgs()[0]);
        System.out.println(point.getKind());
        System.out.println(point.getSignature().getName());
        System.out.println(point.getSignature().getDeclaringTypeName());
        System.out.println(point.getSignature().toLongString());
        System.out.println(point.getSignature().toShortString());
        System.out.println(point.getTarget().toString());

        //
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String getContextPath = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+getContextPath+"/";
        String getRemoteAddress=request.getRemoteAddr();
        String getRemoteHost = request.getRemoteHost();
        String getServletPath =request.getServletPath();
        String getServletContext_getRealPath =request.getHttpServletMapping().getServletName();
//        String getServletContext_getRealPath = request.getContextPath();
        String getRequestURL =request.getRequestURL().toString();
        String getRequestURI =request.getRequestURI();
        String getQueryString = null;
        try {
            getQueryString = URLEncoder.encode(request.getQueryString(), "utf-8");
        }catch (UnsupportedEncodingException ex ){
            ex.printStackTrace();
        }
        String getRemoteUser =request.getRemoteUser();
        System.out.println("getContextPath:"+ getContextPath +"\n");
        System.out.println("basePath:"+basePath+"\n");
        System.out.println("getRemoteAddress:"+ getRemoteAddress +"\n");
        System.out.println("getRemoteHost:"+ getRemoteHost +"\n");
        System.out.println("getServletPath:"+ getServletPath +"\n");
        System.out.println("getServletContext_getRealPath:"+ getServletContext_getRealPath +"\n");
        System.out.println("getRequestURL:"+ getRequestURL +"\n");
        System.out.println("getRequestURI:"+ getRequestURI +"\n");
        System.out.println("getQueryString:"+ getQueryString +"\n");
        System.out.println("getRemoteUser:"+ getRemoteUser +"\n");

        /**客户端ip*/

        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        ip = ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
        System.out.println("client ip ;;;;;;;; "+ip);


        System.out.println("AfterThrowing............................end");
    }

}
