package com.rasion.net.TCPSs;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class ServerReader extends Thread{
    private Socket s;
    public ServerReader(Socket s){
        this.s = s;
    }
    @Override
    public void run(){
        try {
            //获取客户端发送的数据
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            //使用try-catch，当客户端断开连接时，程序不会因为 EOFException 而崩溃
            while (true) {
                try {
                    String msg = dis.readUTF();//等待读取客户端发送的数据
                    if ("exit".equals(msg)) {
                        System.out.println("服务端退出");
                        dis.close();//管道关闭，释放资源
                        s.close();
                        return;
                    }
                    System.out.println("客户端："+msg);
                    System.out.println("客户端IP:"+s.getInetAddress().getHostAddress()+" 客户端端口："+s.getPort());
                }catch (Exception e)
                {
                    System.out.println("客户端"+s.getInetAddress().getHostAddress()+"已经断开连接");
                    return;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
