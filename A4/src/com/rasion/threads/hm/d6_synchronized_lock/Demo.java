package com.rasion.threads.hm.d6_synchronized_lock;

import com.rasion.threads.hm.d3_thread_safe.Ticket;
/*
synchronized JVM级别的锁 自动获得 自动释放 有异常会自动释放锁 同步方案
Lock API级别的 手动获得锁 手动释放锁 有异常不会自动释放锁 同步方案
 */
public class Demo {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        Thread thread1=new Thread(ticket,"窗口1");
        Thread thread2=new Thread(ticket,"窗口2");
        Thread thread3=new Thread(ticket,"窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}


