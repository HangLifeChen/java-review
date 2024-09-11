package com.rasion.map;

import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class mapTraverse {
    public static void main(String[] args) {
        Map<String,String> map=new java.util.HashMap<>();
        map.put("3","王五");
        map.put("1","张三");
        map.put("2","李四");
        map.put("4","赵六");
        map.put("4","老六");
        map.put("5","赵六");
        map.put(null,null);
        System.out.println("HashMap"+map);
/*
        //键找值遍历
        Set<String> keySet=map.keySet();
        for(String key:keySet){
            System.out.println(key+":"+map.get(key));
        }

        //键值对遍历
        Set<Map.Entry<String,String>> entrySet=map.entrySet();
        for(Map.Entry<String,String> entry:entrySet){
            String key=entry.getKey();
            String value=entry.getValue();
            System.out.println(key+":"+value);
//            System.out.println(entry);
        }
        //一步到位
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry);
        }
*/
        //Lambda 遍历
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s+":"+s2);
            }
        });
        //函数式接口的匿名内部类
        map.forEach((key,value)-> System.out.println(key+":"+value));
    }
}
