package com.example.demo.monitor.DTO;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-20 21:36
 **/
@Data
@ToString
public class MonitorResponseDTO {

    private Integer code;
    private List<DataMeta>  rt;
}
