package com.rasion.net.UDPsolo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPS {
    //这里是服务端对象
    public static void main(String[] args) throws Exception{
        System.out.println("服务端已启动");
        //创建接收端对象，注册端口
        DatagramSocket ds=new DatagramSocket();
        //创建数据包对象负责接收数据
        byte[] b=new byte[1024*64];
        DatagramPacket dp=new DatagramPacket(b,b.length);
        //接收数据将数据封装到数据包对象中
        ds.receive(dp);
        //输出数据
        System.out.println("服务端收到："+new String(dp.getData(),0,dp.getLength()));
        //获取对方IP对象
        System.out.println("对方IP："+dp.getAddress().getHostAddress()+" 对象端口："+dp.getPort());
    }
}
