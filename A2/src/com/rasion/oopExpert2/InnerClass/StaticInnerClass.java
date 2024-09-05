package com.rasion.oopExpert2.InnerClass;

public class StaticInnerClass {
    public static class InnerClass{
        private String NAME="inner rasion";
        public void print() {
            System.out.println("StaticInnerClass print");
            //静态内部类可以直接访问外部类的静态成员
            System.out.println("StaticInnerClass NAME:"+StaticInnerClass.NAME);
            //静态内部类不可以直接访问外部类的实例成员
//            System.out.println("StaticInnerClass age:"+age);
            //静态内部类可以间接访问外部类的局部变量
            StaticInnerClass staticInnerClass=new StaticInnerClass();
            System.out.println("StaticInnerClass age:"+staticInnerClass.age);
        }
    }

    public static String NAME="outer rasion";//外部类的静态成员
    public int age=18;//外部类的实例成员，属于外部类对象的
}
