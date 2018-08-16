package com.example.demo.concurrent.lock.forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-15 14:31
 **/
public class ForkJoinTest {

    public static void main(String[] args) {
        List<Product> generator = ProductListGenerator.generator(10000);
        Task task = new Task(generator, 0, generator.size(), 0.20);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.execute(task);
        do {
            System.out.printf("main; Thread count：%d\n", forkJoinPool.getActiveThreadCount());
            System.out.printf("main; Thread steal：%d\n", forkJoinPool.getStealCount());
            System.out.printf("main; Thread paralism：%d\n", forkJoinPool.getParallelism());
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!task.isDone());

        forkJoinPool.shutdown();
        if (task.isCompletedNormally()){
            System.out.println("com nomally");
        }

        generator.stream().forEach(ForkJoinTest::checkPricve);

        System.out.println("program is over");
    }

    static void checkPricve(Product product){
        if (product.getPrice() != 12){
            System.out.println("name" + product.getName() + " price:" + product.getPrice());
        }
    }
}