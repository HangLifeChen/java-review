package com.rasion.threads.hm.d7_thread_pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest3 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(
                3,
                10,
                7,
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(20),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );
        for (int i = 0; i < 31; i++) {
            threadPoolExecutor.execute(new Student("小红"+i));
        }

    }
}
