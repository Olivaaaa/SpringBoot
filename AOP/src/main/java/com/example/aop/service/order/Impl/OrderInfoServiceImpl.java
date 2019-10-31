package com.example.aop.service.order.Impl;

import com.example.aop.service.order.OrderInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    private final static Logger logger = LoggerFactory.getLogger(OrderInfoServiceImpl.class);

    @Override
    public String addOrderInfo(String name) {
        logger.info("新增的订单："+name);
        return name + "O";
    }
}
