package com.fish;


import com.fish.bean.Dawei;
import com.fish.bean.People;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: 周大伟
 * @Date: 2018/12/25 11:07
 */
public class IocTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        People people = ctx.getBean(People.class);
        Dawei dawei = ctx.getBean(Dawei.class);
        System.out.println(people);
        System.out.println(dawei);

    }


}
