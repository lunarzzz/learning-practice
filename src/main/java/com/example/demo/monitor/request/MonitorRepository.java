package com.example.demo.monitor.request;

import com.example.demo.monitor.DTO.MonitorResponseDTO;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.HashMap;


/**
 * @description: HTTP 请求映射类
 * @author: zhangjiawei
 * @create: 2018-08-20 21:20
 **/
public interface MonitorRepository {

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
//     * @return 哨兵返回的监控信息
//     */
//    @Headers({"Accept: application/json"})
//    @RequestLine("GET getServerMonitorItemData?client={client}&signature={signature}&clusterId={clusterId}&clusterName={clusterName}&" +
//            "sn={sn}&monitorItemName={monitorItemName}&dataItemName={dataItemName}&startTime={startTime}&endTime={endTime}&fields={fields}&instance={instance}&" +
//            "type={type}&baseline={baseline}&hisType={hisType}&enumFilter={enumFilter}")
//    MonitorResponseDTO getServerMonitorItemData2(@Param("client") String client,
//                                                @Param("signature") String signature,
//                                                @Param("clusterId") Integer clusterId,
//                                                @Param("clusterName") String clusterName,
//                                                @Param("sn") Integer sn,
//                                                @Param("monitorItemName") String monitorItemName,
//                                                @Param("dataItemName") String dataItemName,
//                                                @Param("startTime") String startTime,
//                                                @Param("endTIme") String endTime,
//                                                @Param("fields") String fields,
//                                                @Param("instance") String instance,
//                                                @Param("type") String type,
//                                                @Param("baseline") String baseline,
//                                                @Param("hisType") String hisType,
//                                                @Param("enumFilter") String enumFilter
//            );

    @Headers({"Accept: application/json"})
    @RequestLine("GET /getServerMonitorItemData")
    MonitorResponseDTO getServerMonitorItemData(@QueryMap HashMap<String, Object> paramMap);
}


