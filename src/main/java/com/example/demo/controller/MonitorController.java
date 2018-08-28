package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.monitor.DTO.MonitorParam;
import com.example.demo.monitor.DTO.MonitorResponseDTO;
import com.example.demo.monitor.VO.ChartVO;
import com.example.demo.monitor.VO.LoadMonitorResponserVO;
import com.example.demo.monitor.VO.MonitorDTO2VO;
import com.example.demo.monitor.converter.MonitorConverter;
import com.example.demo.monitor.service.MonitorService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-22 11:20
 **/
@RestController
@RequestMapping("/api")
@Slf4j
public class MonitorController {

    @Autowired
    private MonitorService monitorService;

    @GetMapping("/monitor")
    public Response<MonitorResponseDTO> query(){
        MonitorParam monitorParam = new MonitorParam();
        MonitorResponseDTO load = monitorService.getLoad2(monitorParam);
        System.out.println(JSON.toJSONString(load));
        ResponseBuilder<MonitorResponseDTO> responseBuilder = new ResponseBuilder();
        if (load.getCode() == 200){
            Response<MonitorResponseDTO> qwe = responseBuilder.buildSuccess("qwe").buildSuccess(load).getResponse();
//            System.out.println(JSON.toJSONString(qwe));
            return qwe;
        }else
            return responseBuilder.buildFail("error").getResponse();
    }

    @GetMapping("/monitor2")
    public Response<ChartVO> queryMonitorInfoLoadIndex(){
        MonitorParam monitorParam = new MonitorParam();
        MonitorResponseDTO load = monitorService.getLoad2(monitorParam);
        System.out.println(JSON.toJSONString(load));
        ChartVO threeLevelVO = MonitorConverter.convertMonitorDTO2ThreeLevelVO2(load, "max");
        System.out.println(JSON.toJSONString(threeLevelVO));
        ResponseBuilder<ChartVO> responseBuilder = new ResponseBuilder();
        if (load.getCode() == 200){
            Response<ChartVO> qwert= responseBuilder.buildSuccess("qweqweqwe").buildSuccess(threeLevelVO).getResponse();
//            System.out.println(JSON.toJSONString(qwert));
            return qwert;
        }else
            return responseBuilder.buildFail("error").getResponse();
    }

    @GetMapping("/monitor3")
    public Response<ChartVO> queryMonitorInfoByLoadName(){
        MonitorParam monitorParam = new MonitorParam();
        MonitorResponseDTO load = monitorService.getLoad2(monitorParam);
        System.out.println(JSON.toJSONString(load));
        ChartVO threeLevelVO = MonitorConverter.convertMonitorDTO2ThreeLevelVO3(load, "load1");
        System.out.println(JSON.toJSONString(threeLevelVO));
        ResponseBuilder<ChartVO> responseBuilder = new ResponseBuilder();
        if (load.getCode() == 200){
            Response<ChartVO> qwert= responseBuilder.buildSuccess("qweqweqwe").buildSuccess(threeLevelVO).getResponse();
//            System.out.println(JSON.toJSONString(qwert));
            return qwert;
        }else
            return responseBuilder.buildFail("error").getResponse();
    }

    /**
     * 查询一小时，三小时，一天
     * @return
     */
    @GetMapping("/monitor/list")
    public Response<Map<String,ChartVO>> queryInfoByLoad(){
        MonitorParam monitorParam = new MonitorParam();
        Map<String, MonitorResponseDTO> loadIntegration = monitorService.getLoadIntegration();
        Map<String, ChartVO> voMap = MonitorConverter.comvertMonitorDTOMap2ChartVOMap(loadIntegration, "max");
        ResponseBuilder<Map<String, ChartVO>> builder = new ResponseBuilder<>();
        return builder.buildSuccess("aaaa").buildSuccess(voMap).getResponse();
    }

    /**
     * 查询按时间查询，最长六小时
     * @return
     */
    @GetMapping("/monitor4")
    public Response<ChartVO> queryInfoByLoadt(String start, String end){
        log.info("start is {}, end is {}", start, end);
        MonitorParam monitorParam = new MonitorParam();
        MonitorResponseDTO load = monitorService.getLoad4(start, end);
        ChartVO threeLevelVO = MonitorConverter.convertMonitorDTO2ThreeLevelVO3(load, "load1");
        ResponseBuilder<ChartVO> responseBuilder = new ResponseBuilder();
        log.info(JSON.toJSONString(threeLevelVO));
        if (load.getCode() == 200){
            Response<ChartVO> qwert= responseBuilder.buildSuccess("qweqweqwe").buildSuccess(threeLevelVO).getResponse();
            return qwert;
        }else
            return responseBuilder.buildFail("error").getResponse();
    }
}
