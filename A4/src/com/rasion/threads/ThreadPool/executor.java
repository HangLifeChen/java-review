package com.rasion.threads.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class executor {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(3);//创建一个固定大小的线程池
        //相当于调用：ThreadPoolExecutor并且封装了，不需要再手动创建
        //大型并发式系统使用Executors会出现系统风险，最好别用Executors，多用ThreadPoolExecutor。
        //Executors没有控制允许的申请队列长度，会出现堆积大量的请求，导致OOM(内存溢出)
        //没有控制允许的创建线程数量，导致OOM
        executorService.execute(new RunnableTask1());
    }
}
