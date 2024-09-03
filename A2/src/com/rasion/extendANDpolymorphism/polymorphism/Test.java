package com.rasion.extendANDpolymorphism.polymorphism;

public class Test{
    public static void main(String[] args){
        People p1 = new Student();
        p1.run();//行为多态
        People p2 = new Teacher();
        p2.run();//方法：编译看左边，运行看右边
        System.out.println(p1.name);//成员变量：编译看左边，运行也看左边
    }
}
class People{
    public String name="人";
    public void run(){}
}
class Student extends People{
    public String school="学生";
    @Override
    public void run(){}
}
class Teacher extends People{
    public String school="老师";
    @Override
    public void run(){}
}
