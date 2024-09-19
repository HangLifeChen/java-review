package com.rasion.reflect;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.lang.reflect.Field;

public class reflectKJ {
    //简易框架
    public static void main(String[] args) throws Exception{
        P p = new P("rasion", 18);
        save(p);
        User u = new User("TUP");
        save(u);
    }
    public static void save(Object obj) throws Exception{
        PrintStream out = new PrintStream(new FileOutputStream("resource/hello.txt", true));
        //只有反射知道对象有多少字段
        Class c = obj.getClass();
        Field[] fields= c.getDeclaredFields();
        for(Field f:fields){
            f.setAccessible(true);
            out.println(f.getName()+"="+f.get(obj));
        }
        out.println("-------------------");
        out.close();
    }
}

class P{
    private String name;
    private int age;
    public P() {}
    public P(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
