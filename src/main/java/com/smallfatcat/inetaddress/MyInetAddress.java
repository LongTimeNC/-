package com.smallfatcat.inetaddress;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author zsz
 * @Description-InetAddress常用API
 * @date 2022/9/11
 */
public class MyInetAddress {
    public static void main(String[] args) throws IOException {
        //1：获取本机地址对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost.getHostName());
        System.out.println(localHost.getHostAddress());
        //2：获取域名ip对象
        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName.getHostName());
        System.out.println(byName.getHostAddress());
        //3：获取公网ip对象
        InetAddress byName1 = InetAddress.getByName("180.101.49.11");
        System.out.println(byName1.getHostName());
        System.out.println(byName1.getHostAddress());
        //4：判断是否能通
        System.out.println(byName1.isReachable(5000));
    }
}
