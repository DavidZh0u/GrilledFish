package com.fish.provider.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author: 周大伟
 * @Date: 2019/1/24 16:13
 */
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","fieldHandler"})
public class Depart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String dbase;

}
