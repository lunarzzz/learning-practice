package com.example.demo.concurrent.lock.forkjoin;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-15 14:35
 **/
public class Product {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }
}
