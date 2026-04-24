package com.rasion.threads.hm.d7_thread_pool;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
    目标：掌握线程池的创建。

    public ThreadPoolExecutor(
        int corePoolSize,
        int maximumPoolSize,
        long keepAliveTime,
        TimeUnit unit,
        BlockingQueue<Runnable> workQueue,
        ThreadFactory threadFactory,
        RejectedExecutionHandler handler
        )
    参数一：corePoolSize : 指定线程池的核心线程的数量。
    参数二：maximumPoolSize：指定线程池的最大线程数量。
    参数三：keepAliveTime ：指定临时线程的存活时间。
    参数四：unit：指定临时线程存活的时间单位(秒、分、时、天）
    参数五：workQueue：指定线程池的任务队列。
    参数六：threadFactory：指定线程池的线程工厂。
    参数七：handler：指定线程池的任务拒绝策略（线程都在忙，任务队列也满了的时候，新任务来了该怎么处理）
 */
public class ThreadPoolTest1 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(
                3,
                10,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(20),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        threadPoolExecutor.allowCoreThreadTimeOut(true);//核心线程数是否回收 默认是false 不回收
    }
}

