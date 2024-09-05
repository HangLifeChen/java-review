package com.rasion.oopExpert.Singleinstance;

public class Test {
    public static void main(String[] args){
        SingletonHung s1= SingletonHung.getInstance();
        SingletonHung s2= SingletonHung.getInstance();
        System.out.println(s1==s2);//true代表是同一个对象

        SingletonLazy s3= SingletonLazy.getInstance();
        SingletonLazy s4= SingletonLazy.getInstance();
        System.out.println(s3==s4);
    }
}
