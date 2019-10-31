package com.example.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(AopApplication.class, args);
        System.out.println("***********");
        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName:beanNames){
            System.out.println(beanName);
        }

    }

}
