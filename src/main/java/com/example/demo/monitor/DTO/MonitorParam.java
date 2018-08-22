package com.example.demo.monitor.DTO;

import lombok.Data;

import java.util.HashMap;

/**
 * @description: 获取监控信息传参
 * @author: zhangjiawei
 * @create: 2018-08-21 12:33
 **/
@Data
public class MonitorParam {

//    HashMap<String, Object> paramMap = new HashMap<>();
    private String  name;
    private String  signature;
    private String  fields;
    private Integer clusterId;
    private String  clusterName;
    private String  startTime;
    private String  endTime;
    private String  monitorItemName;
    private Integer sn;
    private String  dataItemName;
    private String  hisType;
    private String  instance;
    private String  baseline;
    private String  enumFilter;
    private String  type;

//    public MonitorParam setFilds(List<String> fields){
//        String join = String.join(",", fields);
//        paramMap.put(MonitorConstant.PARAM_FIELDS, fields);
//        return this;
//    }
//
//    public MonitorParam setClusterId(Integer clusterId){
//        paramMap.put(MonitorConstant.PARAM_CLUSTER_ID, clusterId);
//        return this;
//    }












}
