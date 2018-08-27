package com.example.demo.netty.bio.nio;

import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-27 15:07
 **/
public class MultiplexerTimeServer implements Runnable {
    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private volatile boolean stop;
    @Override
    public void run() {

    }
}
