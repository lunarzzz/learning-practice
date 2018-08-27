package com.example.demo.netty.bio.series;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-27 19:35
 **/
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User("123",12);
        byte[] buff = new byte[1024];
        FileOutputStream byteArrayInputStream = new FileOutputStream("./test.txt");
        ObjectOutputStream os = new ObjectOutputStream(byteArrayInputStream);
        os.writeObject(user);
    }
}

@Data
@AllArgsConstructor
class User implements Serializable{
    String name;
    int age;
}