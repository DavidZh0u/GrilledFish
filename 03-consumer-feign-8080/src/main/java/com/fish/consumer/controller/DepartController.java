package com.fish.consumer.controller;

import com.fish.consumer.bean.Depart;
import com.fish.consumer.service.DepartService;
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

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id){
        return service.getDepartById(id);
    }

    @GetMapping("/list")
    public List<Depart> listHandle(){
        return service.listAllDeparts();
    }

}
