package com.example.demo.monitor.DTO;

import lombok.Data;

import java.util.HashMap;

/**
 * @description: 获取监控信息传参
 * @author: zhangjiawei
 * @create: 2018-08-21 12:33
 **/

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

    public String getName() {
        return name;
    }

    public MonitorParam setName(String name) {
        this.name = name;
        return this;
    }

    public String getSignature() {
        return signature;
    }

    public MonitorParam setSignature(String signature) {
        this.signature = signature;
        return this;
    }

    public String getFields() {
        return fields;
    }

    public MonitorParam setFields(String fields) {
        this.fields = fields;
        return this;
    }

    public Integer getClusterId() {
        return clusterId;
    }

    public MonitorParam setClusterId(Integer clusterId) {
        this.clusterId = clusterId;
        return this;
    }

    public String getClusterName() {
        return clusterName;
    }

    public MonitorParam setClusterName(String clusterName) {
        this.clusterName = clusterName;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public MonitorParam setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public MonitorParam setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public String getMonitorItemName() {
        return monitorItemName;
    }

    public MonitorParam setMonitorItemName(String monitorItemName) {
        this.monitorItemName = monitorItemName;
        return this;
    }

    public Integer getSn() {
        return sn;
    }

    public MonitorParam setSn(Integer sn) {
        this.sn = sn;
        return this;
    }

    public String getDataItemName() {
        return dataItemName;
    }

    public MonitorParam setDataItemName(String dataItemName) {
        this.dataItemName = dataItemName;
        return this;
    }

    public String getHisType() {
        return hisType;
    }

    public MonitorParam setHisType(String hisType) {
        this.hisType = hisType;
        return this;
    }

    public String getInstance() {
        return instance;
    }

    public MonitorParam setInstance(String instance) {
        this.instance = instance;
        return this;
    }

    public String getBaseline() {
        return baseline;
    }

    public MonitorParam setBaseline(String baseline) {
        this.baseline = baseline;
        return this;
    }

    public String getEnumFilter() {
        return enumFilter;
    }

    public MonitorParam setEnumFilter(String enumFilter) {
        this.enumFilter = enumFilter;
        return this;
    }

    public String getType() {
        return type;
    }

    public MonitorParam setType(String type) {
        this.type = type;
        return this;
    }

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
