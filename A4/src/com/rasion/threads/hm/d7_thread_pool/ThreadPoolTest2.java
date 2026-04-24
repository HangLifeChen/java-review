package com.rasion.threads.hm.d7_thread_pool;

import java.util.concurrent.*;

//创建临时队列时机:核心线程正在执行任务 且任务队列满了 当前线程数小于最大线程数
public class ThreadPoolTest2 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(
                3,
                10,
                7,
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(20),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        for (int i = 0; i < 31; i++) {
            threadPoolExecutor.execute(new Student("小红"+i));
        }

    }
}
class Student implements Runnable{
    String name;
    public Student(String name){
        this.name=name;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread()+"正在教"+name);
    }
}