package com.example.aop.service;

import com.example.aop.annotation.timebuskerBean;
import com.example.aop.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@timebuskerBean
public class CommonService {

    private final static Logger logger = LoggerFactory.getLogger(CommonUtil.class);

    public int add(int i){
        i = i+1;
        logger.info("CommonService：" + i);
        return i;
    }
}
