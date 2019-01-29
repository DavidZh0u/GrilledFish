package com.fish.provider.controller;

import com.fish.provider.bean.Depart;
import com.fish.provider.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 周大伟
 * @Date: 2019/1/29 14:20
 */
@RequestMapping("/provider/depart")
@RestController
public class DepartController {

    @Autowired
    private DepartService departService;

    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Depart depart){
        depart.setDbase("scdb");
        return departService.saveDepart(depart);
    }

    @DeleteMapping("/del/{id}")
    public boolean deleteHandle(@PathVariable("id") int id){
        return departService.removeDepartById(id);
    }

    @PutMapping("/update")
    public boolean updateHandel(@RequestBody Depart depart){
        depart.setDbase("scdb");
        return departService.modifyDepart(depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id){
        return departService.getDepartById(id);
    }

    @GetMapping("/list")
    public List<Depart> listHandle(){
        return departService.listAllDeparts();
    }





}
