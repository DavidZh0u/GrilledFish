package com.fish.controller;

import com.fish.entity.User;
import com.fish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 周大伟
 * @Date: 2019/1/7 14:39
 */
@Controller
public class UesrController {

    @Autowired
    private UserService userService;

    @RequestMapping("/print")
    @ResponseBody
    public User printStrs(){
        User u = userService.getUser();
        return u;
    }

    @RequestMapping("/user")
    @ResponseBody
    public User printUser(User user){
        User people = new User();
        people.setName(user.getName());
        people.setAge(user.getAge());
        people.setEmail("davidzhou90s@gmail.com");
        User u = userService.newUser(people);
        return u;
    }

}
