package com.example.demo.monitor.converter;

import com.example.demo.monitor.DTO.MonitorParam;
import com.example.demo.monitor.config.SignatureProvider;
import com.example.demo.monitor.constant.MonitorConstant;

import java.util.HashMap;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-22 10:49
 **/
public class MonitorConverter {

    public static HashMap<String, Object> convertParamDTO2ParamMap(MonitorParam monitorParam){
        if (null == monitorParam)
            return new HashMap<>();

        HashMap<String, Object> paramMap = new HashMap<>();

        paramMap.put(MonitorConstant.PARAM_CLIENT, MonitorConstant.APP_NAME);
        paramMap.put(MonitorConstant.PARAM_SIGNATURE, SignatureProvider.getSignature());
        paramMap.put(MonitorConstant.PARAM_FIELDS, monitorParam.getFields());
        paramMap.put(MonitorConstant.PARAM_CLUSTER_ID, monitorParam.getClusterId());
        paramMap.put(MonitorConstant.PARAM_CLUSTER_NAME, monitorParam.getClusterName());
        paramMap.put(MonitorConstant.PARAM_START_TIME, monitorParam.getStartTime());
        paramMap.put(MonitorConstant.PARAM_END_TIME, monitorParam.getEndTime());
        paramMap.put(MonitorConstant.PARAM_MONITOR_ITEM_NAME, monitorParam.getMonitorItemName());
        paramMap.put(MonitorConstant.PARAM_SN, monitorParam.getSn());
        paramMap.put(MonitorConstant.PARAM_DATA_ITEM_NAME, monitorParam.getDataItemName());
        paramMap.put(MonitorConstant.PARAM_HIS_TYPE, monitorParam.getHisType());
        paramMap.put(MonitorConstant.PARAM_INSTANCE, monitorParam.getInstance());
        paramMap.put(MonitorConstant.PARAM_BASELINE, monitorParam.getBaseline());
        paramMap.put(MonitorConstant.PARAM_ENUM_FILTER, monitorParam.getEnumFilter());
        paramMap.put(MonitorConstant.PARAM_TYPE, monitorParam.getType());

        return paramMap;
    }
}
