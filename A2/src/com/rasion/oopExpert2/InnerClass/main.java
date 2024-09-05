package com.rasion.oopExpert2.InnerClass;

import java.util.Arrays;
import java.util.Comparator;

public class main {
    public static void main(String[] args) {
        //（二）、1、创建成员内部类对象格式：外部类名.内部类名 对象名= new 外部类名().new 内部类名();
        MenberInnerClass.InnerClass innerClass=new MenberInnerClass().new InnerClass();
//        innerClass.print();

//        成员内部类访问外部类成员的特点
//         1. 成员内部类可以直接访问外部类的静态成员，也可以直接访问外部类的实例成员
//         2、成员内部类的实例方法中，可以直接拿到当前寄生的外部类对象：外部类.this.成员名

        //（二）、2、静态内部类
        StaticInnerClass.InnerClass innerClass1=new StaticInnerClass.InnerClass();
//        innerClass1.print();

        //（二）、4、匿名内部类
        //匿名内部类的应用场景：Button类监听器

        //需求：对学生类按照年龄排序
        Student[] students=new Student[]{
                new Student("rasion",20,"ctgu",'男'),
                new Student("BB",50,"ABC",'a'),
                new Student("EE",10,"ABC",'c'),
                new Student("EE",90,"YUS",'D'),
                new Student("CC",32,"TS",'1')
        };
        for (Student student:students){//按照默认顺序排序
            System.out.println(student);
        }
        System.out.println("----------------");
        //public static void sort(T[] a, Comparator<T> c)
        //参数一：需要排序的数组   参数二：需要给sort声明一个Comparator比较器对象（指定排序的规则）
        Arrays.sort(students,new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {//如果左边对象大于右边对象，返回正整数，否则返回负整数，等于时为0
//                if(o1.getAge()>o2.getAge()){
//                    return 1;
//                }
//                else if(o1.getAge()<o2.getAge()){
//                    return -1;
//                }
//                return 0;
                return o1.getAge()-o2.getAge();//或写成这样，按照年龄升序
            }
        });
        for (Student student:students){//按照年龄排序完之后的数组排序
            System.out.println(student);
        }
    }
}
