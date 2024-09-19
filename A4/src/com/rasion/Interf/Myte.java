package com.rasion.Interf;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Myte {
    public static void main(String[] args) throws Exception{
        //获取MyTest注解对象
        Myte mt = new Myte();
        //获取类对象
        Class clazz = Myte.class;
        //遍历所有方法，判断方法上是否有MyTest注解，有则执行
        for(Method m : clazz.getDeclaredMethods()){
            //获取方法上的注解
            Annotation[] ans = m.getAnnotations();
            //遍历注解，判断注解类型是否为MyTest
            for(Annotation an : ans){
                if(an instanceof MyTest){
                    //获取注解对象，并调用方法
                    MyTest mt1 = (MyTest)an;
                    for(int i = 0; i < mt1.count(); i++){
                        m.invoke(mt);
                    }
                }
            }
        }
    }
    @MyTest
    public static void a1(){
        System.out.println("方法一");
    }

    public static void a2(){
        System.out.println("方法二");
    }
    @MyTest(count = 3)
    public static void a3(){
        System.out.println("方法三");
    }
}
