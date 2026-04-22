package com.rasion.api.d3_integer;

import java.util.ArrayList;

/*
    包装类
        包装类就是把基本类型的数据包装成对象。

    自动装箱：基本数据类型可以自动转换为包装类型。
    自动拆箱：包装类型可以自动转换为基本数据类型。

    包装类的其他常见操作
        可以把基本类型的数据转换成字符串类型。

        public static String toString(int d)
        public String toString()

        可以把字符串类型的数值转换成数值本身对应的数据类型。
        public static int parseInt(String s)
        public static Integer valueOf(String s)
 */
public class Test {

    public static void main(String[] args) {
        // 10 ----->Integer 对象
//        public String toString() 过时
        Integer i1 = new Integer(10);
        System.out.println(i1 instanceof Integer);
        System.out.println(i1);//重写toString()
//        public static Integer valueof(int d)
        Integer i2 = Integer.valueOf(20);
        System.out.println(i2 instanceof Integer);
//        自动装箱：基本数据类型可以自动转换为包装类型。
        Integer i3=30;//自动装箱
        System.out.println(i3 instanceof Integer);
//    自动拆箱：包装类型可以自动转换为基本数据类型。
        int i4=i1; //自动拆箱
        System.out.println(i4);
//        泛型不支持基本数据类型 ,集合存储多个整数
        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);//自动装箱
        int i5=list.get(0); //自动拆箱

        System.out.println("========================================");
//        可以把基本类型的数据转换成字符串类型。
        int i6=100;
        String s1=i6+"";
        System.out.println(s1);
//        public static String toString(int d)
        String s2 = Integer.toString(200);
        System.out.println(s2);
//        public String toString()
        String s3 = i1.toString();
        System.out.println(s3);
//        可以把字符串类型的数值转换成数值本身对应的数据类型。
//        public static int parseInt(String s)
        int i7 = Integer.parseInt("100");
        System.out.println(i7);
//        public static Integer valueOf(String s)
        int i8 = Integer.valueOf("200");
        System.out.println(i8);

//        扩展 : 2.5 ---->包装类对象
        Double d1 = Double.valueOf(2.5);
        double d2 = Double.parseDouble("2.5");
        boolean b1 = true;
    }
}
