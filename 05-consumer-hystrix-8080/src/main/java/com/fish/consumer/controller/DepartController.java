package com.fish.consumer.controller;

import com.fish.consumer.bean.Depart;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: 周大伟
 * @Date: 2019/1/29 17:00
 */
@RestController
@RequestMapping("/consumer/depart")
public class DepartController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/save")
    public boolean saveHandle(Depart depart){
        String url = "http://zdwmsc-provider-departs/provider/depart/save";
        return restTemplate.postForObject(url,depart,Boolean.class);
    }

    @DeleteMapping("/del/{id}")
    public void deleteHandle(@PathVariable("id") int id){
        String url = "http://zdwmsc-provider-departs/provider/depart/del/"+id;
        restTemplate.delete(url);
    }

    @PutMapping("/update")
    public void updateHandel(Depart depart){
        String url = "http://zdwmsc-provider-departs/provider/depart/update";
        restTemplate.put(url,depart);
    }

    // 服务降级，若当前处理器方法发生异常，则执行fallbackMethod属性制定的方法
    @HystrixCommand(fallbackMethod = "getHystrixHandle")
    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id){
        String url = "http://zdwmsc-provider-departs/provider/depart/get/"+id;
        Depart depart = restTemplate.getForObject(url, Depart.class);
        if(depart == null){
            throw new RuntimeException("no this depart : "+id);
        }
        return depart;
    }

    public Depart getHystrixHandle(@PathVariable("id") int id){
        Depart depart = new Depart();
        depart.setId(id);
        depart.setName("no this depart");
        depart.setDbase("no this db");
        return depart;
    }

    @GetMapping("/list")
    public List<Depart> listHandle(){
        String url = "http://zdwmsc-provider-departs/provider/depart/list";
        return restTemplate.getForObject(url,List.class);
    }

}
