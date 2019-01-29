package com.fish.provider.service;

import com.fish.provider.bean.Depart;

import java.util.List;

/**
 * @Author: 周大伟
 * @Date: 2019/1/24 18:06
 */
public interface DepartService {

    boolean saveDepart(Depart depart);

    boolean removeDepartById(int id);

    boolean modifyDepart(Depart depart);

    Depart getDepartById(int id);

    List<Depart> listAllDeparts();

}
