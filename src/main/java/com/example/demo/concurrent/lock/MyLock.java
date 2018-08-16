package com.example.demo.concurrent.lock;



import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-15 11:06
 **/
public class MyLock  {

    private MySync mySync;
    void lock(){
        mySync.lock();
    }

    boolean unlock(){
        return mySync.release(1);
    }

    public MyLock() {
        mySync = new MySync();
    }

    static private class MySync extends AbstractQueuedSynchronizer{

        @Override
        protected boolean tryAcquire(int arg) {
            final Thread current = Thread.currentThread();
            // 资源使用的情况
            int state = getState();
            // state ==0 无人使用
            if (state == 0){
                if (compareAndSetState(0,arg)){
                    setExclusiveOwnerThread(current);
                    return true;
                }
                // 如果正在使用的是当前线程 可重入
            }else if (current == getExclusiveOwnerThread()){
                int nextc = state + arg;
                if (nextc < 0)
                    throw new Error("max lock overflow");
                setState(nextc);
                return true;
            }
            return false;
        }

        final void lock(){
            if (compareAndSetState(0, 1)){
                setExclusiveOwnerThread(Thread.currentThread());
            }else
                // 这里的acquire 会调用模板方法tryAcquare(arg)
                acquire(1);
        }

        @Override
        protected final boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }

        @Override
        protected final boolean tryRelease(int releases){
            int c = getState() - releases;
            if (Thread.currentThread() != getExclusiveOwnerThread())
                throw new IllegalMonitorStateException();
            boolean free = false;
            if (c == 0){
                free = true;
                setExclusiveOwnerThread(null);
            }
            setState(c);
            return true;
        }




    }
}
