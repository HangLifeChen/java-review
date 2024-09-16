package com.rasion.threads.threadSafe;

public class Synchronized {
    public static void main(String[] args) {
        Account B = new Accounts(1, 100);
        new ABThread("A", B).start();
        new ABThread("B", B).start();

        Account C = new Accounts(2, 100);
        new ABThread("C", C).start();
        new ABThread("D", C).start();
    }
}
class Accounts extends Account{
    public Accounts(int i, int i1) {
        super(i, i1);
    }
    private double p=super.getBalance();
    @Override
    public void getMoney(double balance){
        String name=Thread.currentThread().getName();
//        synchronized ("hei"){//同步锁只能为一个唯一对象，这里使用字符串，字符串是内存内只能加载一份，所以可以作为锁。
        synchronized (this){//同步锁只能为一个对象，这里使用this，this为当前对象，不用像字符串一样，每次锁的时候影响到其他对象
            if(p >=balance){
                System.out.println(name+"取钱成功，余额为："+p);
                p-=balance;
                System.out.println(name+"取钱成功，余额应该为："+p);
            }else{
                System.out.println(name+"取钱失败，余额不足，余额为："+p);
            }
        }
    }
}