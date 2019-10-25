package com.example.globalexception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GlobalexceptionApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(GlobalexceptionApplication.class, args);

        System.out.println("Go");
    }

}
