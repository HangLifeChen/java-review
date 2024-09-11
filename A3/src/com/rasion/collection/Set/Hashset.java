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
class Student{
    private String name;
    private int age;
    private String gender;

    public Student() {
    }

    @Override
    public boolean equals(Object o) {//内容的比较，只要内容一样，结果一定是true
        if (this == o) return true;//this指当前对象，o指传入的对象，自己和自己比直接返回true
        if (o == null || getClass() != o.getClass()) return false;//判断是否为空，是否为同一个对象相比较
        Student student = (Student) o;//强转
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(gender, student.gender);//比较各个属性
    }

    @Override
    public int hashCode() {
        //保证不同的学生对象，如果内容一样返回的哈希值一定是一样的
        return Objects.hash(name, age, gender);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}'+"\n";
    }

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
