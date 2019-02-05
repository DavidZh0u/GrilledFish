package com.fish.consumer.controller;

import com.fish.consumer.bean.Depart;
import com.fish.consumer.service.DepartService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.List;

/**
 * @Author: 周大伟
 * @Date: 2019/1/29 17:00
 */
@RestController
@RequestMapping("/consumer/depart")
public class DepartController {

    @Autowired
    private DepartService service;


    @PostMapping("/save")
    public boolean saveHandle(Depart depart){
        return service.saveDepart(depart);
    }

    @DeleteMapping("/del/{id}")
    public boolean deleteHandle(@PathVariable("id") int id){
        return service.removeDepartById(id);
    }

    @PutMapping("/update")
    public boolean updateHandel(Depart depart){
        return service.modifyDepart(depart);
    }

    // 服务降级，若当前处理器方法发生异常，则执行fallbackMethod属性制定的方法
    @HystrixCommand(fallbackMethod = "getHystrixHandle")
    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id){
        Depart depart = service.getDepartById(id);
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
        return service.listAllDeparts();
    }

}
