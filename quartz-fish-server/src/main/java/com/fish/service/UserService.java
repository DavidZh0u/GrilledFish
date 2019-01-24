package com.fish.service;

import com.fish.entity.User;

/**
 * @Author: 周大伟
 * @Date: 2019/1/7 15:06
 */
public interface UserService {

    User getUser();

    User newUser(User user);
}
