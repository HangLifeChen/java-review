package com.rasion.net;

import java.net.InetAddress;

public class InetAddresstest {
    public static void main(String[] args){
        try{
            //获取本地IP
            System.out.println(InetAddress.getLocalHost().getHostAddress());//本地IP
            System.out.println("主机名："+InetAddress.getLocalHost().getHostName());//本地主机名

            //获取对方IP
            System.out.println(InetAddress.getByName("www.baidu.com").getHostAddress());
            System.out.println("主机名："+InetAddress.getByName("www.baidu.com").getHostName());

            //判断本机与对方主机是否互通，判断是否联网
            System.out.println(InetAddress.getByName("www.baidu.com").isReachable(5000));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
