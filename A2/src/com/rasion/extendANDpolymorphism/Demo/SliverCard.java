package com.rasion.extendANDpolymorphism.Demo;

public class SliverCard extends Card{
    @Override
    public void consumeMoney(double money){
        System.out.println("当前消费：" + money);
        System.out.println("优惠后消费：" + money*0.9);
        setBalance(getBalance() - money*0.9);
        System.out.println("当前余额：" + getBalance());
        if(getBalance()<money*0.9) {
            System.out.println("当前余额：" + getBalance() + "，余额不足，请充值");
            return;
        }
    }
    public SliverCard(){}
    public SliverCard(String carNumber, String ownerName, String ownerPhone, double balance){
        super(carNumber, ownerName, ownerPhone, balance);
    }
}
