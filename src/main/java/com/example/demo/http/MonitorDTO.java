package com.example.demo.http;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-17 16:03
 **/
@Data
@ToString
public class MonitorDTO {
    String name;
    List<User> users;
}
