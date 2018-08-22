package com.example.demo.monitor.util;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-22 10:43
 **/
public class MonitorUtils{

    public static String builtFields(List<String> fields){
        if (CollectionUtils.isEmpty(fields))
            return "";
        return String.join(",", fields);
    }
}
