package com.rasion.threads.threadSafe;

public class threadsafe {
    public static void main(String[] args) {
        //创建一个账户类，用于创建A,B共同账户对象，存入100。
        Account A=new Account(1,100);

        //模拟两个线程，A和B，A和B共同操作同一个账户，A和B同时取钱，每次取10。
        new ABThread("A",A).start();
        new ABThread("B",A).start();
    }
}
class Account {
    private Integer id;
    private double balance;
    public void getMoney(double balance){
        String name=Thread.currentThread().getName();
        if(this.balance>=balance){
            System.out.println(name+"取钱成功，余额为："+this.balance);
            this.balance-=balance;
            System.out.println(name+"取钱成功，余额应该为："+this.balance);
        }else{
            System.out.println(name+"取钱失败，余额不足，余额为："+this.balance);
        }
    }

    public Account() {
    }

    public Account(Integer id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
class ABThread extends Thread {
    private Account account;
    public ABThread(String id,Account account){
        super(id);
        this.account=account;
    }
    @Override
    public void run() {
        account.getMoney(100);
    }
}