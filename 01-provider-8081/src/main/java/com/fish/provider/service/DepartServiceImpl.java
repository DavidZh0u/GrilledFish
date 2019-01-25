package com.fish.provider.service;

import com.fish.provider.bean.Depart;
import com.fish.provider.repository.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: 周大伟
 * @Date: 2019/1/25 10:23
 */
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartRepository repository;

    @Override
    public boolean saveDepart(Depart depart) {
        Depart result = repository.save(depart);
        if (result != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeDepartById(int id) {
        return false;
    }

    @Override
    public boolean modifyDepart(int id, Depart depart) {
        return false;
    }

    @Override
    public Depart getDepartById(int id) {
        return null;
    }

    @Override
    public List<Depart> listAllDeparts() {
        return null;
    }
}
