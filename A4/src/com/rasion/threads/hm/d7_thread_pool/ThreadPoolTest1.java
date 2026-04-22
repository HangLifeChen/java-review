package com.rasion.threads.hm.d7_thread_pool;


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


    }
}

