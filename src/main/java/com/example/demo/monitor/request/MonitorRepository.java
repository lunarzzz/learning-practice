package com.example.demo.monitor.request;

import com.example.demo.monitor.DTO.MonitorResponseDTO;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.HashMap;
import java.util.LinkedHashMap;


/**
 * @description: HTTP 请求映射类
 * @author: zhangjiawei
 * @create: 2018-08-20 21:20
 **/
public interface MonitorRepository {


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

    @Headers({"Accept: application/json"})
    @RequestLine("GET /getServersByCluster")
    LinkedHashMap getServersByCluster(@QueryMap HashMap<String, Object> paramMap);
}


