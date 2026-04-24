package com.rasion.threads.hm.d8_work;

public class Ticket extends Thread{
    private int ticket=100;
    private static final Object lock = new Object();
    @Override
    public void run() {
        while (true){
            //同步代码块 任何对象都可以成为锁对象，锁对象唯一
            synchronized (lock){
                if(ticket<=0){
                    break;
                }else {
                    //还有剩余的票
                    try {
                        Thread.sleep(10);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+"卖出了第"+ticket+"号票");
                    ticket--;
                }
            }
            Thread.yield();
        }
    }


}
