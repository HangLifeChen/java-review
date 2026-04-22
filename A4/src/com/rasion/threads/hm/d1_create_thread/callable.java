package com.rasion.threads.hm.d1_create_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class callable {
    public static void main(String[] args) {
        MyCallable c=new MyCallable(100);
        FutureTask<Integer> t=new FutureTask<Integer>(c);
        Thread thread=new Thread(t);
        thread.start();
        try{
            System.out.println(thread.getName()+"is running: "+ t.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
//优点:能够拿到返回结果
//缺点:实现复杂 会阻塞
//1、定义实现类，实现callable接口
class MyCallable implements Callable<Integer>{
    private final int sum;
    public MyCallable(int sum){
        this.sum=sum;
    }
    public Integer call() throws Exception{
        int n=0;
        for (int i = 0; i <= sum; i++) {
            n++;
        }
        return n;
    }
}