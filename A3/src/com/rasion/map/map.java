package com.rasion.map;

import java.util.Map;

public class map {
    public static void main(String[] args) {
        //HashMap:无序，不重复，无索引
        Map<String,String> map=new java.util.HashMap<>();
        map.put("3","王五");
        map.put("1","张三");
        map.put("2","李四");
        map.put("4","赵六");
        map.put("4","老六");
        map.put("5","赵六");
        map.put(null,null);
        System.out.println("HashMap"+map);

        //LinkedHashMap:有序，不重复，无索引
        Map<String,String> map2=new java.util.LinkedHashMap<>();
        map2.put("1","张三");
        map2.put("4","赵六");
        map2.put("4","老六");
        map2.put("2","李四");
        map2.put("3","王五");
        map2.put("5","赵六");
        map2.put(null,null);
        System.out.println("LinedHashMap"+map2);
    }
}
