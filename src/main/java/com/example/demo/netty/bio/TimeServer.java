package com.example.demo.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-27 14:11
 **/
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8111;
        if (args != null && args.length > 0){
            try{
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){
                port = 8111;// 默认值
            }
        }

        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("the time server is start in port: " + port);
            Socket socket = null;
            while (true){
                socket = serverSocket.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        }finally {
            if (serverSocket != null){
                System.out.println("the time server close");
                serverSocket.close();
                serverSocket = null;
            }
        }
    }
}
