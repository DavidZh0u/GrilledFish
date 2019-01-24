package com.fish.aop;

/**
 * @Author: 周大伟
 * @Date: 2019/1/4 14:56
 */
public class UserServiceImpl implements Userservice {

    @Override
    public void printUser(User user) {
        if(user == null){
            throw new RuntimeException("检查用户参数是否为空.......");
        }
        System.out.println("id ="+user.getId());
        System.out.println("\t username ="+user.getUsername());
        System.out.println("\t note ="+user.getNote()
        );
    }
}
