package com.springboot.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class HelloworldApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HelloworldApplication.class, args);
        System.out.println("********");
        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String name:beanNames){
            System.out.println(name);
        }

    }

}
