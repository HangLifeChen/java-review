package com.rasion.threads.hm.d7_thread_pool;

import java.util.concurrent.*;

public class ThreadPoolTest4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(
                3,
                10,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(20),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );
        Future<Integer> future1=threadPoolExecutor.submit(new Cal(10));
        Future<Integer> future2=threadPoolExecutor.submit(new Cal(10));
        Future<Integer> future3=threadPoolExecutor.submit(new Cal(10));
        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());
    }
}

class  Cal implements Callable<Integer>{
    private int sum;
    Cal(Integer sum){
        this.sum=sum;
    }
    @Override
    public Integer call() throws Exception {
        int res=0;
        for (int i = 0; i < sum; i++) {
            res+=i;
        }
        return res;
    }
}