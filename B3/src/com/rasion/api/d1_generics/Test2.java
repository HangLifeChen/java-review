package com.rasion.api.d1_generics;

public class Test2 {
    /*

    目标: 掌握泛型类的设计
    *       泛型类的格式 :
        修饰符 class 类名<类型变量，类型变量，…> { }
        注意：类型变量建议用大写的英文字母，常用的有：E、T、K、V 等
        class MyClass <T extends 类型>:

    * */
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<String>();
        list.add("abc");
        String s = list.get(0);

        MyClass<Dog> dogMyClass = new MyClass<>();
        MyClass<XiDog> xiDogMyClass = new MyClass<>();
//        MyClass<Cat> catMyClass = new MyClass<Cat>();

    }
}
