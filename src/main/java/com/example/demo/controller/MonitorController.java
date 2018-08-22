package com.example.demo.controller;

import com.example.demo.monitor.DTO.MonitorParam;
import com.example.demo.monitor.DTO.MonitorResponseDTO;
import com.example.demo.monitor.service.MonitorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-22 11:20
 **/
@RestController
@RequestMapping("/monitor")
public class MonitorController {

    @Autowired
    private MonitorService monitorService;

    @GetMapping
    public Response<MonitorResponseDTO> queryMonitorInfo(@RequestParam MonitorParam monitorParam){
        MonitorResponseDTO load = monitorService.getLoad(monitorParam);
        ResponseBuilder<MonitorResponseDTO> responseBuilder = new ResponseBuilder();
        if (load.getCode() == 200){
            return responseBuilder.buildSuccess("qwe").buildSuccess(load).getResponse();
        }else
            return responseBuilder.buildFail("error").getResponse();
    }
}
