package com.example.demo.monitor.service;

import com.example.demo.monitor.DTO.MonitorParam;
import com.example.demo.monitor.DTO.MonitorResponseDTO;

import java.util.Map;

/**
 * @description: 对监控数据进行处理
 * @author: zhangjiawei
 * @create: 2018-08-21 11:54
 **/
public interface MonitorService {

    MonitorResponseDTO getLoad(MonitorParam param);

    MonitorResponseDTO getJVM(MonitorParam param);

    MonitorResponseDTO getLoad2(MonitorParam param);

    Map<String,MonitorResponseDTO> getLoadIntegration();

}
