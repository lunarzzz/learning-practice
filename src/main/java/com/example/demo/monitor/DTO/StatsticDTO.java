package com.example.demo.monitor.DTO;

import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-21 17:15
 **/
@Data
@ToString
public class StatsticDTO {

   private Long last;
   private Long min;
   private Long max;
   private Long sum;
   private Long count;
}
