package com.fish.provider.service;

import com.fish.provider.bean.Depart;
import com.fish.provider.repository.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 周大伟
 * @Date: 2019/1/25 10:23
 */
@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartRepository repository;

    @Override
    public boolean saveDepart(Depart depart) {
        Depart result = repository.save(depart);
        if (result != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean removeDepartById(int id) {
        //若DB中不存在该Id ,执行删除操作会抛出异常
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyDepart(Depart depart) {
        Depart result = repository.save(depart);
        if (result != null) {
            return true;
        }
        return false;

    }

    @Override
    public Depart getDepartById(int id) {
        //getOne()方法，指定的Id不存在，将抛出异常
        if(repository.existsById(id)){
            return repository.getOne(id);
        }
        Depart depart = new Depart();
        depart.setName("no this depart");
        return depart;
    }

    @Override
    public List<Depart> listAllDeparts() {
        return repository.findAll();
    }
}
