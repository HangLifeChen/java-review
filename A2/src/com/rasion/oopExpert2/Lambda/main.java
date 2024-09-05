package com.rasion.oopExpert2.Lambda;

import java.util.Arrays;
import java.util.Comparator;

public class main {
    public static void main(String[] args) {
        MyInterface myInterface=new MyInterface() {
            @Override
            public void print() {
                System.out.println("原版的匿名内部类");
            }
        };
        myInterface.print();

        MyInterface myInterface1=() ->{System.out.println("lambda表达式简化匿名内部类");};
        myInterface1.print();

        Student[] students=new Student[]{
                new Student("rasion",20,"ctgu",'男'),
                new Student("BB",50,"ABC",'a'),
                new Student("EE",10,"ABC",'c'),
                new Student("EE",90,"YUS",'D'),
                new Student("CC",32,"TS",'1')
        };
        Arrays.sort(students,(o1, o2)->{return o1.getAge()-o2.getAge();});//简化后的代码，参数列表->{重写的方法体内部}
        Arrays.sort(students, (o1, o2)-> o1.getAge()-o2.getAge());//简化后的代码
        for (Student student:students){//按照年龄排序完之后的数组排序
            System.out.println(student);
        }
    }
}
//函数式接口：只有一个抽象方法的接口
@FunctionalInterface
interface MyInterface{
    //抽象方法
    public abstract void print();
}
