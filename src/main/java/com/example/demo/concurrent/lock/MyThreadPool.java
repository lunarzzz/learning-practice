package com.example.demo.concurrent.lock;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-15 11:07
 **/
public class MyThreadPool {

    private static final int CORE_POOL_SIZE = 100;
    private static final int MAX_POOL_SIZE = 100;


    private static ThreadPoolExecutor threadPoolExecutor;

    private static AtomicBoolean initFlag = new AtomicBoolean(false);

    private static void init() {
        if (!initFlag.compareAndSet(false, true)){
            return;
        }
        threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 5L, TimeUnit.MINUTES, new LinkedBlockingDeque<>(10), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });
    }

    public static ThreadPoolExecutor getThreadPoolExecutor(){
        init();
        return threadPoolExecutor;
    }
}
