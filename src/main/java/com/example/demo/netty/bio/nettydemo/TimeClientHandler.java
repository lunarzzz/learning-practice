package com.example.demo.netty.bio.nettydemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerInvoker;
import io.netty.util.concurrent.EventExecutorGroup;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-27 16:30
 **/
public class TimeClientHandler extends ChannelHandlerAdapter {
    private static final Logger logger = Logger.getLogger(TimeClientHandler.class.getName());

//    private final ByteBuf firstMessage;
    private  byte[] req;

    // 用于模拟粘包的计数
    private int counter;

    public  TimeClientHandler(){
//        byte[] req = "QUERY TIME ORDER".getBytes();
//        firstMessage = Unpooled.buffer(req.length);
        req = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();
//        firstMessage.writeBytes(req);

    }

    /**
     * TCP链路成功建立之后会调用此方法，发送查询时间的指令到服务端
     * @param ctx
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx){
        ByteBuf message = null;
        for (int i = 0; i < 100; i++) {
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }
//        ctx.writeAndFlush(firstMessage);
    }

    /**
     *  当服务器返回应答消息的时候，channelRead方法被调用
     * @param ctx
     * @param msg
     * @throws UnsupportedEncodingException
     */
    @Override
    public  void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {
//        ByteBuf buf = (ByteBuf) msg;
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//
//        String body = new String(req, "UTF-8");

        String body = (String) msg;
        System.out.println("Now is: " + body + "; the counter is :" + ++counter);
    }

    /**
     * 当发生调用异常的时候
     * @param ctx
     * @param cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        ctx.close();
    }
}
