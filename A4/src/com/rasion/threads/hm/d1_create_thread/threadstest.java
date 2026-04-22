package com.rasion.threads.hm.d1_create_thread;


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
//优点:实现简单
//缺点:通过继承实现类，只能继承，不利于扩展
class MyThread extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("MyThread is running:"+i);
        }

    }
}