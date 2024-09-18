package com.rasion.net.UDPmore;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPSM {
    public static void main(String[] args) throws Exception {
        System.out.println("服务器启动");
        DatagramSocket ds = new DatagramSocket(8888);
        byte[] b = new byte[1024*64];
        DatagramPacket dp = new DatagramPacket(b, b.length);
        while (true) {
            System.out.println("等待客户端发送数据");
            ds.receive(dp);
            //查看是否收到
            System.out.println("服务端收到：" + new String(b, 0, dp.getLength()));
            //获取IP与端口
            System.out.println("客户端IP：" + dp.getAddress().getHostAddress()+"端口："+dp.getPort());
        }
    }
}
