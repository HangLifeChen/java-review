# JavaLearnA2-oopExpert

### 一、介绍

有final、单例类、枚举类、抽象类、接口

### 二、语法

#### （一）、final
##### 1、final关键字用来修饰类、方法、变量。

·修饰类：代表该类不能被继承，为最终类。（一般是**用在工具类中**）

·修饰方法：代表该方法不能被重写，为最终方法。

·修饰变量（局部变量、成员变量（静态、实例））：代表该变量不能被修改。（一般是**修饰静态变量**）
> [!CAUTION]
>
> final修饰基本类型（int，double，boolean，char...）的变量，变量存储的数据不能被改变。
> 
> final修饰引用类型（String，Array...）的变量，变量存储的地址不能被改变，但引用指向的对象的数据可以改变。

##### 2、常量：使用了static final修饰成员变量为常量。
通常使用常量记录系统配置信息；常量都统一到常量包内（Constant），方便修改。

程序编译后，常量会被“宏替换”：出现常量的地方全部会被替换成其记住的字面量，减少内存消耗，同常量和直接使用字面量的性能一样。

#### （二）、单例类（设计模式）

1、什么是设计模式：程序n中解法中的最优解（设计模式解决什么问题、解决方案）

2、单例设计模式：确保一个类只有一个实例，并提供一个全局访问点。

3、单例应用场景：任务管理器对象、获取运行时对象（有且仅需要一个对象）

4、饿汉式单例类：在类加载的时候就创建对象，不管用不用，都会创建。
```java
public class Singleton {//饿汉式单例类：拿对象的时候对象早已生成，无论是用不用，都会创建。
    private Singleton(){}//1、私有化构造器
    private static Singleton instance=new Singleton();//2、实例化私有静态变量
    //当类被加载时，静态变量instance会被初始化，此时类的私有构造函数会被调用。这时候，单例类的唯一实例就被创建出来了。
    public static Singleton getInstance(){
        return instance;
    }//3、定义一个类方法返回对象
}
```
5、懒汉式单例类：在类加载的时候不会创建对象，只有当调用getInstance()方法时才会创建对象。
```java
public class Singleton {//懒汉式单例类：拿对象的时候才创建，真正需要对象时才开始创建。
    private Singleton(){}//1、私有化构造器
    private static Singleton instance;//2、定义一个类变量用于存储对象
    public static Singleton getInstance(){//提供一个类方法返回类的唯一对象
        if(instance==null){instance=new Singleton();}
        return instance;
    }
}
```

#### （三）、枚举类

#### （四）、抽象类

#### （五）、接口

### 三、参考

1. 学习主要链接来源于[[黑马程序员](https://www.bilibili.com/video/BV1gb42177hm/?p=70&vd_source=2140b8696bb75ad7bd33e1195bf24372)]
2.  其他可能用得上的链接[[单例模式](https://blog.csdn.net/qmqm011/article/details/88525866)]