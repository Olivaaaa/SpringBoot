package com.example.ehcache.controller;

import com.example.ehcache.entity.User;
import com.example.ehcache.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.alibaba.fastjson.JSON;

@Component
@RestController
@RequestMapping("/u")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService service;

    //使用id查询
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findOneUser(@PathVariable long id){
        logger.info("请求路径的id：" + id);
        User user = service.findUserById(id);
        return user;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> findAllUser(){
        logger.info("所有用户信息");
        return service.findAllUser();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User saveAndFlushUser(@ModelAttribute User user){
        logger.info("传入的参数：" + JSON.toJSONString(user));
        service.saveAndFlush(user);
        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable long id){
        User user = service.findUserById(id);
        service.deleteUserById(id);
        return user;
    }

}
