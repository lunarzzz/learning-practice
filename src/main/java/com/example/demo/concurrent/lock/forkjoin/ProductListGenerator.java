package com.example.demo.concurrent.lock.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-15 14:36
 **/
public class ProductListGenerator {

    public static List<Product> generator(int size){
        if (size<0)
            return null;
        List<Product> list = new ArrayList<>();
        Stream.iterate(0, x -> x+1).limit(size).map(x -> new Product().setName("number " + x).setPrice(10)).forEach(x -> list.add(x));
        return list;
    }

    public static void main(String[] args) {
        generator(10).stream().map(Product::getPrice).forEach(System.out::println);
    }
}
