package com.fish.impl;

import com.fish.aop.ASTest;
import com.fish.entity.User;
import com.fish.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: 周大伟
 * @Date: 2019/1/7 15:07
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    @ASTest
    public User getUser() {
        User user = new User();
        user.setName("David");
        user.setAge(27);
        return otherMethod(user);
    }

    @Override
    @ASTest
    public User newUser(User user){
        System.out.println("被代理的方法。。。。");
        int xx = 5 / 0;
        return user;
    }

    public User otherMethod(User user){
        user.setEmail("648349862@qq.com");
        return user;
    }

}
