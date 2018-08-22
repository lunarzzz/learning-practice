package com.example.demo.monitor.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.monitor.DTO.MonitorParam;
import com.example.demo.monitor.DTO.MonitorResponseDTO;
import com.example.demo.monitor.config.SignatureProvider;
import com.example.demo.monitor.constant.MonitorConstant;
import com.example.demo.monitor.service.MonitorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MonitorServiceImplTest {

    @Autowired
    private MonitorService monitorService;
    @Test
    public void getLoad() {
        MonitorParam monitorParam = new MonitorParam();
        monitorParam.setName(MonitorConstant.APP_NAME);
        monitorParam.setSignature(SignatureProvider.getSignature());
        monitorParam.setClusterName("kaola-promotionbackend-compose-act_test2");
        monitorParam.setStartTime("-5m");
        monitorParam.setEndTime("now");
        monitorParam.setMonitorItemName("system");
        monitorParam.setDataItemName("other");
        monitorParam.setType("cluster");
        monitorParam.setFields("load1,load5,load15");
        MonitorResponseDTO load = monitorService.getLoad(monitorParam);
        String s = JSON.toJSONString(load);
        System.out.println(s);
        Assert.assertNotNull(s);
    }
}