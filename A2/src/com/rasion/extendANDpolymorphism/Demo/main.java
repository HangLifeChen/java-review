package com.rasion.extendANDpolymorphism.Demo;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //加油站支付模块
        //加油站推出金卡与银卡
        //卡片信息有：车牌号码，车主姓名、电话号码、卡片余额
        //金卡办理时：存入金额必须>=5000元，优惠：8折，消费满200提供免费洗车服务卡卷
        //银卡办理时：存入金额必须>=2000元，优惠：9折
        //需求：加油站支付机的存款和消费程序
        Card goldCar = new GoldCard("ABC", "张三", "123456789", 5000);
        Card sliverCar = new SliverCard("CDEF", "李四", "234753542", 2000);
        pay(goldCar);
        pay(sliverCar);
    }
    public static void pay(Card card){
        System.out.println("请刷卡，输入当前消费金额：");
        Scanner sc = new Scanner(System.in);
        double money = sc.nextDouble();
        card.consumeMoney(money);
    }
}
