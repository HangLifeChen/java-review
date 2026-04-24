package com.rasion.threads.hm.d5_synchronized_method;

public class Ticket implements Runnable{
    private int ticket=100;


    @Override
    public void run() {
        while (true){
            boolean res=sellTicket();
            if (!res){
               return;
            }
        }
    }

    public synchronized boolean sellTicket (){
        if(ticket<=0){
            return false;
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
        return true;
    }

}
