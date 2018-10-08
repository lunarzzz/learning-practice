package com.example.demo.effective_java;

import java.util.Collections;

/**
 * @ClassNameTest
 * @Description TODO
 * @Author apple
 * @Date 2018/9/26 6:32 PM
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        System.out.println();
        Thread thread = new Thread(() -> {
            while (true) System.out.println("zjw");
        });
        thread.setName("my test thread");
        if (true) {
            thread.start();
        }
    }
}
