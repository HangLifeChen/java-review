package com.rasion.api.d1_generics;

import java.sql.Array;
import java.util.ArrayList;

/*
    目的: 理解泛型擦除  掌握注意事项
    泛型的注意事项
        1、泛型是工作在编译阶段的，一旦程序编译成class文件，class文件中就不存在泛型了，这就是泛型擦除。
        2、泛型不支持基本数据类型，只能支持对象类型（引用数据类型）
 */
public class Test3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        String s = list.get(0);
        boolean res = s.equals("bbb");
        System.out.println(res);


        // 包装类
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(10);
        int num=list1.get(0);
    }
}
