package com.rasion.collection.Set;

import java.util.HashSet;
import java.util.Objects;

public class Hashset {
    public static void main(String[] args) {
        //HashSet去重
        Student s1=new Student("张三",18,"男");
        Student s2=new Student("李四",19,"女");
        Student s3=new Student("王五",20,"男");
        Student s4=new Student("赵六",21,"女");
        Student s5=new Student("赵六",21,"女");
        HashSet<Student> hashSet=new HashSet<>();
        hashSet.add(s1);
        hashSet.add(s2);
        hashSet.add(s3);
        hashSet.add(s4);
        hashSet.add(s5);
        System.out.println(hashSet);
    }
}
