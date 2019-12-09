package cn.timebusker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        String[] benaNames = ctx.getBeanDefinitionNames();
        Arrays.sort(benaNames);
        for (String beanName:benaNames){
            System.out.println(beanName);
        }
    }
}
