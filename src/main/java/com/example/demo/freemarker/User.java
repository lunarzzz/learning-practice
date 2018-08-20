package com.example.demo.freemarker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassNameUser
 * @Description TODO
 * @Author apple
 * @Date 2018/8/16 10:34 PM
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User{
    String name;
    int age;
}
