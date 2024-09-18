package com.rasion.net.TCPmore;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSM {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动");
        ServerSocket ss = new ServerSocket(8888);
        Socket s = ss.accept();
        //获取客户端发送的数据
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        //收消息
        while (true) {
            try {//使用try-catch，当客户端断开连接时，程序不会因为 EOFException 而崩溃
                String msg = dis.readUTF();//等待读取客户端发送的数据
                if ("exit".equals(msg)) {
                    System.out.println("服务端退出");
                    dis.close();//管道关闭，释放资源
                    s.close();
                    break;
                }
                System.out.println("客户端："+msg);
                System.out.println("客户端IP:"+s.getInetAddress().getHostAddress()+" 客户端端口："+s.getPort());
            }catch (Exception e)
            {
                System.out.println("客户端已经断开连接");
                break;
            }
        }
    }
}
