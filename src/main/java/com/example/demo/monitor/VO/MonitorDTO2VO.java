package com.example.demo.monitor.VO;

import com.example.demo.monitor.DTO.MonitorResponseDTO;


/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-23 09:42
 **/
@Deprecated
public class MonitorDTO2VO {
    public static LoadMonitorResponserVO dto2vo(MonitorResponseDTO monitorResponseDTO){
        LoadMonitorResponserVO load = new LoadMonitorResponserVO();
        if (null == monitorResponseDTO)
            return load;

        return load;
    }
}
