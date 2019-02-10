package com.fish.provider.controller;

import com.fish.provider.bean.Depart;
import com.fish.provider.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

    @Autowired
    private DiscoveryClient client;
    
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
    
    @GetMapping("/discovery")
    public Object discoveryHandle(){
        //获取服务注册列表中所有微服务名称
        List<String> springApplicationNames = client.getServices();
        for (String name : springApplicationNames) {
            //获取提供指定微服务名称服务的所有提供者主机
            List<ServiceInstance> instances = client.getInstances(name);
            for (ServiceInstance instance : instances) {
                String host = instance.getHost();
                int port = instance.getPort();
                System.out.println(host+" : "+port);
            }
        }
        return springApplicationNames;
    }


}
