# JavaLearnA2-oopExpert1

### 一、介绍

代码块、内部类、函数式编程、常用API、GUI编程

### 二、语法

#### （一）、代码块
1、类的五大成分：成员变量、构造器、成员方法、代码块、内部类

2、静态代码块：
> 格式：static{ }
> 
> 特点：类记载时自动执行，由于类只会加载一次，所以静态代码块只执行一次，优先考虑于构造器执行。
> 
> 作用：初始化类中的数据（如：对静态变量的初始化赋值）

3、实例代码块
> 格式：{ }
> 
> 特点：每次创建对象时，执行实例代码块，并在构造器前执行。
> 
> 作用：初始化实例变量（如：对非静态变量的初始化赋值）
```java
public class codeBlock {
    public static String NAME;
    public static String[] CARD=new String[54];//初始化数组
    static {//静态代码块，有static修饰,属于类，与类一起优先加载，自动执行一次
        System.out.println("static block");
        NAME="rasion";
        CARD[0]="A";//静态数组只需要初始化一次，就可以在静态代码块中初始化
        CARD[1]="2";
        CARD[2]="3";
    }
    {//实例代码块，没有static修饰，属于对象，与对象一起加载，对象加载几次，就会执行几次
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
```
#### （二）、内部类
当一个类被定义在另一个类内部，则该类称为内部类。
##### 1、成员内部类：
创建成员内部类对象格式：**外部类名.内部类名 对象名= new 外部类名().new 内部类名();**
>成员内部类属于外部类对象持有
>
>(1)、成员内部类可以直接访问外部类的静态成员，也可以直接访问外部类的实例成员
>
>(2)、成员内部类的实例方法中，可以直接拿到当前寄生的外部类对象：外部类.this.成员名
```java
public class main {
    public static void main(String[] args) {
        // 创建成员内部类对象格式：外部类名.内部类名 对象名= new 外部类名().new 内部类名();
        OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();
        innerClass.print();//内部类对象调用内部类方法
    }
}
public class OuterClass {
    //成员内部类:无static修饰，属于外部类的对象持有的
    public class InnerClass{//类有的属性，方法内部类都能有
        private String num="InnerThis";
        public void print(){
            System.out.println("===innerMethod===");
            outerPrint();
            String num="-innerPrint-";
            System.out.println(num);
            System.out.println(this.num);//内部类对象
            System.out.println(OuterClass.this.num);//外部类对象

            OuterClass oc=new OuterClass();//创建外部类对象
            System.out.println(oc.num);
            run();
        }
    }

    //内部类可以访问外部类的静态成员
    public static void outerPrint(){//外部类静态方法
        System.out.println("OuterClass static print");
    }//静态内部类，属于外部类，外部类可以访问
    private String num="OuterThis";//外部类成员变量
    public void run(){}
}
```
##### 2、静态内部类：
创建静态内部类对象格式：**外部类名.内部类名 对象名= new 外部类名.内部类名();**

>static修饰的内部类是外部类自己持有的
> 
> 静态内部类可以直接访问外部类的静态成员；静态内部类不可以直接访问外部类的实例成员
```java
public class main {
    public static void main(String[] args) {
        StaticInnerClass.InnerClass innerClass=new StaticInnerClass.InnerClass();//静态内部类对象
        innerClass.print();
    }
}
public class StaticInnerClass {
    public static class InnerClass{
        private String NAME="inner rasion";
        public void print() {
            System.out.println("StaticInnerClass print");
            //静态内部类可以直接访问外部类的静态成员
            System.out.println("StaticInnerClass NAME:"+StaticInnerClass.NAME);
            //静态内部类不可以直接访问外部类的实例成员
//            System.out.println("StaticInnerClass age:"+age);
            //静态内部类可以间接访问外部类的局部变量
            StaticInnerClass staticInnerClass=new StaticInnerClass();
            System.out.println("StaticInnerClass age:"+staticInnerClass.age);
        }
    }

    public static String NAME="outer rasion";//外部类的静态成员
    public int age=18;//外部类的实例成员，属于外部类对象的
}
```
##### 3、局部内部类：
局部内部类：定义在方法中、代码块中、构造器等执行体中（无具体意义，用来引出匿名内部类）
##### ※4、匿名内部类：
特殊的局部内部类，匿名内部类指：程序员不需要为这个类声明名字，默认有一个隐藏的名字。

格式：**new 类名或接口（参数值...）{ 重写方法 }**

>特点：匿名内部类本质是个子类，并且会立即创建出一个子类对象
> 
> 作用：更方便的创建一个子类对象
> 
> 匿名内部类应用场景：见com.rasion.oopExpert2.InnerClass.Button(开发中不是主动写匿名内部类，而是**调用别人的代码时需要我们写一个匿名内部类**)
```java
public class AnonymityInnerClass {
    public static void main(String[] args) {
    //匿名内部类有名字：外部类名$编号.class
    //匿名内部类本质是一个子类，同时立即创建一个子类对象
        Animal cat=new Animal(){
            @Override
            public void run() {
                System.out.println("cat run");
            }
        };//匿名内部类，同cat类，即是一个子类又是一个子类对象
        cat.run();
        print(cat);
    }
    public static void print(Animal animal){
        System.out.println("start==");
        animal.run();//匿名类对象回调，由于匿名类相当于子类，所以可以调用子类的方法
    }
}

interface Animal{
    public abstract void run();
}
//class cat extends Animal{
//    @Override
//    public void run() {
//        System.out.println("cat run");
//    }
//}
```
#### （三）、函数式编程
Java中的函数(即Lambda表达式)，Java8开始引入了Lambda表达式，替代某些匿名内部类对象，可以简化代码，可读性更强。
> Lambda表达式的格式：**(参数列表)->{匿名内部类被重写的方法体代码}**
#### （四）、常用API

#### （五）、GUI编程

### 三、参考

1. 学习主要链接来源于[[黑马程序员](https://www.bilibili.com/video/BV1gb42177hm?p=83&vd_source=2140b8696bb75ad7bd33e1195bf24372)]
2.  其他可能用得上的链接