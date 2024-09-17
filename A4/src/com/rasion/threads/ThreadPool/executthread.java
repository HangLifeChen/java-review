package com.rasion.threads.ThreadPool;

import java.util.concurrent.*;

public class executthread {
    public static void main(String[] args) {
        //创建线程池对象，使用线程池的实现类
        ExecutorService executorService=new ThreadPoolExecutor(2, 3,
                10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        //使用线程池执行Runnable任务
//        Runnable Runnabletask=new RunnableTask1();
//        executorService.execute(Runnabletask);//任务可以复用，提交的第一个任务
//        executorService.execute(Runnabletask);
//        executorService.execute(Runnabletask);//复用线程
//        executorService.execute(Runnabletask);
//        executorService.execute(Runnabletask);

        //使用线程池执行Callable任务
        Future<String> f1=executorService.submit(new CallableTask(100));
        Future<String> f2=executorService.submit(new CallableTask(200));
        Future<String> f3=executorService.submit(new CallableTask(300));
        Future<String> f4=executorService.submit(new CallableTask(400));
        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
            System.out.println(f4.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //一般不关闭线程池，可以一直使用，但是需要调用shutdown方法
//        executorService.shutdown();//等所有任务执行完毕后关闭线程池
//        executorService.shutdownNow();//立即关闭线程池，并打断正在执行的任务

        //当核心线程都在忙时，临时创建新线程
//        executorService.execute(Runnabletask);//临时线程，第六个为临时线程

        //任务拒绝策略
//        executorService.execute(Runnabletask);//拒绝策略，直接抛出异常

    }
}
class RunnableTask1 implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<5;i++) {
            System.out.println(Thread.currentThread().getName()+" is running:"+i);
            try {//模拟耗时操作
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class CallableTask implements Callable<String>{
    private int num;

    public CallableTask(int num) {this.num = num;}
    @Override
    public String call() throws Exception {
        int sum=0;
        for (int i=0;i<num;i++) {
//            System.out.println(Thread.currentThread().getName()+" is running:"+i);
            sum+=i;
        }
        return Thread.currentThread().getId()+":"+sum;
    }
}