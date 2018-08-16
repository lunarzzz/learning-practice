package com.example.demo.concurrent.lock;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-15 11:07
 **/
public class MyLockTest {
    static MyLock myLock = new MyLock();
    static int count = 0;
    static void incCount(){
        myLock.lock();
        ++count;
        System.out.println(count);
        myLock.unlock();
    }
    public static void main(String[] args) {
//        Stream.iterate(0, x -> x+1).limit(10).forEach(System.out::print);
        for (int i = 0; i < 100; i++) {
            MyThreadPool.getThreadPoolExecutor().submit(MyLockTest::incCount);
        }
    }
}
