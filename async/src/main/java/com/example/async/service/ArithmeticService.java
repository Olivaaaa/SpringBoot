package com.example.async.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class ArithmeticService {
    private final static Logger logger = LoggerFactory.getLogger(ArithmeticService.class);
    public static final int DoTime = 5000;

    @Async
    public Future<Long> subByAsync() throws Exception{
        long start = System.currentTimeMillis();
        long sum = 0;
        Thread.sleep(DoTime);

        long end = System.currentTimeMillis();
        sum = end - start;
        logger.info("\t 完成一");

        return new AsyncResult<>(sum);
    }

    @Async
    public void subByVoid() throws Exception{
        long start = System.currentTimeMillis();
        long sum = 0;
        Thread.sleep(DoTime);

        long end = System.currentTimeMillis();
        sum = end - start;
        logger.info("\t 完成二");
        logger.info("注解完成的时间是" + sum + "(毫秒)");
    }

    public long SubBySync() throws Exception{
        long start = System.currentTimeMillis();
        long sum = 0;
        Thread.sleep(DoTime);
        long end = System.currentTimeMillis();
        sum = end - start;
        logger.info("\t 完成三");
        return sum;
    }

    @Async("getMineAsync")
    public void doMineAsync(int i) throws Exception{
        System.out.println("----\t:" + i);
        Thread.sleep(10000);
    }

}

