package com.rasion.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class callable {
    public static void main(String[] args) {
        //3、创建一个callable接口的实现类对象
        MyCallable c=new MyCallable(100);
        //4、把callable对象封装成一个线程任务对象FutureTask对象
        /**
         * FutureTask类实现了Runnable接口，所以可以作为线程任务对象
         * 线程任务对象可以作为线程对象来启动，可以获取线程执行完毕后的结果
         */
        Runnable t=new FutureTask<Integer>(c);
        //5、把FutureTask对象交给一个线程对象来处理
        Thread thread=new Thread(t);
        thread.start();
        //6、调用FutureTask对象的get方法，获取线程执行完毕后的结果
        try {
            System.out.println(thread.getName()+" is running: "+((FutureTask<Integer>) t).get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//1、定义实现类，实现callable接口
class MyCallable implements Callable<Integer> {
    private int sum;
    public MyCallable(int sum) {this.sum=sum;}
    //2、重写call方法，返回计算结果
    public Integer call() throws Exception {
        int n = 0;
        for (int i = 1; i <= sum; i++) {
            n += i;
        }
        return n;
    }
}