package com.rasion.oopExpert2.Lambda;

import java.util.Arrays;
import java.util.Comparator;

public class SpecialMethodReference {
    public static void main(String[] args) {
        String[] names={"rasion","zhangsan","lisi","wangwu","Alis","Zhou"};
//        Arrays.sort(names);//默认按照字母ASCII码大小排序

        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);//字符串按照首字母忽略大小写比较的方法
            }
        });//匿名内部类的代码
        Arrays.sort(names,(o1, o2)-> o1.compareToIgnoreCase(o2));//Lambda简化后的代码
        Arrays.sort(names,String::compareToIgnoreCase);//特定方法引用

        for(String name:names)
            System.out.println(name);
    }
}
