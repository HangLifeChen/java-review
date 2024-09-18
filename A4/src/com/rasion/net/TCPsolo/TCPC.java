package com.rasion.net.TCPsolo;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPC {
    public static void main(String[] args) throws Exception {
        //实现TCP通信一发一收
        Socket s = new Socket("localhost", 8888);
        System.out.println("客户端启动");
        //从Socket通信管道中得到一个字节输出流，那么对面服务端也要是一个对应的字节输入流
        OutputStream os = s.getOutputStream();
        //特殊数据流
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeInt(100);
        dos.writeUTF("你好，我是客户端");
        //关闭管道
        dos.close();
    }
}
