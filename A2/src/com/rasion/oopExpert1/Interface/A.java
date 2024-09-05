package com.rasion.oopExpert1.Interface;

public interface A {
    //JDK8之前，接口只能定义常量和抽象方法，不能定义具体方法。
    //1、常量：接口中的常量默认是public static final的，所以可以省略。
    String NAME="rasion";

    //2、抽象方法：接口中的抽象方法默认是public abstract的，所以可以省略。
//    public abstract void show();
    void show();

    //新增的三种方法
    //a、默认方法，一定要加default修饰符，默认会用public修饰，用接口的实现类对象调用
    default void defaultMethod(){
        System.out.println("defaultMethod");
        privateMethod();
    }

    //b、静态方法，一定要加static修饰符，默认会用public修饰，只能用当前接口名
    static void staticMethod(){//静态方法
        System.out.println("staticMethod");
    }

    //c、私有方法，一定要加private修饰符，默认会用private修饰，用接口中的其他实例方法调用
    private void privateMethod(){//私有方法
        System.out.println("privateMethod");
    }
}
