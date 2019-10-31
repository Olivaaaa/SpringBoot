package com.example.aop.service.order;

import com.example.aop.annotation.timebuskerBean;
import com.example.aop.service.order.Impl.OrderInfoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@timebuskerBean
public interface OrderInfoService {

    String addOrderInfo(String name);

}
