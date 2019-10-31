package com.example.aop.service.user.Impl;

import com.example.aop.annotation.timebuskerMethod;
import com.example.aop.service.user.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final static Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);


    @Override
    @timebuskerMethod
    public String addUserInfo(String name) throws IllegalArgumentException {
        logger.info("新增的用户姓名是："+ name);
        return name + "U";
    }
}
