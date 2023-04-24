package com.smallfatcat.tcp.demo1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author zsz
 * @Description
 * @date 2022/9/13
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("======客户端启动成功======");
        try {
            //1：创建socket通信管道，请求服务端的连接
            //参数一：服务器的IP地址，参数二：服务器的端口号
            Socket socket = new Socket("127.0.0.1",9999);
            //2：从socket管道通信中获取一个字节输出流，负责发送数据
            OutputStream os = socket.getOutputStream();
            //3：把低级的字节流包装成打印流
            PrintStream ps = new PrintStream(os);
            //4：发送消息
            ps.print("我是TCP的客户端，已经与你对接，并发送消息：约吗？");
            ps.flush();
            // 关闭资源
            // socket.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
