package com.rasion.threads.hm.d6_synchronized_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable{
    private int ticket=100;
    private final Lock lock=new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try{
                lock.lock();
                //同步代码块 任何对象都可以成为锁对象，锁对象唯一
                if(ticket<=0){
                    break;
                }else {
                    System.out.println(Thread.currentThread().getName()+"卖出了第"+ticket+"号票");
                    ticket--;
                }
            }catch (Exception e){
                e.getSuppressed();
            }finally {
                lock.unlock();//类似于defer 防止出现异常一直抢占锁
            }
        }
        try {
            Thread.sleep(10);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }


}
