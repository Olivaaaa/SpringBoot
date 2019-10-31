package com.example.aop.aop;

import com.alibaba.fastjson.JSON;
import com.example.aop.utils.DateUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.aop.utils.DateUtil;

@Component
@Aspect
@Order(1)
public class LoggerHandlerAop {

    private final static Logger logger = LoggerFactory.getLogger(LoggerHandlerAop.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    //匹配service包下及包下任何方法执行
    @Pointcut(value = "execution(* com.example.aop.service.*.*(..))")
    public void log1(){}

    @Pointcut(value = "execution(* *..service.*.*(..))")
    public void log2() {
    }

    // 匹配任何包下的service包及子包下的任何方法执行(该模式能匹配到任何多级的子包下的方法执行)
    @Pointcut(value = "execution(* *..service..*(..))")
    public void log3() {
    }

    // 匹配返回值类型为java.lang.String的任何包下的service包及子包下的方法执行
    @Pointcut(value = "execution(java.lang.String *..service..*(..))")
    public void log4() {
    }

    // 匹配返回值类型为int的任何包下的service包及子包下的方法执行
    @Pointcut(value = "execution(int *..service..*(..))")
    public void log5() {
    }

    @Pointcut(value = "execution(* com.example.aop..add*(String))")
    public void log6(){};

    @Pointcut(value = "@annotation(com.example.aop.annotation.timebuskerMethod)")
    public void logaa1() {
    }

    @Before("logaa1()")
    public void beforeAdvice(JoinPoint point){
        logger.info("SSSSSSSSSSS");
        logger.info("before"+DateUtil.now());
        Signature signature = point.getSignature();
        logger.info("所属类："+signature.getDeclaringTypeName()+"代理类:" + signature.getClass() + "方法："+signature.getName() + "类名："+signature.getDeclaringType());
        Object[] args = point.getArgs();
        logger.info("参数：" + JSON.toJSONString(args));
        logger.info("被植入的对象是："+point.getTarget());
        logger.info("EEEEEEE");

    }

    /**
     * 返回后通知：在连接点正常执行完后执行的通知
     */
    @AfterReturning("logaa1()")
    public void afterReturningAdvice() {
        logger.info("LoggerHandlerAop.afterReturningAdvice...time:" + DateUtil.now());
    }

    /**
     * 抛出异常后通知：在连接节点抛出异常退出时执行的通知
     */
    @AfterThrowing("logaa1()")
    public void afterThrowingAdvice() {
        logger.info("LoggerHandlerAop.afterThrowingAdvice...time:" + DateUtil.now());
    }

    /**
     * 后置通知：当某连接节点退出的时候执行的通知（不论是正常返回还是异常退出）
     */
    @After("logaa1()")
    public void afterFinallyAdvice() {
        logger.info("LoggerHandlerAop.afterFinallyAdvice...time:" + DateUtil.now());
    }

    /**
     * 环绕通知：包围一个连接点（join point）的通知
     * 可以实现改变方法参数并执行方法
     */
    @Around(value = "logaa1()")
    public Object aroundAdavice(ProceedingJoinPoint joinPoint){
        logger.info("LoggerHandlerAop.aroundAdvice..."+DateUtil.now());
        Object obj = null;
        try {
            Object[] args = joinPoint.getArgs();
            System.out.println("MoocAspect around 1.");
            obj = joinPoint.proceed();
            System.out.println("around 2");

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }







}
