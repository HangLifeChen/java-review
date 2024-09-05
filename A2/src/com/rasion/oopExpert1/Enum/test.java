package com.rasion.oopExpert1.Enum;

public class test {
    public static void main(String[] args) {
        A a1= A.X;
        A a2= A.Y;
        System.out.println(A.X);//重写枚举类A的父类Enum的toString方法
        System.out.println(a1.ordinal());//拿到枚举类的索引
        System.out.println(a2.ordinal());

        //枚举类的应用场景：信息的分类和标志
        //如：上下左右移动照片，移动方向有4个，用枚举类表示
        //虽说用也可以用常量作微信息的标志与分类，但是参数值不受约束（就是传入的参数不是限定内的那四个都能行的通，写别的不报错）
        //但是枚举类如果写不是限定内的就会报错
        move(Move.UP);
    }
    public static void move(Move direction){
        switch (direction){
            case UP:
                System.out.println("向上移动");
                break;
            case DOWN:
                System.out.println("向下移动");
                break;
            case LEFT:
                System.out.println("向左移动");
                break;
            case RIGHT:
                System.out.println("向右移动");
                break;
            default:
                System.out.println("无效操作");
        }
    }
}
