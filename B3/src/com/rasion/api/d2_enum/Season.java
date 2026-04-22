package com.rasion.api.d2_enum;

/*
*  4 枚举的细节
        1) 枚举类的第一行只能罗列一些名称，这些名称都是常量，并且每个常量记住的都是枚举类的一个对象。
        2) 枚举类的构造器都是私有的（写不写都只能是私有的），因此，枚举类对外不能创建对象。
        3) 枚举都是最终类，不可以被继承。
        4) 枚举类中，从第二行开始，可以定义类的其他各种成员。
        5) 编译器为枚举类新增了几个方法，并且枚举类都是继承：java.lang.Enum类的，从enum类也会继承到一些方法。
* */
public enum Season {
    SPRING("春意盎然"),SUMMER("热情似火"),FALL("秋高气爽"),WINTER("白雪皑皑");


    private String desc;// 描述季节
    public void show(){
        System.out.println(desc);
    }

   private Season() {
    }

    Season(String desc) {
        this.desc = desc;
    }
}
