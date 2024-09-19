package com.rasion.Interf;


import org.junit.Test;

import java.lang.annotation.Annotation;

public class mainTest {
    @Test
    public void parseClass(){
        //获取类对象
        Class clazz = main.class;
        //判断类上是否有注解
        if(clazz.isAnnotationPresent(My.class)){
            //获取注解对象
            My my = (My) clazz.getDeclaredAnnotation(My.class);
            //获取注解的值
            System.out.println(((My) my).value());
            System.out.println(((My) my).age());
        }
    }
}
