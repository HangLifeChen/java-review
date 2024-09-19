package com.rasion.Interf;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})//注解方法和类
public @interface My {
    String value();
    int age() default 18;// 默认值为18
}
