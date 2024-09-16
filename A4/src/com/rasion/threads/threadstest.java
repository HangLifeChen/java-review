package com.rasion.threads;

public class threadstest {
    //main方法本身是由一条主线程负责执行的
    public static void main(String[] args) {
        MyThread t=new MyThread();//4、创建一个线程对象，才能代表线程
        t.start();//5、启动线程
        for (int i=0;i<5;i++) System.out.println("main is running: "+i);
        /**输出：（每次情况都不一样，主线程和MyThread线程并行）
         * main is running: 0
         * main is running: 1
         * MyThread is running: 0
         * main is running: 2
         * main is running: 3
         * main is running: 4
         * MyThread is running: 1
         * MyThread is running: 2
         * MyThread is running: 3
         * MyThread is running: 4
         */
    }
}
class MyThread extends Thread{//1、定义定义一个子类继承Thread类，成为线程类
    //2、重写Threads类的run方法
    @Override
    public void run(){
        for (int i=0;i<5;i++)System.out.println("MyThread is running: "+i);
        //3、在run方法中编写线程的任务代码（线程的任务）
    }
}
