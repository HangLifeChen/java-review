package com.rasion.main;

/*相关快捷键操作
main/psvm,sout快速输入相关代码
ctrl+d 复制一行
ctrl+x 删除所在行
ctrl+alt+l 格式化代码
alt+shift+上/下 移动代码到上一行/下一行
ctrl+/ 注释代码 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!!");
//        printHello(5);//(一)、调用功能
//        printLiteral();//(三)、打印常见的字面量
//        printVariable(5);//(四)、变量
        printDataType();//(五)、数据类型
    }
    /**(二)、注释
     * 这是文档注释
     * */
    /*
    这是多行注释
     */
    //这是单行注释
    public static void printHello(Integer n){//（一）、创建功能
        for(int i=1;i<n+1;i++)
        System.out.println("Hello world"+i);
    }

    //(三)、打印常见的字面量
    public static void printLiteral(){
        System.out.println("Hello world");//字符串
        System.out.println(true);//布尔值
        System.out.println(false);//布尔值
        System.out.println(1);//整数
        System.out.println(1.0);//浮点数
        System.out.println('a');//字符
        System.out.println("a");//字符串
        //特殊字符
        System.out.println("Hello\nworld");//换行
        System.out.println("Hello\tworld");//制表符
        System.out.println("Hello\"world");//双引号
        System.out.println("Hello\'world");//单引号
        System.out.println("Hello\rworld");//回车
        System.out.println("Hello\bworld");//退格
        System.out.println("Hello\fworld");//换页
        System.out.println("Hello\tworld");//制表符
        System.out.println("Hello\u0000world");//Unicode码
        System.out.println("======================");
    }

    //(四)、变量
    public static void printVariable(Integer n){
        //定义变量：数据类型 变量名=值;
        int age=10;
        System.out.println("age="+age+" year="+n);
        //为什么要定义变量？     减少代码的冗余和错误率，提高代码的可读性
    }

    //（五）、数据类型
    public static void printDataType(){
        System.out.println("byte类型："+Byte.MAX_VALUE+" "+Byte.MIN_VALUE);
        System.out.println("short类型："+Short.MAX_VALUE+" "+Short.MIN_VALUE);
        System.out.println("int类型："+Integer.MAX_VALUE+" "+Integer.MIN_VALUE);
        System.out.println("long类型："+Long.MAX_VALUE+" "+Long.MIN_VALUE);
        System.out.println("float类型："+Float.MAX_VALUE+" "+Float.MIN_VALUE);
        System.out.println("double类型："+Double.MAX_VALUE+" "+Double.MIN_VALUE);
        System.out.println("char类型："+Character.MAX_VALUE+" "+Character.MIN_VALUE);
        System.out.println("boolean类型："+true+" "+false);
    }
}