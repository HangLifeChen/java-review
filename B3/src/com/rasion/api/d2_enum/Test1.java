package com.rasion.api.d2_enum;
/*
    1 枚举
        枚举是一种特殊类。
    2 枚举类的格式
        修饰符 enum 枚举类名{
            枚举项 ,  枚举项 , ... ;
            其他成员…
        }
    3 枚举的注意事项
        1) 枚举类中的第一行，只能写一些合法的标识符(名称)，多个名称用逗号隔开。
        2) 这些名称，本质是常量，每个常量都是此枚举类的一个对象。

        枚举?------数学 (一枚一枚列举)
        大于等于3 小于等于5 的整数有哪些?  枚举法: 3 4 5
        数学中 问题的答案是有限并且固定的题目 ---->枚举法
        在Java中如果一个类的对象 是有限并且固定的 ------>枚举类






    4 枚举的细节
        1) 枚举类的第一行只能罗列一些名称，这些名称都是常量，并且每个常量记住的都是枚举类的一个对象。
        2) 枚举类的构造器都是私有的（写不写都只能是私有的），因此，枚举类对外不能创建对象。
        3) 枚举都是最终类，不可以被继承。
        4) 枚举类中，从第二行开始，可以定义类的其他各种成员。
        5) 编译器为枚举类新增了几个方法，并且枚举类都是继承：java.lang.Enum类的，从enum类也会继承到一些方法。

 */
public class Test1 {
    public static void main(String[] args) {
//        验证名称是常量  static  final
//        System.out.println(A.X);
//        A.X =null;

//        验证名称保存的对象
//        判断某个对象 是某个类的对象
//        Class<? extends A> aClass = A.X.getClass();
//        System.out.println(aClass);
//        多态的时候---->强制类型转换
//        判断某个对象的类型   对象 instanceof 类型------>boolean
//        System.out.println(A.X instanceof A);

//        Student student = new Student();
//        System.out.println(student);
//        System.out.println(student.getClass());

        Season spring = Season.SPRING;
        spring.show();


        int index = spring.ordinal();
        System.out.println(index);

        Season spring1 = Season.valueOf("SPRING");
        System.out.println(spring1 == spring);


    }
}
