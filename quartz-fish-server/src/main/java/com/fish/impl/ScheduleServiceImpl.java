package com.fish.impl;

import com.fish.aop.ASTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Author: 周大伟
 * @Date: 2019/1/2 16:43
 */
@Service
public class ScheduleServiceImpl {

    int count1 = 1;
    int count2 = 1;

    //@Scheduled(cron = "0-30 * * * * ?")
    @Async
    public void job1(){
        System.out.println("【"+Thread.currentThread().getName()+"】"+"【job1】每秒执行一次，执行第【"+count1+"】次");
        count1 ++;
        printStr();
    }

    //@Scheduled(cron = "31-59 * * * * ?")
    @Async
    public void job2(){
        System.out.println("【"+Thread.currentThread().getName()+"】"+"【job2】每秒执行一次，执行第【"+count2+"】次");
        count2 ++;
        printStr();
    }

    @ASTest
    public void printStr(){
        System.out.println("sssssssssssssssssssssssssssss");
    }

}
