package com.rasion.reflect;

import java.lang.reflect.Constructor;

import static java.lang.reflect.AccessibleObject.setAccessible;

public class getClass {
    public static void main(String[] args) throws Exception{
        // 获取Class本身
        Class c1=User.class;
        System.out.println(c1);
/*        //获取类本身：Class.forName("类的全类名")
        try {
            Class c2=Class.forName("com.rasion.reflect.User");
            System.out.println(c2);
            System.out.println(c1==c2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //获取类本身：对象.getClass()
        User user=new User();
        Class c3=user.getClass();
        System.out.println(c3);
        System.out.println(c1==c3);

        //获取类的构造器对象：Class.getConstructors()
        Constructor[] con = c1.getDeclaredConstructors();
        for (Constructor constructor : con) {
            System.out.println(constructor.getName()+": "+constructor);
        }

        //无参构造器
        try {
            System.out.println(c1.getConstructor().getName()+": "+c1.getConstructor());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取一个参数的有参构造器
        try {
            Constructor constructor = c1.getConstructor(String.class);
            System.out.println(constructor.getName()+": "+constructor);
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        //强转User的private构造器为公共的构造器
        Constructor con = c1.getDeclaredConstructor();
        con.setAccessible(true);
        User user = (User) con.newInstance();
        System.out.println(user);
    }
}

class User{
    private String name;

    private User() {
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}