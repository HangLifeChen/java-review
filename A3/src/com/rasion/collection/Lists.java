package com.rasion.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lists {
    public static void main(String[] args) {
        //1、List家族的集合：有序，可重复，有索引
        List<String> list = new ArrayList<>();//集合的多态
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("java");
        System.out.println(list);//输出：[hello, world, java, java]有序，可重复
        System.out.println(list.get(0));//有索引

        //2、Set家族的集合：无序，不可重复，没有索引
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("world");
        set.add("java");
        set.add("java");
        System.out.println(set);//输出：[world, java, hello]无序，不可重复
//        System.out.println(set.get(0));//报错，没有索引

        //3、把集合转换成数组
        Object[] objects = list.toArray();
        for (Object o : objects) {
            System.out.print(o+" ");
        }
        System.out.println();
        //或者这样：
//        String[] arr1 = list.toArray(value -> new String[value]);
//        String[] arr1=list.toArray(String[]::new);//函数引用，同上
//        for(String s : arr1){
//            System.out.print(s+" ");
//        }
        //上面是lambda表达式，可以省略
        String[] arr = list.toArray(new String[0]);
        System.out.println();
        for (String s : arr) {
            System.out.print(s+" ");
        }
    }
}
