package com.example.demo.monitor.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.monitor.DTO.MonitorParam;
import com.example.demo.monitor.DTO.MonitorResponseDTO;
import com.example.demo.monitor.converter.MonitorConverter;
import com.example.demo.monitor.request.MonitorRepository;
import com.example.demo.monitor.service.MonitorService;
import com.example.demo.monitor.util.MonitorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;


/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-21 11:57
 **/
@Component
public class MonitorServiceImpl implements MonitorService {

    @Autowired
    private MonitorRepository monitorRepository;

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

    private MonitorResponseDTO getMonitorInfo(HashMap<String, Object> paramMap){
        return monitorRepository.getServerMonitorItemData(paramMap);
    }

}
