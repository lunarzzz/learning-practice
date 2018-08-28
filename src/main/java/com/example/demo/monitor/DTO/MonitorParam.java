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
//    /**
//     *
//     * @param client appName
//     * @param signature
//     * @param clusterId 集群的ID
//     * @param clusterName 集群名称，同clusterId二选一
//     * @param sn 服务器的sn号,获取集群监控项时,可以为空,即type=cluster时,可以为空。
//     * @param monitorItemName 监控项的名字
//     * @param dataItemName 数据项的名字
//     * @param startTime 起始时间，可以是详细时间 比如 2014-01-01 00:00:00,也可以是相对值，比如-1h,-5m 代表跟endTime的相对值是一个小时，5分钟
//     * @param endTime 结束时间，可以是绝对值比如 2014-01-01 00:00:00，可以是now，代表当前时间。通常now跟startTime的相对值结合使用
//     * @param fields 需要返回的字段，可以为空，为空代表返回所有的字段。多个字段已逗号分隔。
//     * @param instance 实例的名字，可以为空，为空代表为default
//     * @param type single/cluster,可以不传,为空.不传默认为single。single表示单机的监控项数据,cluster表示集群监控项数据。
//     * @param baseline 基线类型，可以为空。为空代表获取指定时间段的数据；不空时，有三个值，yesterday、sevenDaysAvg以及sevenDaysBefore，分别表示获取指定时间段的昨日基线、七天基线以及七天前的基线。
//     * @param hisType 数据源，可以为空。有ORIGIN、H1、D1三种，空时默认为ORIGIN，天的聚合数据定时触发，获取今天不一定能获取到
//     * @param enumFilter 主键过滤，可以为空。例如 className=com.netease.sentry.common.model.Field^exceptionType=NONE1
//     */
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
