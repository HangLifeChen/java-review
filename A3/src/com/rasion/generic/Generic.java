package com.rasion.generic;

import java.util.ArrayList;

public class Generic {
    public static void main(String[] args) {
        //普通的数组
        ArrayList list=new ArrayList();//ArrayList若没有添加<Object>，则无论什么类型都可以添加
        list.add("hello");
        list.add(123);//强转类型异常
        list.add(true);
        list.add(2.2);
        list.add('a');
        for(int i=0;i<list.size();i++) {
            Object obj=list.get(i);
//            String str=(String)obj;
            String str=obj.toString();
            System.out.println(str);
        }

        //三、（一）、泛型集合类似数组
        ArrayList<String> list1=new ArrayList<String>();//代表集合只能添加String类型
        list1.add("hello");
//        list1.add(123);//添加类型错误，编译器报错

        //三、（二）、泛型类
        MyArrayList<String> myList=new MyArrayList<String>();
        System.out.println(myList.add("hello"));
//        System.out.println(myList.add(1)));//报错
    }
}
