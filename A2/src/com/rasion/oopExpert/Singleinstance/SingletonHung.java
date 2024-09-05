package com.rasion.oopExpert.Singleinstance;

public class SingletonHung {//饿汉式单例模式：拿对象的时候对象早已生成，故不用加锁，但无法实现延迟加载
    private SingletonHung(){}//1、私有化构造函数，防止外部实例化
    //2、静态变量只在内部加载一次，故可用来记住本类的一个唯一的对象
//    public static final Singleton instance1 = new Singleton();//即使外界不能修改了，但外部仍然可以直接访问
    private static final SingletonHung instance = new SingletonHung();//加final确保在内部不能修改
    //3、静态方法，返回本类的唯一实例
    public static SingletonHung getInstance(){
        return instance;
    }
}
