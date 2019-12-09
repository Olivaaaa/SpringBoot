package com.example.aop.controller;

import com.example.aop.service.CommonService;
import com.example.aop.service.order.OrderInfoService;
import com.example.aop.service.user.UserInfoService;
import com.example.aop.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class IndexController {
    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Resource
    CommonService service;

    @Resource
    OrderInfoService orderSrvice;

    @Resource
    UserInfoService userInfoService;

    @RequestMapping(value = {"/**", "/"}, method = RequestMethod.GET)
    public Long testAop() {
        logger.info("\n=======SPRING AOP========\n");
        int i = 1;
        i = CommonUtil.add(i);
        i = service.add(i);

        logger.info("结果是：" + i);
        String name = "######";
        name = orderSrvice.addOrderInfo(name);
        name = userInfoService.addUserInfo(name);
        logger.info("名称是：" + name);
        return System.currentTimeMillis();

    }
}
