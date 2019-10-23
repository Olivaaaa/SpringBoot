package com.springboot.restful.service;

import com.springboot.restful.entity.DemoInfo;

import java.util.List;

public interface DemoInfoService {

    List<DemoInfo> insertDemoInfo(DemoInfo demo);

    DemoInfo findDemoInfo(String id);

    List<DemoInfo> updateDemoInfo(DemoInfo demo);

    List<DemoInfo> deleteDemoInfo(DemoInfo demo);

    List<DemoInfo> findAll();
}
