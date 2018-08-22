package com.example.demo.monitor.DTO;

import lombok.Data;
import lombok.ToString;

import java.util.Map;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-20 21:38
 **/
@Data
@ToString
public class DataMeta {

    private Map<String, StatsticDTO> data;
    private String time;
}
