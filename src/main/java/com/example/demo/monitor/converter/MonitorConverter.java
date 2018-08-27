package com.example.demo.monitor.converter;

import com.example.demo.monitor.DTO.DataMeta;
import com.example.demo.monitor.DTO.MonitorParam;
import com.example.demo.monitor.DTO.MonitorResponseDTO;
import com.example.demo.monitor.VO.ChartVO;
import com.example.demo.monitor.config.SignatureProvider;
import com.example.demo.monitor.constant.MonitorConstant;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

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

    /**
     *
     * @param monitorDTO
     * @param field 生成图表的字段
     * @return
     */
    public static ChartVO convertMonitorDTO2ThreeLevelVO2(MonitorResponseDTO monitorDTO, String field){
        if (null == monitorDTO || monitorDTO.getRt() == null)
            return new ChartVO();
        ChartVO threeLevelVO = new ChartVO();
        List<String> columns = new ArrayList<>();
        List<DataMeta> rt = monitorDTO.getRt();
//        JSON.toJSONString(rt);
        List<Map<String, Object>> rows = new ArrayList<>();
        columns.add("time");
        // nullPointerExcepiton
        columns.addAll(rt.get(0).getData().keySet());
        rt.forEach(dataMeta -> {
            // 增加一列
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("time",dataMeta.getTime());
            dataMeta.getData().entrySet().forEach( entry -> {
                // entry   laod1 -》 { last : 4.35}
                Map<String, Object> value = entry.getValue();
                row.put(entry.getKey(), value.get(field));
            });
            rows.add(row);
        });
        threeLevelVO.setColumns(columns);
        threeLevelVO.setRows(rows);
        return threeLevelVO;
    }

    public static ChartVO convertMonitorDTO2ThreeLevelVO3(MonitorResponseDTO monitorDTO, String field){
        // 显示同一组数据的所有字段
        if (null == monitorDTO || monitorDTO.getRt() == null)
            return new ChartVO();
        ChartVO threeLevelVO = new ChartVO();
        List<String> columns = new ArrayList<>();
        List<DataMeta> rt = monitorDTO.getRt();
        List<Map<String, Object>> rows = new ArrayList<>();
        columns.add("time");
        // nullPointerExcepiton
        columns.addAll(rt.get(0).getData().get(field).keySet());
        rt.forEach(dataMeta -> {
            // 增加一列
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("time",dataMeta.getTime());
            dataMeta.getData().get(field).entrySet().forEach( a-> row.put(a.getKey(), a.getValue()));
            rows.add(row);
        });
        threeLevelVO.setColumns(columns);
        threeLevelVO.setRows(rows);
        return threeLevelVO;
    }

    public static List<ChartVO> comvertMonitorDTOs2ChartVOs(List<MonitorResponseDTO> list, String field){
        if (CollectionUtils.isEmpty(list))
            return new ArrayList<ChartVO>();
        return list.stream().map(a -> convertMonitorDTO2ThreeLevelVO2(a, field)).collect(Collectors.toList());
    }

    public static Map<String, ChartVO> comvertMonitorDTOMap2ChartVOMap(Map<String, MonitorResponseDTO> map, String field){
        if (CollectionUtils.isEmpty(map))
            return new LinkedHashMap<>();
        Map<String, ChartVO> voMap = new LinkedHashMap<>();
        map.entrySet().stream().forEach( a -> voMap.put(a.getKey(),convertMonitorDTO2ThreeLevelVO2(a.getValue(), field)));
        return voMap;
    }
}
