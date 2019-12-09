package com.springboot.helloworld.web;

import com.springboot.helloworld.conf.DefinitionConfig;
import com.springboot.helloworld.conf.DubboConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConfController {
    @Resource
    DefinitionConfig conf;

    @Resource
    DubboConfig dubbo;

    @RequestMapping("/conf")
    public String getConfig() {
        System.out.println(conf.toString());
        return conf.toString();
    }

    @RequestMapping("/dubbo")
    public String dubboConfig() {
        System.out.println(dubbo.toString());
        return dubbo.toString();
    }

}
