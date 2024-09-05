package com.rasion.oopExpert1.Singleinstance;

public class SingletonLazy {//懒汉式单例类：拿对象的时候才创建，但无法实现延迟加载
    private SingletonLazy(){}//1、私有化构造器
    private static SingletonLazy instance;//2、定义一个类变量用于存储对象
    public static SingletonLazy getInstance(){//提供一个类方法返回类的唯一对象
        if(instance==null){instance=new SingletonLazy();}
        return instance;
    }
}
