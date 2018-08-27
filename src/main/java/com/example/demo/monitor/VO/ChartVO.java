package com.example.demo.monitor.VO;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-23 15:21
 **/
@Data
public class ChartVO {
    List<String> columns;
    List<Map<String,Object>> rows;
}
