package com.example.demo.testabstract;

import org.junit.runner.RunWith;

/**
 * @ClassNameTestBase
 * @Description TODO
 * @Author apple
 * @Date 2018/10/18 9:41 PM
 * @Version 1.0
 */
public class TestBase {
    public static void main(String[] args) {
        Base1 base1 = new Base1();
        Base2 base2 = new Base2();
        System.out.println(base1.getA());
        System.out.println(base2.getA());
    }
}
