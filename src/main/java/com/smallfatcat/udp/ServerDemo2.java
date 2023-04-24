package com.smallfatcat.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @author zsz
 * @Description
 * @date 2022/9/11
 */
public class ServerDemo2 {
    public static void main(String[] args) throws Exception {
        System.out.println("======服务端启动======");
        //1：创建接收端对象，注册端口号
        DatagramSocket socket = new DatagramSocket(8888);
        //2：创建一个数据包对象接受数据\
        byte[] bytes = new byte[1024*64];
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
        //3：等待接受数据
        while (true){
            socket.receive(datagramPacket);
            //4：取出数据
            // 读取多少，输出多少
            int len = datagramPacket.getLength();
            String s = new String(bytes,0,len);
            System.out.println("收到了来自：" + datagramPacket.getAddress() + ",对方端口号：" + datagramPacket.getPort() + "的消息：" + s);
        }

    }
}
