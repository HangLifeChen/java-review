package com.rasion.extendANDpolymorphism.Demo;

public class GoldCard extends Card{
    //消费金额
    @Override
    public void consumeMoney(double money){
        System.out.println("当前消费：" + money);
        System.out.println("优惠后消费：" + money*0.8);
        setBalance(getBalance() - money*0.8);
        System.out.println("当前余额：" + getBalance());
        if(getBalance()<money*0.8) {
            System.out.println("当前余额：" + getBalance() + "，余额不足，请充值");
            return;
        }
        //判断消费是否大于200，如果大于200，则打印洗车票
        if(money*0.8 > 200){
            System.out.println("消费大于200，打印洗车票");
        }
        else {
            System.out.println("消费小于200，不打印洗车票");
        }
    }
    public GoldCard(){}
    public GoldCard(String carNumber, String ownerName, String ownerPhone, double balance){
        super(carNumber, ownerName, ownerPhone, balance);
    }
}
