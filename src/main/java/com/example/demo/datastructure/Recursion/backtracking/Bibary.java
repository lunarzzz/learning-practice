package com.example.demo.datastructure.Recursion.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author: zhangjiawei
 * @create: 2018-08-30 14:25
 **/
public class Bibary {
    /**
     * 生成所有n位长的字符串
     */
    private Integer[] a;

    void binary(int n){
        if (n < 1){
            print(a);
        }else{
            a[n-1] = 0;
            binary(n-1);
            a[n-1] = 1;
            binary(n-1);
        }
    }

    private void print(Integer[] a) {
        Stream.of(a).sorted().forEach(System.out::print);
        System.out.println();
    }

    @Test
    public void test(){
        a = new Integer[5];
        binary(5);
    }
}
