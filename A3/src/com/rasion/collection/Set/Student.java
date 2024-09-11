package com.rasion.collection.Set;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private String name;
    private int age;
    private String gender;

/* //为HashSet()重写equals和hashCode
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
*/

//方案一：对象类实现一个Comparable比较接口，重写compareTo方法，指定大小比较规则
    @Override//Student类需要继承Comparable<Student>
    public int compareTo(Student o) {
        //比较者：this
        //被比较者：o
        //规则1：若左边大于右边，返回正整数
        //规则2：若左边小于右边，返回负整数
        //规则3：若左边等于右边，返回0
        //年龄升序
        if(this.age>o.age){
            return 1;
        }else if(this.age<o.age){
            return -1;
        }
        return 1;//如果为0的话，则会删除二者之一不显示，若为1的话返回this
        //return this.age-o.age;//升序
        //return o.age-this.age;//降序
    }
    public Student() {
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
