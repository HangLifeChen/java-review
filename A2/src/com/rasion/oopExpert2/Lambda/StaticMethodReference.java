package com.rasion.oopExpert2.Lambda;

import java.util.Arrays;

import static com.rasion.oopExpert2.Lambda.Student.compareAge;

public class StaticMethodReference {
    public static void main(String[] args) {
        //向学生类中添加一个静态方法：按照年龄升序排序
        Student[] students=new Student[]{
                new Student("rasion",20,"ctgu",'男'),
                new Student("BB",50,"ABC",'a'),
                new Student("EE",10,"ABC",'c'),
                new Student("EE",90,"YUS",'D'),
                new Student("CC",32,"TS",'1')
        };
        Arrays.sort(students, (o1, o2)-> o1.getAge()-o2.getAge());//原始代码
        Arrays.sort(students,(o1, o2)-> compareAge(o1,o2) );//简化后的代码

        //如果某个Lambda表达式里仅调用了一个静态方法，并且"->"前后的参数形式一致，则可以使用静态方法引用
        Arrays.sort(students, Student::compareAge);//静态方法引用简化后的代码
        for (Student student:students){//按照年龄排序完之后的数组排序
            System.out.println(student);
        }
    }
}
