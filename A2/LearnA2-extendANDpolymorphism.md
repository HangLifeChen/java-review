# JavaLearnA2-extendANDpolymorphism

### 一、介绍

A2简介：关于java继承与多态的学习，加上一个综合实践。

### 二、继承

#### 1、extends
继承关键字：extends，可以让一个类与另一个类建立起父子关系
```java
public calss B extends A{}//其中A是父类，B是子类
```
> [!CAUTION]
>
> 只能继承父类的非私有成员（成员变量、成员方法）
>
> 继承后的创建：子类的对象是由子类、父类共同完成的，所以子类对象是完整的，父类对象是部分。
>
> 继承的好处：代码重用，减少代码量，提高效率。

#### 2、权限修饰符
用来限制类中的成员能够被访问的范围。

| 修饰符    | 本类里 | 同一个包中的其他类 | 子孙类（包括不同包的） | 任意类 |
| --------- | ------ | ------------------ | ---------------------- | ------ |
| private   | √      |                    |                        |        |
| 缺省      | √      | √                  |                        |        |
| protected | √      | √                  | √                      |        |
| public    | √      | √                  | √                      | √      |

```java
public class Father {
    private void privateMethod() {//二、2、权限修饰符之私有方法
        System.out.println("private method");
    }

    void defaultMethod() {//二、2、权限修饰符之缺省方法
        System.out.println("default method");
    }

    protected void protectedMethod() {//二、2、权限修饰符之受保护方法
        System.out.println("protected method");
    }

    public void publicMethod() {//二、2、权限修饰符之公共方法
        System.out.println("public method");
    }
    public static void main(String[] args) {//本类中可以调用的所有方法
        Father father = new Father();
        father.privateMethod();
        father.defaultMethod();
        father.protectedMethod();
        father.publicMethod();//所有类都可以调用public方法
    }
}
//以下为同一包的子类
class SonA extends Father {
    public void test() {
        //privateMethod();//子类中不可以访问父类的私有方法
        defaultMethod();//子类中可以访问父类的缺省方法
        protectedMethod();//子类中可以访问父类的受保护方法
        publicMethod();//子类中可以访问父类的公共方法
    }
}
//以下为不同包的子类
class SonC extends Father {
    public void test() {
        //privateMethod();//子类中不可以访问父类的私有方法
        //defaultMethod();//不同包的子类中可以访问父类的缺省方法
        protectedMethod();//不同包的子类中可以访问父类的受保护方法
        publicMethod();//不同包的子类中可以访问父类的公共方法
    }
}
//以下为不同包的非子类
class main {
    public static void main(String[] args) {
        Father father = new Father();
        //father.privateMethod();
        //father.defaultMethod();
        //father.protectedMethod();
        father.publicMethod();//其他包中，只能访问public方法
    }
}
```
#### 3、继承的特点

| 单继承   | 一个类只能继承一个直接父类                                 |
| -------- |-----------------------------------------------|
| 多层继承 | 不支持多继承，但支持多层继承（多继承的话若两个父类出现相同方法，无法判断调用哪个）     |
| 祖宗类   | Java中的所有类都是Object类的子类（一个类要么默认继承Object，要么间接继承） |
| 就近原则 | 优先访问自己类中，自己类中的没有才访问父类（访问父类的成员要加super）         |
```java
public class TestFeature{//测试类
//二、3、继承的特点
    public static void main(String[] args) {
        zilei zi=new zilei();
        zi.test();
    }
}
class fulei{
    String name="FUlei";
    public void run(){
        System.out.println("fuleiRun");
    }
}
class zilei extends fulei{
    String name="ZiLei";
    public void run(){
        System.out.println("zileiRun");
    }
    public void test(){
        String name="ZiLeiTEST";
        System.out.println(name);//test的name
        System.out.println(this.name);//zilei的name
        System.out.println(super.name);//fulei的name
        run();//zilei的run优先级更高
        this.run();//zilei的run
        super.run();//fulei的run
    }
}
```
#### 4、方法重写(声明不变，重新实现)
子类重写父类的方法，子类对象调用父类方法，实际调用子类重写的方法。（**声明不变，重新实现**）
> [!CAUTION]
>
> 子类重写时，访问权限必须大于或等于父类的该方法的权限（public>protected>default>private）
>
>重写的方法，必须与重写前的方法具有相同的参数列表和返回值类型（返回值类型一样或更小）。
> 
>私有方法（不能被继承所以不能被重写）和静态方法（自己调用）不能被重写，否则报错。
```java
public class TestOverride {
    public static void main(String[] args) {//二、4、方法重写
         animal a=new cat();
//用父类申明对象，利用多态性和向上转型的概念，以实现更加灵活和可扩展的程序设计，降低代码的耦合性
         a.eat();
         cat b=new cat();
         b.eat();
    }
}
class animal{
    public void eat(){System.out.println("animal eat");}
}
class cat extends animal{
    @Override//方法重写的校验注解（标志），要求重写的方法与父类方法签名一致，否则编译报错，可读性好
    public void eat(){System.out.println("cat eat!!!");}
}
```
#### 5、重写toString方法
```java
public class TestOverride {
    public static void main(String[] args) {
         animal a=new animal();
         System.out.println(a);
//若没重写toString方法，则返回：com.rasion.extendANDpolymorphism.extend.cat@4e50df2e
         System.out.println(a.toString());
        //我们直接输出对象，会默认调用Object的toString方法，返回对象的地址信息
        //故我们可以重写toString方法，返回我们想要的信息
    }
}
class animal{
    private String name;
    @Override
    public String toString() {//重写toString方法,返回我们想要的信息
        return "animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
```
#### 6、子类构造器super(...)调用父类构造器（调用父类成员）
子类构造器，必须先调用父类的构造器，再调用自己的构造器。（可以用super（null）指定调用父类的有参构造器）

