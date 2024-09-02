# JavaLearnA1

### 一、介绍

A2简介：关于java特有的语法学习，加上一个综合实践

### 二、基本语法

#### （一）、面向对象编程

**面向对象三大特征：封装、继承、多态。**

1、**对象**：特殊的数据结构，一个实体，有属性和行为。也可以理解为一张表。

2、**类（对象类）**：特殊的数据结构，有属性和行为。一张模板表。
```java
public class User {//定义一个对象类，并且定义了对象的属性和行为
    private String name;
    private Integer age;
    private boolean gender;
    private String email;
    private String password;
    private Integer math;
    private Integer chinese;
    public void printAllScore(){//输出总成绩
        System.out.println("总成绩为："+(math+chinese));
    }
}
```
3、也把对象和对对象的处理封装到同一个类中，方便调用，节省代码量。
```java
public static void main(String[] args) {
    User s1=insert();
    print(s1);
}
//定义一个返回值为User对象的存储对象数据的方法
public static User insert(){
    User user = new User();//无参构造器返回对象
    user.setName("Rasion");
    user.setAge(20);
    user.setGender(true);
    user.setEmail("rasion@gmail.com");
    user.setPassword("123456");
    user.setMath(100);
    user.setChinese(100);
//   User user = new User("Rasion",20,true,"rasion@gmail.com","123456",100,100);
    return user;
}
public static void print(User user){//定义一个打印对象的方法
    System.out.println("Name: "+user.getName());
    System.out.println("Age: "+user.getAge());
    System.out.println("Gender: "+user.isGender());
    System.out.println("Email: "+user.getEmail());
    System.out.println("Password: "+user.getPassword());
    user.printAllScore();//调用对象类中的方法
}
```
4、java在内存的JVM虚拟机上运行，JAVM虚拟机又分为**堆内存、栈内存和方法区**一同执行程序。堆是存放对象的地方，栈是存放方法的地方，方法区是放类文件的地方。

    变量存在栈里，变量指向对象，对象存在堆里，对象指向类，类存在方法区，将方法区中的方法调到栈中执行
    万物皆对象，一个数据由一个对应的对象处理，我们设计对象时就是在设计类（对象的模板）。

#### （二）、类的基本语法

##### 1、构造器

（1）、构造器：类中定义的方法，用来初始化对象，在类中定义的方法，称为方法，在类中定义的变量，称为属性。
名字与类名一致，无返回值，无参数，无返回值类型，无访问修饰符。

（2）、特点：**创建对象时，对象会自动调用构造器**，如果没有定义构造器，JVM会自动生成一个无参构造器。

（3）、应用场景：创建对象时，调用构造器，立即初始化对象成员变量的值。

（4）、注意：**类默认有一个无参构造器**(没有显示而已)，若你自己定义了有参构造器，那么JVM就不会自动生成一个无参构造器。
```java
public class User {
    //构造器，特殊方法，不能写返回值，名称与类名一致。
    public User() {System.out.println("==无参构造器执行了==");
    }//无参构造器
    public User(String name, Integer age, boolean gender, String email, String password, Integer math, Integer chinese) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.math = math;
        this.chinese = chinese;
    }//有参构造器，构造器重载
}
//在mian方法中调用构造器
public class main() {
    public static void main(String[] args) {
        User user = new User();//无参构造器返回对象
        user.setName("Rasion");//传入数据给无参构造器对象
        user.setAge(20);
        user.setGender(true);
        user.setEmail("rasion@gmail.com");
        user.setPassword("123456");
        user.setMath(100);
        user.setChinese(100);
        User s2 = new User("Rasion", 20, true, "rasion@gmail.com", "123456", 100, 100);
        //有参构造器返回对象,创建对象时，调用构造器，立即初始化对象。
    }
}
```
##### 2、this关键字

（1）、this 关键字：是一个变量，可以用在方法中，调用当前的方法的对象地址。

（2）、应用场景：解决变量名称冲突问题。（见有参构造器）。
```java
public void print(String name){//（二）、2、this关键字解决变量冲突问题
    System.out.println(name+this.name);//this.name拿到的是对象变量(成员变量)name,而不是局部变量name
}
```
##### 3、封装

1、封装的设计要求：**合理隐藏、合理暴露**。

2、（合理隐藏）**使用private关键字**封装变量，防止用户在其他类中随意对本类内的变量修改数据，只允许在本类中直接被访问。

3、（合理暴露）**使用getter和setter方法**，封装变量，让用户在类外直接调用，修改数据。
```java
    public void setAge(Integer age) {
        if(age>0&&age<150){
            this.age = age;
        }else{System.out.println("年龄不合法");}
        //此处为校验，但一般不在成员调用方法中进行，要在其他调用了setAge方法之后再校验。
        //这里最好只有this.age = age;
    }
```

### 三、参考

1. 学习主要链接来源于[[黑马程序员](https://www.bilibili.com/video/BV1gb42177hm?p=1&amp;vd_source=2140b8696bb75ad7bd33e1195bf24372)]
2.  其他可能用得上的链接
