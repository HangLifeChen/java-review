# JavaLearnA1

### 一、介绍

A1简介：

### 二、基本语法

#### （一）、功能单元

```java
    public static void printHello(Integer n){//（一）、创建输出功能
        for(int i=1;i<n+1;i++)
        System.out.println("Hello world"+i);
    }
```
#### （二）、注释

    单行注释：//
    
    多行注释：/* */
    
    文档注释：/**
            *这是文档注释
           * */

#### （三）、字面量

    即：掌握数据在程序中的书写格式

```java
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
```

#### （四）、变量

    即：变量就是用来装数据的容器，变量有类型，变量有名称，变量有值。

格式：**数据类型 变量名 = 值;**

    注意：
    数据类型：int、double、char、boolean、String、long、float、short、byte
    变量可以改变值，但类型不能改变。
    ——————————————————————————————————————
    变量的数据存储原理（文本、图片、音频）：
    文本：ASCII码表（0-127）
    图片：RGB
    音频：（波形图）采样率、采样位深、采样位宽、采样精度、采样范围。

| 数据类型    | 数据范围byte                           |
| ----------- | -------------------------------------- |
| byte        | -126~127                               |
| short       | -32768~32767                           |
| int（默认） | -2147483648~2147483647（10位数，21亿） |
| long        | -2^63~ 2^63-1                          |
| float       | -3.4E+38 ~ 3.4E+38（4字节）            |
| double      | -1.7E-308 ~ 1.7E+308                   |
| char        | 0 - 65535                              |
| boolean     | true\false                             |

#### （五）、数据类型

```java
    System.out.println("byte类型："+Byte.MAX_VALUE+" "+Byte.MIN_VALUE);
    System.out.println("short类型："+Short.MAX_VALUE+" "+Short.MIN_VALUE);
    System.out.println("int类型："+Integer.MAX_VALUE+" "+Integer.MIN_VALUE);
    System.out.println("long类型："+Long.MAX_VALUE+" "+Long.MIN_VALUE);
    System.out.println("float类型："+Float.MAX_VALUE+" "+Float.MIN_VALUE);
    System.out.println("double类型："+Double.MAX_VALUE+" "+Double.MIN_VALUE);
    System.out.println("char类型："+Character.MAX_VALUE+" "+Character.MIN_VALUE);
    System.out.println("boolean类型："+true+" "+false);
```

#### （六）、标识符与关键字

关键字：关键字是编程语言中预定义的具有特殊意义的单词。这些单词被保留，不能用作标识符来命名变量。

标识符：标识符是程序中用来唯一标识变量、方法、类、接口、数组等名称的。标识符不能以数字开头，不能包含空格，不能包含特殊字符，不能包含中文。

### 三、参考

1. 学习主要链接来源于[[黑马程序员](https://www.bilibili.com/video/BV1gb42177hm?p=1&amp;vd_source=2140b8696bb75ad7bd33e1195bf24372)]: https://www.bilibili.com/video/BV1gb42177hm?p=1&amp;vd_source=2140b8696bb75ad7bd33e1195bf24372
2.  其他可能用得上的链接
