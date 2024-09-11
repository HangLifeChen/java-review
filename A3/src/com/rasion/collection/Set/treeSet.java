package com.rasion.collection.Set;

import java.util.Comparator;
import java.util.TreeSet;

public class treeSet {
    public static void main(String[] args){
        TreeSet<Student> s=new TreeSet<>();
        s.add(new Student("张三",23,"男"));
        s.add(new Student("李四",19,"女"));
        s.add(new Student("王五",20,"男"));
        s.add(new Student("李七",20,"男"));
        s.add(new Student("赵六",21,"女"));
        System.out.println(s);
        //TreeSet不能为自定义对象排序，因为不知道大小规则
        //方案一：对象类实现一个Comparable比较接口，重写compareTo方法，指定大小比较规则
        //见Student类的compareTo方法

        //方案二：public TreeSet(Comparator c)集合自带比较器Comparator对象，指定比较规则
        TreeSet<Student> s2=new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
//                return o1.getAge()-o2.getAge();//若为double则强转有风险
//                return Double.compare(o1.getAge(),o2.getAge());//使用封装函数
                if(o1.getAge()>o2.getAge()) return 1;
                else if(o1.getAge()<o2.getAge()) return -1;
                else return 1;//这样写更加保险并且操作性更高，可以免掉去重
            }
        });
        TreeSet<Student> s3=new TreeSet<>((o1, o2) -> Double.compare(o1.getAge(),o2.getAge()));
        TreeSet<Student> s4=new TreeSet<>(Comparator.comparingInt(Student::getAge));
    }
}