子类构造器第一行默认都是super()，他会调用父类的无参构造器，若父类没有无参构造器，则报错。

应用场景：有一些参数是处在父类中，子类没有，但子类需要用到，这时，子类构造器中，可以先调用父类的有参构造器，再调用自己的构造器。
```java
public class TestOverride {
    public static void main(String[] args) {
        animal a=new cat("小猫","可爱");
        System.out.println(a);//返回：cat{name='小猫', cute='可爱'}
    }
}
class animal{
    private String name;
    public animal(){}
    public animal(String name){//父类的有参构造器
        this.name=name;
    }
    protected String getName() {return name;}//父类的getter和setter，方便子类调用
    protected void setName(String name) {this.name = name;}//我认为父类的参数最好只允许子类访问
}
class cat extends animal{
    private String cute;
    public cat(){}
    public cat(String name,String cute){//子类有参构造器
        super(name);//===调用父类的有参构造器===
        this.cute=cute;
    }
    @Override
    public String toString() {//只需要重写toString方法,返回我们想要的信息
        return "cat{" +
                "name='" + getName() + '\'' +
                ", cute='" + cute + '\'' +
                '}';
    }
}
```
#### 7、子类构造器this(...)调用兄弟构造器（实现填写默认信息）
一般调用兄弟构造器，可以实现代码复用。

注意：super(..) this(...)必须写在构造器第一行，并且不能同时出现。（兄弟构造器只需要一个调用父类构造器即可）
```java
public class User{
    private String name;
    private int age;
    private String school;
    //...此处省略get、set方法toString方法
    public User(String name, int age) {
        this(name, age, "CTGU");//调用本类其他构造器，以实现填写默认信息
    }
    public User(String name, int age, String school) {
        this.name = name;
        this.age = age;
        this.school=school;
    }
}
```
### 三、多态
#### 1、多态前提：有继承/实现关系；存在父类引用子类对象；存在方法重写

多态是在**继承/实现**的情况下的一种现象、表现为：对象多态、行为多态（对象的多样性，行为的多样性，但是没有成员变量的多态性）
```java
    people p1=new student();//对象多态
    p1.run();//行为多态
    people p2=new teacher();//对象多态
    p2.run();//方法：编译看左边，运行看右边
        
    System.out.println(p2.name);//成员变量：编译看左边，运行也看左边
```
#### 2、多态的好处
右边的对象是解耦合的，更便于扩展和维护。父类类型的变量作为参数可以接收一切子类变量(但是不能调用子类独有功能)
```java
public class TestPolymorphism {
    public static void main(String[] args) {
        people p1=new student();//多态调用不了子类的独有功能
        people p2=new teacher();
        show(p1);
    }
    public static void show(people p) {//父类类型作为参数，可以接收一切子类变量，不能为Student或者teacher
        System.out.println("=====+++=====");
        p.run();
    }
}
```
#### 3、多态下的类型转换（instanceof判断）
强制类型转换：子类 对象名=(子类) 父类对象名;

强制类型转换后能够调用子类的私有方法

> [!CAUTION]
>
> 在运行时，如果发现对象的**正式类型与强制转换后的类型**不同，就会报类型异常（ClassCastException）的错误
> 
> 在强转前可以用instanceof关键字判断对象的真实类型，再进行强转

```java
public class TestPolymorphism {
    public static void main(String[] args) {
        people p1=new student();
        student s=(student)p1;//强制类型转换
//        teacher t=(teacher)p1;//转换错误，因为p1是student类型
        //编译阶段有类型强转不会报错，运行阶段会报错
    }
    public static void show(people p) {
        if(p instanceof teacher) {//判断类型，一般会在方法中写，来判断p是否为teacher类型
            teacher t=(teacher)p;
            ...//调用teacher的独有功能
        }else if(p instanceof student) {
            student s=(student)p;
            ...
        }
    }
}
```
### 四、参考

1. 学习主要链接来源于[[黑马程序员](https://www.bilibili.com/video/BV1gb42177hm?p=1&amp;vd_source=2140b8696bb75ad7bd33e1195bf24372)]
2.  其他可能用得上的链接