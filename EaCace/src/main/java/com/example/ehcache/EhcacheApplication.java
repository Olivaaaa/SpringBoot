package com.example.ehcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages={"com.example.ehcache","com.service.application"})
//@EnableAutoConfiguration
//@ComponentScan({"com.example.ehcache.conf"})
//@EntityScan("com.example.ehcache.entity")
//@EnableJpaRepositories("com.example.ehcache.dao")
public class EhcacheApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(EhcacheApplication.class, args);
        System.out.println("Let's inspect the beans provided by Spring Boot:");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

    }
}
