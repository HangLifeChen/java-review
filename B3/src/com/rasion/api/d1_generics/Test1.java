package com.rasion.api.d1_generics;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
    1 泛型
         定义类、接口、方法时，同时声明了一个或者多个类型变量（如：<E>） ，称为泛型类、泛型接口，泛型方法、它们统称为泛型。
    2 作用：泛型提供了在编译阶段约束所能操作的数据类型，并自动进行检查的能力！这样可以避免强制类型转换，及其可能出现的异常。
    3 泛型的本质：把具体的数据类型作为参数传给类型变量。

    目标: 认识泛型  ----->本质上 就是接受数据类型的变量  如果不传递泛型 默认是Object

 */
public class Test1 {
    public static void main(String[] args) {
//        ArrayList  容器  存多个数据 不确定个数
      /*  ArrayList<String> list = new ArrayList<String>();
        list.add("嘻嘻");
        list.add("嘿嘿");

        String s = list.get(0);*/
//        如果泛型不传递 数据类型默认是Object ----->祖宗类
        ArrayList list = new ArrayList();
//        list.add(Object o) : 所有的对象   --->父类类型  多态体现
        list.add("abc");
        list.add(new Scanner(System.in));
        list.add(new Random());
//        不能调用子类的特有方法  强转由风险 操作需谨慎
        String o =(String) list.get(1);
//
//



    }
}




