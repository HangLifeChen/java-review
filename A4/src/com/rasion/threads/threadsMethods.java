package com.rasion.threads;

public class threadsMethods {
    public static void main(String[] args) {
        Thread t1 = new MyThreads("线程1");
//        t1.setName("线程1");
        t1.start();

        Thread t2 = new MyThreads("线程2");
//        t2.setName("线程2");
        t2.start();

        //获取当前线程
        Thread m=Thread.currentThread();
        System.out.println(m.getName());//输出：main
        for(int i=0;i<5;i++){
            System.out.println(m.getName()+" is running: "+i);
            try {
                Thread.sleep(1000);//线程暂停1秒，希望某个程序跑慢点，就添加这个
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==2){//当前i=2时，等待线程1执行完毕
                try {
                    t1.join();//等待线程1执行完毕
                } catch (InterruptedException e) {
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
    public void run() {
        for (int i = 0; i < 5; i++) System.out.println(currentThread().getName()+"："+ i);
    }
}
