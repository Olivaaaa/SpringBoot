package com.example.aop.aop;

import com.example.aop.utils.DateUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ServiceHandlerAop {
    private final static Logger logger = LoggerFactory.getLogger(ServiceHandlerAop.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 切入点：匹配连接点的断言
     */
    @Pointcut("execution(public * *..service..*(..))")
    public void service() {
    }

    /**
     * 前置通知：在连接点执行前的通知，但不能阻止连接点前的执行（除非它抛出一个异常）
     */
    @Before("service()")
    public void beforeAdvice() {
        logger.info("ServiceHandlerAop.beforeAdvice...time:" + DateUtil.now());
    }
}
