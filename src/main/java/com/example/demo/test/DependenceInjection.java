package com.example.demo.test;

import java.lang.reflect.Field;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-07-30 17:04
 **/
public class DependenceInjection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        //设置访问权限
         Class<?> aClass = Class.forName("com.example.demo.test.User");
        System.out.println(aClass.getName());
        Field name = aClass.getDeclaredField("name");
        Object o = aClass.newInstance();
        name.setAccessible(true);
        name.set(o,"zhangjiawei");
        System.out.println(((User)o).getName());

    }
}

class User{
    private String name;
    private String password;

    public String getName() {
        return name;
    }
}