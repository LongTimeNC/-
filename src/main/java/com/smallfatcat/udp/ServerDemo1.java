package com.smallfatcat.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author zsz
 * @Description 接收端
 * @date 2022/9/11
 */
public class ServerDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("======服务端启动======");
        //1：创建接收端对象，注册端口号
        DatagramSocket socket = new DatagramSocket(8888);
        //2：创建一个数据包对象接受数据\
        byte[] bytes = new byte[1024*64];
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
        //3：等待接受数据
        socket.receive(datagramPacket);
        //4：取出数据
        // 读取多少，输出多少
        int len = datagramPacket.getLength();
        String s = new String(bytes,0,len);
        System.out.println("接收到数据了" + s);
        // 还能获取发送端的ip和端口
        String ip = datagramPacket.getAddress().toString();
        System.out.println("发送端的ip：" + ip);
        int port = datagramPacket.getPort();
        System.out.println("发送端的端口号：" + port);
        socket.close();
        System.out.println("======服务端关闭======");
    }
}
