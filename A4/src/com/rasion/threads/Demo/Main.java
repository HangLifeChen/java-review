package com.rasion.threads.Demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /**需求：红包雨游戏，某公司100名员工，工号依次从1到100，
        * 公司年会，活动中有红包雨：总计发出200个红包，其中小红包【1-30】元，占比80%，大红包【31-100】元，占比20%
         * 功能：
         * 1、系统模拟上述要求产生200个红包
         * 2、模拟100个员工抢红包雨，输出哪个员工抢到哪个红包的过程，活动结束时提示活动结束
         * 3、结束后，对100名员工按照所抢红包总金额进行降序排序展示，如：3豪员工抢红包总计300元，2号员工抢红包总计200元，以此类推
         * 分析：
         * 1、100个员工为100个线程，竞争200个红包
         * 2、200个红包交给List集合中
        */
        List<Double> list = getRedPacket(200);
        Map<String, Double> max = GetPacket.getMax();
        //创建线程类，创建100个线程抢200个红包
        for(int i = 0; i <=100; i++){
            max.put("员工" + i, 0.0);
            new Thread(new GetPacket(list,"员工" + i)).start();
        }
        //输出每个人的钱数
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(Map.Entry<String, Double> entry : max.entrySet()){
            System.out.println(entry.getKey() + "抢到了" + entry.getValue());
        }
    }
    public static List<Double> getRedPacket(int num){//准备200个红包
        List<Double> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 160; i++) {
            list.add(random.nextDouble(30) + 1.0);
        }
        for (int i = 0; i < 40; i++) {
            list.add(random.nextDouble(70) + 31.0);
        }
        return list;
    }
}
