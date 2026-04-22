package com.rasion.threads.hm.d1_create_thread;

public class threadsMethods {
    public static void main(String[] args) {
        Thread t1=new MyThreads("线程1");
        t1.start();
        Thread t2=new MyThreads("线程2");
        t2.start();
        t1.setName("线程222");
        Thread m = Thread.currentThread();
        System.out.println(m.getName());
        for (int i = 0; i < 5; i++) {
            System.out.println(m.getName()+"is running"+i);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            if (i==2){
                try{
                    t1.join();//插队让线程1先执行 等待线程1执行完毕
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
class MyThreads extends Thread {
    public MyThreads(String name) {
        super(name);
    }
    @Override
    public void run(){
        for (int i = 0; i <5 ; i++) {
            System.out.println(currentThread().getName());
        }
    }
}