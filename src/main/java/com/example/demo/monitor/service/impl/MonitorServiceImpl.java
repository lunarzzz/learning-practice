package com.example.demo.monitor.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.monitor.DTO.MonitorParam;
import com.example.demo.monitor.DTO.MonitorResponseDTO;
import com.example.demo.monitor.config.SignatureProvider;
import com.example.demo.monitor.constant.MonitorConstant;
import com.example.demo.monitor.converter.MonitorConverter;
import com.example.demo.monitor.request.MonitorRepository;
import com.example.demo.monitor.service.MonitorService;
import com.example.demo.monitor.util.MonitorUtils;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-21 11:57
 **/
@Component
public class MonitorServiceImpl implements MonitorService {

    @Autowired
    private MonitorRepository monitorRepository;

    public static MonitorParam commonMonitorParam = new MonitorParam();

    static {
        commonMonitorParam.setName(MonitorConstant.APP_NAME);
        commonMonitorParam.setSignature(SignatureProvider.getSignature());
        commonMonitorParam.setClusterName("kaola-promotionbackend-compose-act_test2");
        commonMonitorParam.setStartTime("-30m");
        commonMonitorParam.setEndTime("now");
        commonMonitorParam.setMonitorItemName("system");
        commonMonitorParam.setDataItemName("other");
        commonMonitorParam.setType("cluster");
        commonMonitorParam.setFields("load1,load5,load15");
    }

    @Override
    public MonitorResponseDTO getLoad(MonitorParam param) {
        param.setFields(MonitorUtils.builtFields(Arrays.asList("load1", "load5", "load15")));
        HashMap<String, Object> paramMap = MonitorConverter.convertParamDTO2ParamMap(param);
        MonitorResponseDTO monitorInfo = getMonitorInfo(paramMap);
        return monitorInfo;
    }

    @Override
    public MonitorResponseDTO getJVM(MonitorParam param) {

        HashMap<String, Object> stringObjectHashMap = MonitorConverter.convertParamDTO2ParamMap(param);
        MonitorResponseDTO monitorInfo = getMonitorInfo(stringObjectHashMap);
        String s = JSON.toJSONString(monitorInfo);
        return monitorInfo;
    }

    @Override
    public MonitorResponseDTO getLoad2(MonitorParam param) {
        MonitorParam monitorParam = new MonitorParam();
        monitorParam.setName(MonitorConstant.APP_NAME);
        monitorParam.setSignature(SignatureProvider.getSignature());
        monitorParam.setClusterName("kaola-promotionbackend-compose-act_test2");
        monitorParam.setStartTime("-30m");
        monitorParam.setEndTime("now");
        monitorParam.setMonitorItemName("system");
        monitorParam.setDataItemName("other");
        monitorParam.setType("cluster");
        monitorParam.setFields("load1,load5,load15");
        MonitorResponseDTO load = this.getLoad(monitorParam);
        String s = JSON.toJSONString(load);
        System.out.println(s);
        Assert.assertNotNull(s);
        return load;
    }

    @Override
    public Map<String, MonitorResponseDTO> getLoadIntegration() {
        Map<String, MonitorResponseDTO> map = new LinkedHashMap<>();
        MonitorResponseDTO load1 = getLoad(commonMonitorParam.setStartTime("-1h"));
        MonitorResponseDTO load2 = getLoad(commonMonitorParam.setStartTime("-3h"));
        MonitorResponseDTO load3 = getLoad(commonMonitorParam.setStartTime("-5h"));

        map.put("hour", load1);
        map.put("threehours", load2);
        map.put("day", load3);
        return map;
    }

    private MonitorResponseDTO getMonitorInfo(HashMap<String, Object> paramMap){
        return monitorRepository.getServerMonitorItemData(paramMap);
    }

}
