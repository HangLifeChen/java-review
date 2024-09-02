package com.rasion.oop;

public class Attention{
    public static int count=100;//静态变量
    public static void print(){//静态方法
        System.out.println("Hello World!");
    }
    public String name;//实例变量，属于对象
    public void prints(){//实例方法，属于对象
    }
    public static void main(String[] args) {

    }
    //（1）、静态方法中可直接访问静态成员，不可直接访问实例成员。
    public static void printTest1(){
        System.out.println(count);
        print();
        //System.out.println(name);//报错
        //prints();//报错
        //System.out.println(this);//报错，this代表的只能是对象
        System.out.println(Attention.count);
    }
    //（2）、实例方法中即可直接访问静态成员，也可直接访问实例成员。
    public void printTest2(){
        System.out.println(count);
        print();
        System.out.println(name);
        prints();
        System.out.println(this);//实例方法中，this代表的是当前对象
    }
}
