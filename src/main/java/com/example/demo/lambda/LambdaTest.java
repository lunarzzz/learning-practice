package com.example.demo.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-09 19:47
 **/
public class LambdaTest {

    static Integer consumer(Plus<Integer, Integer> plus, Integer a, Integer b){
        Integer sum = plus.doPlus(a,b);
        return sum;
    }

    public static void main(String[] args) {
//        consumer((a)-> System.out.println(a));
        Integer consumer = consumer((a, b) -> a + b, 5, 6);
        consumer((a,b)->a+b,3,5);
        System.out.println(consumer);
        StringJoiner stringJoiner = new StringJoiner(",","{","}");
        Character character;
        stringJoiner.add("123");
        stringJoiner.add("456");
        System.out.println(stringJoiner.toString());

    }
}

@FunctionalInterface
interface  Plus<T,R>{
    R doPlus(T a, T b);
    default List<T> get(T a, T b){
        return Arrays.asList(a,b);
    }
}

class TPlus<T,R> implements Plus<T,R>{

    @Override
    public R doPlus(T a, T b) {
        return null;
    }
}


