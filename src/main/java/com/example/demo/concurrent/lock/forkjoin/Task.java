package com.example.demo.concurrent.lock.forkjoin;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-15 14:42
 **/
public class Task extends RecursiveAction {
    private static final long serialVersionUID = 1L;

    private List<Product> products;

    private int first;
    private int last;
    private double increment;

    public Task(List<Product> products, int first, int last, double increment) {
        this.products = products;
        this.first = first;
        this.last = last;
        this.increment = increment;
    }

    @Override
    protected void compute() {
        if (last - first < 10){
            updatePrice();
        }else{
            int middle = (last+first)/2;
            System.out.printf("Tast : pending tasts: %s \n", getQueuedTaskCount());;
            Task t1 = new Task(products, first, middle+1, increment);
            Task t2 = new Task(products, middle+1, last, increment);
            invokeAll(t1,t2);
        }
    }

    private void updatePrice() {
        products.stream().limit(last).skip(first).forEach(x-> x.setPrice(x.getPrice()*(1+increment)));
    }


}
