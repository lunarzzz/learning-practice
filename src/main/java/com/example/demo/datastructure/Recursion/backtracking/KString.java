package com.example.demo.datastructure.Recursion.backtracking;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author: zhangjiawei
 * @create: 2018-08-30 14:42
 **/
public class KString {

    private Integer[] a;

    void binary(int n, int k){
        if (n < 1){
            print(a);
        }else{
            for (int i = 0; i < k; i++) {
                a[n-1] = i;
                binary(n-1, k);
            }
        }
    }

    private void print(Integer[] a) {
        Stream.of(a).sorted().forEach(System.out::print);
        System.out.println();
    }

    @Test
    public void test(){
        a = new Integer[5];
        binary(5, 5);
    }
}
