package com.example.demo.netty.bio.nio;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-27 15:02
 **/
public class TimeServer {
    public static void main(String[] args) {
        int port = 8555;
        if (args != null && args.length> 0){
            try{
                Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }
//        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
//        new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();
    }
}
