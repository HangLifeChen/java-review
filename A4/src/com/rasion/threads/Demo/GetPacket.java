package com.rasion.threads.Demo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetPacket extends Thread {
    private static List<Double> list;
    private static String name;
    private static Map<String, Double> max=new HashMap<>();
    public GetPacket(List<Double> list,String name){
        this.name = name;
        this.list = list;
    }
    @Override
    public void run() {//100个人抢
        while(list.size() > 0){
            synchronized (list){
                if(list.isEmpty()) break;
                //随机一个索引
                int index = (int)(Math.random()*list.size());
                //从list中删除一个红包
                Double money = list.remove(index);
                //更新抢到的红包的值
                max.forEach((k,v)->{
                    if(k.equals(name)){
                        max.put(k,v+money);
                    }
                });
                System.out.println(name+"抢到"+money+"元，还剩"+list.size()+"个红包");
            }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }}

    public static Map<String, Double> getMax() {
        return max;
    }

    public static void setMax(Map<String, Double> max) {
        GetPacket.max = max;
    }

    public static List<Double> getList() {
        return list;
    }
}
