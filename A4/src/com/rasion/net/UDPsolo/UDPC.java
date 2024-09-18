package com.rasion.net.UDPsolo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPC {
    //创建客户端
    public static void main(String[] args) throws Exception{
        System.out.println("客户端已启动");
        //创建发送端对象
        DatagramSocket dgs=new DatagramSocket();
        //创建数据包对象封装要发送的数据
        byte[] b="Hello,here is a UDP massage!".getBytes();
        /**
         * 参数1：要发送的数据，字节数组
         * 参数2：要发送的数据长度
         * 参数3：要发送的目标主机的IP地址
         */
        DatagramPacket packet=new DatagramPacket(b, b.length, InetAddress.getByName("localhost"), 8888 );
        //让发送端对象发送数据包
        dgs.send(packet);
    }
}
