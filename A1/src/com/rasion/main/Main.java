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
        printHello(5);//(一)、调用功能
        printLiteral();//(三)、打印常见的字面量
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
    }
}