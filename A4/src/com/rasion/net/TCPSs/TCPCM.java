package com.rasion.net.TCPSs;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPCM {
    public static void main(String[] args) throws Exception {
        //实现TCP通信多发多收
        Socket s = new Socket("localhost", 8888);
        System.out.println("客户端启动");
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        Scanner sc = new Scanner(System.in);
        //循环发送
        while (true) {
            System.out.print("请输入要发送的内容：");
            String msg = sc.nextLine();
            if ("exit".equals(msg)) {
                System.out.println("客户端退出");
                dos.close();//管道关闭，释放资源
                s.close();
                break;
            }
            dos.writeUTF(msg);
            dos.flush();//刷新数据
        }
    }
}
