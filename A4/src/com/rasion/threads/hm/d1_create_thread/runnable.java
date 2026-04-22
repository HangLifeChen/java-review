package com.rasion.threads.hm.d1_create_thread;

//优点:扩展性较好 使用实现接口的方式进行实现
//缺点:实现较复杂
public class runnable {
    public static void main(String[] args) {
//        //创建线程任务对象代表一个线程任务
//        Runnable r = new MyRunnable();
//        //把线程任务对象交给一个线程对象来处理
//        Thread t = new Thread(r);
//        //函数接口可以使用
//        Thread t=new Thread(
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        for (int i = 0; i <5 ; i++) {
//                            System.out.println("新的线程对象:"+i);
//                        }
//                    }
//                }
//        );
        Thread t =new Thread(
            ()->{
                for (int i = 0; i < 5; i++) {
                    System.out.println("新的线程对象");
                }

            }
        );
        //启动线程
        t.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("main is running: " + i);
        }
    }
}
//1、定义一个线程任务类实现Runnable接口
class MyRunnable implements Runnable {
    //2、重写run方法，设置线程任务
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("MyThread is running: " + i);
        }
    }
}
