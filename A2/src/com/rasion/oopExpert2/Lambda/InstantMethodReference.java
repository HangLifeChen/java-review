package com.rasion.oopExpert2.Lambda;

import java.util.Arrays;

public class InstantMethodReference {
    public static void main(String[] args) {
        //实例方法引用
        Student[] students=new Student[]{
                new Student("rasion",20,"ctgu",'男'),
                new Student("BB",50,"ABC",'a'),
                new Student("EE",10,"ABC",'c'),
                new Student("EE",90,"YUS",'D'),
                new Student("CC",32,"TS",'1')
        };

        Student t=new Student();//创建一个实例对象
        Arrays.sort(students, (s1,s2) -> t.compareAgeInstant(s1,s2));//箭头前后的参数形式一致
        Arrays.sort(students, t::compareAgeInstant);//实例方法引用

        for (Student student:students){
            System.out.println(student);
        }
    }
}
