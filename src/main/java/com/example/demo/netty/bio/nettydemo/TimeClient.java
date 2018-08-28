package com.example.demo.netty.bio.nettydemo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.Recycler;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-27 16:22
 **/
public class TimeClient {
    public void connect(int port, String host) throws InterruptedException {
        // 配置客戶端NIO线程组
        // EventLoopGroup Reactor线程池
        EventLoopGroup group = new NioEventLoopGroup();
        NioEventLoop nioEventLoop;
        Recycler recycler;
        try{
            // 客户端辅助启动类
            // 使用Builder设计模式来代替多个 构造函数
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            socketChannel.pipeline().addLast(new StringDecoder());
                            socketChannel.pipeline().addLast(new TimeClientHandler());
                        }
                    });
            // 发起异步连接操作 并调用同步方法等待连接成功
            ChannelFuture f = b.connect(host, port).sync();

            // 等待客户端链路关闭
            f.channel().closeFuture().sync();

        }finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int port = 8112;
        if (args != null &&args.length > 0){
            try{
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){
                //
            }
        }
        new TimeClient().connect(port, "127.0.0.1");
    }
}
