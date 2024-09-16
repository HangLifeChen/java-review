package com.rasion.threads;

public class runnable {
    public static void main(String[] args) {
        //3、创建线程任务对象代表一个线程任务
        Runnable r=new MyRunnable();
        //4、把线程任务对象交给一个线程对象来处理
        Thread t=new Thread(r);
        //5、启动线程
        t.start();
        for (int i=0;i<5;i++) System.out.println("main is running: "+i);
    }
}
//1、定义一个线程任务类实现Runnable接口
class MyRunnable implements Runnable {
    //2、重写run方法，设置线程任务
    @Override
    public void run(){
        for (int i=0;i<5;i++)System.out.println("MyThread is running: "+i);
    }
}
