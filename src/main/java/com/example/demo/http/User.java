package com.example.demo.http;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-17 16:01
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User{
    private String name;
    private int age;
}