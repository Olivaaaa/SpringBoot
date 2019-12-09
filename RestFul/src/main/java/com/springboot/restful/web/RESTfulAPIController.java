package com.springboot.restful.web;

import com.alibaba.fastjson.JSON;
import com.springboot.restful.entity.DemoInfo;
import com.springboot.restful.service.DemoInfoService;
import javafx.scene.chart.ValueAxis;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.ws.Service;
import java.util.List;

@RestController
public class RESTfulAPIController {

    @Resource
    DemoInfoService service;

    @RequestMapping(value = {"/demo"}, method = RequestMethod.POST)
    public List<DemoInfo> addDemoInfo(@ModelAttribute DemoInfo demoInfo) {
        //pom文件增加fastjson版本
        System.out.println(JSON.toJSONString(demoInfo));
        return service.insertDemoInfo(demoInfo);
    }

    @RequestMapping(value = {"/demo-requestParam"}, method = RequestMethod.POST)
    public List<DemoInfo> insertDemoInfo(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("description") String description) {
        DemoInfo demoInfo = new DemoInfo();
        demoInfo.setId(id);
        demoInfo.setDescription(description);
        demoInfo.setName(name);
        System.out.println(JSON.toJSONString(demoInfo));
        return service.insertDemoInfo(demoInfo);
    }

    @RequestMapping(value = "/demo/{id}", method = RequestMethod.PUT)
    public List<DemoInfo> updateDemoInfo(@PathVariable String id) {
        DemoInfo demoInfo = new DemoInfo();
        demoInfo.setId(id);
        demoInfo.setDescription("我是第" + id + "ST");
        demoInfo.setName("TS_" + id);
        return service.updateDemoInfo(demoInfo);
    }

    @RequestMapping(value = "/demo/{id}", method = RequestMethod.GET)
    public DemoInfo findDemoInfo(@PathVariable String id) {
        return service.findDemoInfo(id);
    }

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public List<DemoInfo> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/demo/{id}", method = RequestMethod.DELETE)
    public List<DemoInfo> deleteDemoInfo(@PathVariable String id) {
        DemoInfo demoInfo = new DemoInfo();
        demoInfo.setId(id);
        return service.deleteDemoInfo(demoInfo);
    }

}
