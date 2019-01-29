package com.fish.consumer.controller;

import com.fish.consumer.bean.Depart;
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
    private RestTemplate restTemplate;

    @PostMapping("/save")
    public boolean saveHandle(Depart depart){
        String url = "http://localhost:8081/provider/depart/save";
        return restTemplate.postForObject(url,depart,Boolean.class);
    }

    @DeleteMapping("/del/{id}")
    public void deleteHandle(@PathVariable("id") int id){
        String url = "http://localhost:8081/provider/depart/del/"+id;
        restTemplate.delete(url);
    }

    @PutMapping("/update")
    public void updateHandel(Depart depart){
        String url = "http://localhost:8081/provider/depart/update";
        restTemplate.put(url,depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id){
        String url = "http://localhost:8081/provider/depart/get/"+id;
        return restTemplate.getForObject(url,Depart.class);
    }

    @GetMapping("/list")
    public List<Depart> listHandle(){
        String url = "http://localhost:8081/provider/depart/list";
        return restTemplate.getForObject(url,List.class);
    }

}
