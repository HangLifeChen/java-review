# JavaLearnA2-oopExpert

### 一、介绍

有final、单例类、枚举类、抽象类、接口

### 二、语法

#### （一）、final
##### 1、final关键字用来修饰类、方法、变量。

·修饰类：代表该类不能被继承，为最终类。（一般是**用在工具类中**）

·修饰方法：代表该方法不能被重写，为最终方法。

·修饰变量（局部变量、成员变量（静态、实例））：代表该变量不能被修改。（一般是**修饰静态变量**）
> [!CAUTION]（见oopExpert.Final.finaltest）
>
> final修饰基本类型（int，double，boolean，char...）的变量，变量存储的数据不能被改变。
> 
> final修饰引用类型（String，Array...）的变量，变量存储的地址不能被改变，但引用指向的对象的数据可以改变。

##### 2、常量：使用了static final修饰成员变量为常量。
通常使用常量记录系统配置信息；常量都统一到常量包内（Constant），方便修改。

程序编译后，常量会被“宏替换”：出现常量的地方全部会被替换成其记住的字面量，减少内存消耗，同常量和直接使用字面量的性能一样。
```java
public class Constant {//常量包
    public static final String NAME = "rasion";
}
```
#### （二）、单例类（设计模式）

1、什么是设计模式：程序n中解法中的最优解（设计模式解决什么问题、解决方案）

2、**单例设计模式**：确保一个类只有一个实例，并提供一个全局访问点。

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
        return instance;}
}
```

#### （三）、枚举类

1、枚举类的写法：**修饰符 enum 美剧类名{名称1，名称2，名称3; 其他成员...}**
```java
public enum A {//枚举类
    X,Y,Z;//枚举类第一行只能罗列一些名称，这些名称都为常量，并且每个常量会记住枚举类的一个对象
}

Compiled from "A.java"//对A.java的反编译
public final class A extends java.lang.Enum<A>{//枚举类继承了Enum
    public static final A X=new A();//枚举类第一行只能罗列一些名称，这些名称都为常量，并且每个常量会记住枚举类的一个对象
    public static final A Y=new A();//如果只有一个Y的话，可以被视为单例类。
    public static final A Z=new A();
    
    public static A[] values();//返回枚举类的所有实例
    public static A valueOf(java.lang.String var0);//返回指定名称的枚举实例
}
```
2、枚举类的常用应用场景：适合左信息的分类和标志

(枚举类常用于定义常量，枚举类中的常量只能是枚举类的实例，不能被修改。)

虽说用也可以用**常量类**作微信息的标志与分类，但是参数值不受约束（就是传入的参数不是限定内的那四个都能行的通，写别的不报错），但是枚举类的话写限定外的就会报错。
#### （四）、抽象类

1、**abstract**修饰类或者方法，其中抽象类不能实例化，抽象方法不能有具体实现。

2、抽象类的主要特点：抽象类**不能创建对象**，仅作为一种**特殊的父类**，让子类继承并实现

3、一个类继承抽象类，必须**重写完抽象类的全部抽象方法**，否则这个类也必须定义为抽象类。
```java
public abstract class A {//抽象的本质是不能有对象，抽象类的基本作用就是被继承
    private String name;//抽象类有成员变量
    public A(){System.out.println("抽象类A的构造方法");}//抽象类有构造方法
    public void show(){System.out.println("抽象类A的show方法");}//抽象类的方法可以有方法体
//抽象方法，抽象类中可以有没有抽象方法，抽象方法没有方法体，只有方法声明，子类必须重写抽象方法
    public abstract void show();//抽象类的抽象方法不能写方法体
}
```
4、抽象类的应用场景：父类的每个子类的行为不同，但父类只定义了行为，子类必须实现，所以用抽象类，抽象类是为了更好的支持多态。

抽象类简化了需要重写的父类方法的代码，更加便于调用子类时多态的实现，更具解耦性。

5、**模板方法设计模式**：提供了方法作为完成某类操作的模板，模板方法封装了每个实现步骤，允许子类实现特定步骤的实现。
```java
public abstract class fu {//父类抽象类
    public final void show(){//模板方法不能被重写
        System.out.println("模板方法");//子类共同的部分
        show1();//子类不同的部分
    }
    public abstract void show1();//抽象方法，子类一定要重写，不然就报错，这样做是最佳实现
}
public class A extends fu {//子类
    @Override
    public void show1(){System.out.println("A show1方法");}
}
public class B extends fu {//子类
    @Override
    public void show1(){System.out.println("B show1方法");}
}
```
#### （五）、接口
1、interface：传统接口（内部只能写常量和抽象方法/jdk8以前）
### 三、参考

1. 学习主要链接来源于[[黑马程序员](https://www.bilibili.com/video/BV1gb42177hm/?p=70&vd_source=2140b8696bb75ad7bd33e1195bf24372)]
2.  其他可能用得上的链接[[单例模式](https://blog.csdn.net/qmqm011/article/details/88525866)]