package com.rasion.main;

import java.util.Scanner;

/*相关快捷键操作
main/psvm,sout快速输入相关代码
ctrl+d 复制一行
ctrl+x 删除所在行
ctrl+alt+l 格式化代码
alt+shift+上/下 移动代码到上一行/下一行
ctrl+/ 注释代码 */
public class BasicJava {
    public static void main(String[] args) {
        System.out.println("Hello World!!");
//        printHello(5);//(一)、调用功能
//        printLiteral();//(三)、打印常见的字面量
//        printVariable(5);//(四)、变量
//        printDataType();//(五)、数据类型
//        compare(5,6);//(七)、调用方法
//        System.out.println(getRandom(5));//(七)、调用方法，获取一个指定位数的随机数
//        System.out.println(getRandom());//(七)、调用方法，获取一个随机数，重载getRandom
//        divide(5,0);//(七)、调用方法，除数不能为0,使用return 提前结束方法
//        typeConversion();//(八)、类型转换,自动类型转换，强制类型转换
//        System.out.println(expression(10, (byte) 10,10.0,'a'));//(九)、表达式的自动类型提升
//        System.out.println(expression((byte)10,(byte)10));//(九)、表达式的自动类型提升
//        factorial();//（十）、输入输出,为输出阶乘
//        operator();//（十一）、运算符
//        receive(6);//（十二）、赋值
        receive3(20);//三元运算,输出大于等于10的数
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

    //（七）、方法案例
    //定义一个方法，比较任意两个整数大小
    public static void compare(int a,int b){
        if(a>b){
            System.out.println(a+">"+b);
        }else if(a<b){
            System.out.println(a+"<"+b);
        }else{
            System.out.println(a+"="+b);
        }
    }
    //获取一个指定位数的随机数
    public static int getRandom(int n){
        int result=0;
        for(int i=0;i<n;i++){
            result=result*10+(int)(Math.random()*10);
        }
        return result;
    }
    //没有返回值的随机数的方法重载
    public static int getRandom(){
        return (int)(Math.random()*100);
    }
    //无返回值的方法中单独使用return，提前结束方法
    public static void divide(int a,int b){
        if(b==0){
            System.out.println("除数不能为0");
            return;//提前结束方法
        }
        System.out.println(a/b);
    }

    //（八）、类型转换，自动类型转换，强制类型转换
    public static void typeConversion(){
        int a=10;
        double b=a;//自动类型转换
        System.out.println(b);
        double c=10.0;
        int d=(int)c;//强制类型转换,若数据过大，强转后数据溢出，则结果为出错
        System.out.println(d);
        System.out.println((int) c);
    }

    //（九）、表达式的自动类型提升
    public static double expression(int a, byte b, double c, char d){
        return a+b+c+d;
    }
    public static int expression(byte a,byte b){
        return a+b;//byte short char 类型自动提升为int类型
    }

    //（十）、输入输出
    //接收用户输入的一个整数，输出该数的阶乘
    public static void factorial(){
        Scanner scanner=new Scanner(System.in);//创建一个Scanner对象,得到一个Scanner扫描对象
        System.out.println("请输入一个整数：");
        int n=scanner.nextInt();//获取用户输入的整数
        int result=1;
        for(int i=1;i<=n;i++){
            result*=i;
        }
        System.out.println(n+"的阶乘为："+result);
    }

    //（十一）、运算符
    public static void operator(){
        int a=10;
        int b=20;

        //若自增自减单独使用，不用区分运算符是否在前或后，结果都一样
        int c=++a;//先自增再赋值，此时c=11,a=11
        System.out.println("先自增再赋值：c="+c+" a="+a);
        int d=a++;//先赋值再自增，此时d=11,a=12
        System.out.println("先赋值再自增：d="+d+" a="+a);

        System.out.println("加法：a+b="+(a+b));//加法
        System.out.println(a+'b'+"abc");//运算+连接
        System.out.println("abc"+a+'b');//连接
        System.out.println("减法：a-b="+(a-b));//减法
        System.out.println("乘法：a*b="+a*b);//乘法
        System.out.println("除法：a/b="+a/b);//除法
        System.out.println("取余：a%b="+a%b);//取余
    }

    //（十二）、赋值
    //例：收红包，随机获取一个指定位数的随机数作为初始金额，然后收一个红包，金额增加指定金额
    public static void receive(Integer n){
        double money=getRandom(n);//获取一个指定位数的随机数作为初始金额
        System.out.println("收红包前钱数："+money);
        money+=n;//扩展赋值运算符，自带强制类型性转换
        System.out.println("收红包后钱数："+money);
    }
    //帮我演示一下其他几个扩展的赋值运算符
    public static void receive2(){
        int a=10;
        int b=20;
        System.out.println("a="+a);
        System.out.println("b="+b);
        a+=b;//等价于a=a+b
        System.out.println("a+=b="+a);
        a-=b;//等价于a=a-b
        System.out.println("a-=b="+a);
        a*=b;//等价于a=a*b
        System.out.println("a*=b="+a);
    }
    //三元运算符的例子
    public static void receive3(Integer b){
        int a=10;
        int c=a>b?a:b;//三元运算符，a>b为true则c=a，否则c=b
        System.out.println("c="+c);
    }
}