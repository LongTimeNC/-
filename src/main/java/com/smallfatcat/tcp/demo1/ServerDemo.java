package com.smallfatcat.tcp.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zsz
 * @Description
 * @date 2022/9/13
 */
public class ServerDemo {
    public static void main(String[] args) {
        System.out.println("======服务端启动成功======");
        try {
            //1：注册端口
            ServerSocket serverSocket = new ServerSocket(9999);
            //2：调用accept方法，等待接受客户端的socket的连接请求，建立socket通道
            Socket socket = serverSocket.accept();
            //3：从socket通信管道中获取一个输入流，来读取数据
            InputStream is = socket.getInputStream();
            //4：把字节输入流包装成缓冲字符输入流进行消息的接受-先将字节输入流转成字符输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            //5：按照行来读取数据
            String message;
            while ((message = br.readLine()) != null){
                System.out.println(socket.getRemoteSocketAddress() + "说了：" + message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
