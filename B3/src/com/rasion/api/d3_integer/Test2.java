package com.rasion.api.d3_integer;

public class Test2 {

    /*
    * 目标: 掌握 Integer 享元设计模式
    * 设计模式: 解决问题的方案
    * 享元设计模式:  节省内存
    * */
    public static void main(String[] args) {
        Integer i1 = Integer.valueOf(100);
        Integer i2 = Integer.valueOf(100);
        System.out.println(i1 == i2);

        Integer i3 = Integer.valueOf(200);
        Integer i4 = Integer.valueOf(200);
        System.out.println(i3 == i4);
//
        Integer i5 = new Integer(50);
        Integer i6 = new Integer(50);
        System.out.println(i5 == i6);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);


    }
}
