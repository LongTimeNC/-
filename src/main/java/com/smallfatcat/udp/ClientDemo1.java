package com.smallfatcat.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author zsz
 * @Description 发送端
 * @date 2022/9/11
 */
public class ClientDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("======客户端启动======");
        //1：创建发送端对象，自带默认端口号
        DatagramSocket socket = new DatagramSocket(9998);
        //2：创建一个数据包对象封装数据
        /**
         * 参数一：封装要发送的数据
         * 参数二：发送的数据的大小
         * 参数三：服务端的主机ip地址
         * 参数四：服务端的端口
         */
        byte[] bytes = "我是一颗快乐的韭菜，你愿意吃吗?".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length, InetAddress.getLocalHost(),8888);
        //3：将数据发送出去
        socket.send(datagramPacket);
        socket.close();
        System.out.println("======客户端关闭======");
    }
}
