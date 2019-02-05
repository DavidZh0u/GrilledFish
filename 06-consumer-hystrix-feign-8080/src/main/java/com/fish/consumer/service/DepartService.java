package com.fish.consumer.service;

import com.fish.consumer.bean.Depart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 周大伟
 * @Date: 2019/1/24 18:06
 */
@Service
//指定当前Service所绑定的提供者微服务名称
@FeignClient(value = "zdwmsc-provider-departs",fallbackFactory = DepartFallbackFactory.class)
@RequestMapping("/provider/depart")
public interface DepartService {

    @PostMapping("/save")
    boolean saveDepart(Depart depart);

    @DeleteMapping("/del/{id}")
    boolean removeDepartById(@PathVariable("id") int id);

    @PutMapping("/update")
    boolean modifyDepart(Depart depart);

    @GetMapping("/get/{id}")
    Depart getDepartById(@PathVariable("id") int id);

    @GetMapping("/list")
    List<Depart> listAllDeparts();

}
