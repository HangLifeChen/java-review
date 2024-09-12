package com.rasion.Demo;

import java.util.*;
import java.util.stream.Collectors;

public class Room {
    //准备54张牌，给房间使用：定义一个集合容器装54张牌
    private static List<Card> cards=new ArrayList<>();
    {//初始化牌
        String[] colors = {"红桃","方片","梅花","黑桃"};
        String[] sizes = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        int num=0;
        for(String color : colors){
            num++;
            for(String size : sizes){
                cards.add(new Card(color,size,num));
            }
        }
        Collections.addAll(cards,new Card("", "小王",++num),new Card("", "大王",++num));
//        System.out.println(cards);
    }
    //洗牌
    public void shuffles() {
        Collections.shuffle(cards);
        System.out.println("新牌是"+cards);
    }
    //发牌
    public void deal(){
        shuffles();
        //三个玩家
        Map<String,List<Card>> player=new HashMap<>();
        List<Card> lnc=new ArrayList<>();
        player.put("玩家1",lnc);

        List<Card> lnc2=new ArrayList<>();
        player.put("玩家2",lnc2);

        List<Card> lnc3=new ArrayList<>();
        player.put("玩家3",lnc3);

        for(int i=0;i<51;i++){//牌只发51张
            player.get("玩家1").add(cards.get(i++));
            player.get("玩家2").add(cards.get(i++));
            player.get("玩家3").add(cards.get(i));
        }
        //遍历集合
        System.out.println("底牌是:"+cards.subList(cards.size()-3,cards.size()));
        lnc.addAll(cards.subList(cards.size()-3,cards.size()));
        //按照sizes大小排序
//        player.forEach((k,v)->{
//            Collections.sort(v, new Comparator<Card>() {
//                @Override
//                public int compare(Card o1, Card o2) {
//                    return o1.getSize().compareTo(o2.getSize());
//                }
//            });
//        });//实现有误，没有达到目的
        sortCards(lnc);
        sortCards(lnc2);
        sortCards(lnc3);
        for(Map.Entry<String,List<Card>> entry:player.entrySet()){
            System.out.println(entry.getKey()+"的牌是:"+entry.getValue());
        }
    }
    public static void sortCards(List<Card> cards){
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.getNum()-o2.getNum();
            }
        });
   }
}
