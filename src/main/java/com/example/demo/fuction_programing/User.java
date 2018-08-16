package com.example.demo.fuction_programing;

import lombok.Data;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-13 20:42
 **/
@Data
public class User {
    String name;
    String passwd;
    int age;

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPasswd() {
        return passwd;
    }

    public User setPasswd(String passwd) {
        this.passwd = passwd;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }
}
