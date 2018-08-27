package com.example.demo.monitor.VO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-23 09:43
 **/
@Data
@NoArgsConstructor
@Deprecated
public class LoadMonitorResponserVO {
    List<String> times;
    Map<String, Collection<Long>> data;
}
