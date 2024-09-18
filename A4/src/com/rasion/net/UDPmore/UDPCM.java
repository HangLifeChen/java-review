package com.rasion.net.UDPmore;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPCM {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动");
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("请输入要发送的内容：");
            String str = sc.nextLine();
            if("exit".equals(str)){
                System.out.println("客户端退出");
                ds.close();//管道关闭，释放资源
                break;
            }
            byte[] b = str.getBytes();
            ds.send(new DatagramPacket(b, b.length, InetAddress.getLocalHost(), 8888));
        }
    }
}
