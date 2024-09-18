package com.rasion.net.TCPsolo;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPS {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动");
        ServerSocket ss = new ServerSocket(8888);//注册端口号，建立连接
        //调用accept方法，等待客户端连接，一有客户端连接会返回一个Socket对象
        Socket s = ss.accept();
        //获取客户端发送的数据
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        //获取客户端端口与IP
        System.out.println("客户端IP:"+s.getInetAddress().getHostAddress()+" 客户端端口："+s.getPort());
    }
}
