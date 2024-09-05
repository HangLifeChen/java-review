package com.rasion.oopExpert2.CodeBlock;

import java.util.Arrays;

public class codeBlock {
    public static String NAME;
    public static String[] CARD=new String[54];//初始化数组
    static {
        System.out.println("static block");
        NAME="rasion";
        CARD[0]="A";//静态数组只需要初始化一次，就可以在静态代码块中初始化
        CARD[1]="2";
        CARD[2]="3";
    }//静态代码块，有static修饰,属于类，与类一起优先加载，自动执行一次

    {
        System.out.println("non-static block");
    }
    public static void main(String[] args) {
        System.out.println("hello main");
        System.out.println(NAME);
        System.out.println(Arrays.toString(CARD));//打印数组

        codeBlock cb=new codeBlock();//创建对象时，会执行实例代码块
        new codeBlock();
        new codeBlock();
        System.out.println(cb);
    }
}
