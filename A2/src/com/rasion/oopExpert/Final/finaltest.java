package com.rasion.oopExpert.Final;

public class finaltest {
    public static final String NAME = "rasion";//3、final修饰静态变量，作为常量使用，不能被修改，常量名称大写，多个单词用下划线隔开
    public final int age = 18;//2、final修饰实例变量（一般没有用）
    public static void main(String[] args) {
        //（一）、final关键字的作用
        //3、final修饰变量表示常量，不能被修改（java中变量只有两种：成员变量（静态、实例）、局部变量（方法内））
        final int a = 10;//4、final修饰基本类型变量
        final int[] array = new int[]{1,2,3};//5、final修饰引用类型变量，不能修改地址，但可以修改引用的值
        array[0] = 100;//修改后没有报错
//        a=333;

        show(90);

        System.out.println(Constant.NAME);//(一)、2、常量
    }
    public static void show(final int c){//3、final修饰局部变量表示常量，不能被修改
//        c = 10;//为其赋值报错
        System.out.println(c);
    }
}
//====================================
final class tool{}//1、final修饰类、一般是工具类加final

class A{
    public final void show(){//2、final修饰方法表示final不能被重写
        System.out.println("final show");
    }
}
class B extends A{
//    @Override
//    public void show(){
//        System.out.println("show");
//    }
}