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
public class ClientDemo2 {
    public static void main(String[] args) throws Exception {
        System.out.println("======客户端启动======");
        //1：创建发送端对象，自带默认端口号
        DatagramSocket socket = new DatagramSocket(9999);

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入要发送的消息：");
            String message = scanner.nextLine();
            if ("exit".equals(message)){
                System.out.println("客户端断开连接");
                socket.close();
                break;
            }
            //2：创建一个数据包对象封装数据
            byte[] bytes = message.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length, InetAddress.getLocalHost(),8888);
            //3：将数据发送出去
            socket.send(datagramPacket);
        }
    }
}
