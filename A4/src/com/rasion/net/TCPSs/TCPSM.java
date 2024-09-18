package com.rasion.net.TCPSs;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class TCPSM {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动");
        ServerSocket ss = new ServerSocket(8888);

        //创建线程池
        ExecutorService pool= new ThreadPoolExecutor(3, 5, 1000,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(100),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        //收消息
        while (true) {
            Socket s = ss.accept();
            System.out.println("有客户端连接"+s.getInetAddress().getHostAddress());
            //把客户端管道包装成一个任务对象交给线程池处理
            pool.execute(new ServerReader(s));
        }
    }
}
