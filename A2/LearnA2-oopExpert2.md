# JavaLearnA2-oopExpert2

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
>**作用：更方便的创建一个子类对象**
>
>匿名内部类应用场景：见com.rasion.oopExpert2.InnerClass.Button(开发中不是主动写匿名内部类，而是**调用别人的代码时需要我们写一个匿名内部类**)
```java
public class AnonymityInnerClass {
    public static void main(String[] args) {
    //匿名内部类有名字：外部类名$编号.class
    //匿名内部类本质是一个子类，同时立即创建一个子类对象
        Animal cat=new Animal(){
            @Override
            public void run() {System.out.println("cat run");}
        };//匿名内部类，同cat类，即是一个子类又是一个子类对象
//        Animal cat=() -> System.out.println("cat run");//Lambda简化
        cat.run();
        print(cat);
        
        print(new Animal() {
            @Override
            public void run() {System.out.println("inner cat run");}
        });//同上print(cat);一样功能
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
##### 1、Java中的函数(即Lambda表达式)
Java8开始引入了Lambda表达式，**替代函数式接口的匿名内部类**，可以简化代码，可读性更强。

Lambda表达式的格式：**(形式参数列表)->{匿名内部类被重写的方法体代码}**

> 函数式接口：有且仅有一个抽象方法的接口，可以省略接口名，直接使用方法名
> 
> **Lambda简化规则**：
> 
>    a、参数类型可以省略不写
>    b、如果只有一个参数，参数类型省略的同时“( )”可以省略，但多个参数必须写上
>       c、如果Lambda只有一行代码，大括号可以省略，同时必须省略分号，如果这行代码式return语句，则必须去掉return。

```java
public class main {
    public static void main(String[] args) {
        //函数式接口：
        MyInterface myInterface1 = () -> {
            System.out.println("lambda表达式简化匿名内部类");
        };
        myInterface1.print();
        
//public static void sort(T[] a, Comparator<T> c)——————作用：数组按照某个值重排序
//参数一：需要排序的数组   参数二：需要给sort声明一个Comparator比较器对象（指定排序的规则）
        Arrays.sort(students,new Comparator<Student>() {//Comparator为由官方定义的函数式接口
            @Override
            public int compare(Student o1, Student o2) {
                //如果左边对象大于右边对象，返回正整数，否则返回负整数，等于时为0
                return o1.getAge()-o2.getAge();//或写成这样，按照年龄升序
            }
        });
        Arrays.sort(students, (o1, o2)-> o1.getAge()-o2.getAge());//以上部分简化后的代码
    }
}
//函数式接口：只有一个抽象方法的接口
@FunctionalInterface//标记函数式接口，编译器会检查，如果接口中有多个抽象方法，编译器会报错
interface MyInterface{
//抽象方法
    public abstract void print();
}
```
##### 2、方法引用：
Java8中提供了一些常用的方法引用，可以用“::“引用运算符简化Lambda表达式
###### 静态方法引用
> 格式：**类名::静态方法名**
> 
> 使用场景：如果某个Lambda表达式里仅调用了一个静态方法，并且"->"前后的参数形式一致，则可以使用静态方法引用。（见StaticMethodReference和Student.compareAge）
```java
    ...（详见StaticMethodReference）
//    Arrays.sort(students, (o1, o2)-> o1.getAge()-o2.getAge());//Student没有加compareAge方法时
    Arrays.sort(students,(o1, o2)-> compareAge(o1,o2) );//Student加compareAge方法时可化简，Lambda表达式实现
    
        Arrays.sort(students, Student::compareAge);//静态方法引用简化后的代码

public class Student{
    ...（详见Student类）
    public static int compareAge(Student s1,Student s2){
        return s1.getAge()-s2.getAge();
    }
}
```
###### 实例方法引用
> 格式：**对象名::实例方法名**
> 
> 使用场景：如果某个Lambda表达式里只通过对象名称调用一个实例方法，并且"->"前后的参数形式一致，则可以使用实例方法引用。（见InstantMethodReference和Student.compareAgeInstant）
```java
    ...（这里为其他代码，详见InstantMethodReference）
    Student t=new Student();//创建一个实例对象
    Arrays.sort(students, (s1,s2) -> t.compareAgeInstant(s1,s2));//Lambda使用方式
        
    Arrays.sort(students, t::compareAgeInstant);//实例方法引用
        
public class Student{
    ...（详见Student类）
    public int compareAgeInstant(Student s1,Student s2){
        return Integer.compare(s1.getAge(),s2.getAge());
    }
}
```
###### 特定类的方法引用
> 格式：**类型名称::方法名**
> 
> 使用场景：如果某个Lambda表达式里只调用了某个类的实例方法，并且"->"前后的参数形式一致，则可以使用特定类的方法引用。
```java
...（其他代码见SpecialMethodReference）
Arrays.sort(names, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);//字符串按照首字母忽略大小写比较的方法
    }
});//匿名内部类的代码
Arrays.sort(names,(o1, o2)-> o1.compareToIgnoreCase(o2));//Lambda简化后的代码
        
Arrays.sort(names,String::compareToIgnoreCase);//特定方法引用
```
###### 构造器引用
> 格式：**类名::new**
> 
> 使用场景：如果某个Lambda表达式里仅调用了一个构造器，并且"->"前后的参数形式一致，则可以使用构造器引用。

```java
import com.rasion.oopExpert2.Lambda.Student;
import jdk.jfr.DataAmount;

public class main {
//    public static void main(String[] args) {
//        GetStudent gs = new GetStudent() {
//            @Override
//            public Student getName(String name) {
//                return new Student(name);
//            }
//        };//匿名内部类
//        GetStudent gs2 = name -> new Student(name);//Lambda代码
//以上两种代码简化后的代码：        
        GetStudent gs3 = Student::new;//构造器引用
        
        Student s1 = gs.getName("rasion");
        System.out.println(s1);
    }
}

@FunctionalInterface
interface GetStudent {
    Student getName(String name);
}
@Data//封装数据
@AllArgsConstructor//有参构造器
@NoArgsConstructor
class Student {
    private String name;
}
```
#### （四）、常用API
##### 1、String
>[Attention]
>
>只要以 **双引号** 方式创建字符串对象，会存储到**字符串常量池**中，且相同字符串只会储存一份。
>
>通过 **new** 关键字创建字符串对象，每new一次，都会产生一个**新的对象放在堆内存**中。

| 方法名                                                       | 说明                                                     |
| :----------------------------------------------------------- | :------------------------------------------------------- |
| public int length()                                          | 获取字符串长度返回（字符个数）                           |
| public char cahrAt(int index)                                | 获取某个索引位置处的字符返回                             |
| public char[ ] toCharArray()                                 | 讲当前字符串转换成字符数组返回                           |
| public boolean equals(Object anObject)                       | 判断当前字符串与另一个字符串的内容是否一样，一样返回true |
| public boolean equalsIgnoreCase(String anotherString)        | 判断当前字符串与另一个字符串的内容是否一样（忽略大小写） |
| public String substring(int beginIndex,int endIndex)         | 根据开始和结束索引进行截取，得到新的字符串（包前不包后） |
| public String substring(int beginIndex)                      | 从传入的索引处截取，截取到末尾，得到新的字符串返回       |
| public String replace(CharSequence target,CharSequence replacement) | 使用新值，讲字符串中的旧值替换，得到新的字符串           |
| public boolean containt(CharSequence s)                      | 判断字符串中是否包含了某个字符串                         |
| public boolean startsWith(String prefix)                     | 判断字符串是否以某个字符串内容为开头，是则返回true       |
| public String[ ] split(String regex)                         | 把字符串按照某个字符串内容分割，返回字符串数组回来       |

```java
String s1="rasion";//快速创建字符串
System.out.println(s1);//输出rasion而不是地址

String s2=new String();//通过构造器创建字符串
String s3=new String("rasion");

char[] chs={'r','a','s','i','o','n'};
String s4=new String(chs);//把字符数组转换成字符串

System.out.println(s1=="rasion");//字符串在常量池且只有一份，故为true
System.out.println(s3==s4);//new出字符串对象，故为false

//随机验证码在之前的测试中已经做过了，此处不再赘述。
```
##### 2、ArrayList
ArrayList代表集合，用来装数据的，类似数组，但是容量大小可变，功能丰富，开发中用的更多。
(1)、创建ArrayList对象：**ArrayList<String> list=new ArrayList<>();**

(2)、遍历集合：**for(int i=0;i<list.size();i++){String s=list.get(i);System.out.println(s);}**

| 常用方法                                          | 说明                          |
|:----------------------------------------------|:----------------------------|
| public ArrayList()                            | 创建一个空的集合对象                  |
| public boolean add(E e)                       | 在集合的末尾添加一个指定的元素，并返回true     |
| public void add(int index,E element)          | 在集合的指定索引位置添加一个指定的元素，并返回true |                            |
| public E get(int index)                       | 返回指定索引位置的元素                 |
| public int size()                             | 返回集合中元素的个数                  |
| public E remove(int index)                    | 删除指定索引位置的元素，并返回被删除的元素       |
| public boolean remove(Object o)               | 删除指定元素，并返回删除是否成功            |
| public E set(int index,E element)             | 修改指定索引位置的元素，并返回被修改的元素       |
#### （五）、GUI编程
1、GUI:Graphical User Interface，图形用户界面。

2、采用Swing这一GUI编程包，基于AWT包，更加轻量，不依赖操作系统。
```java
    private static void createWindow() {//以下为创建窗口和一个按钮的代码
        JFrame frame = new JFrame("登录窗口");//创建窗口

        JPanel panel = new JPanel();//创建面板
        frame.add(panel);//添加面板

        frame.setSize(300, 200);//设置窗口大小
        frame.setLocationRelativeTo(null);//设置窗口居中
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗口默认操作：关闭窗口，推出程序

        JButton button=new JButton("登录");//创建按钮
        button.setBounds(100,100,80,30);//设置按钮位置和宽高
        panel.add(button);//添加按钮到面板
        frame.setVisible(true);//显示窗口
    }
```
3、布局管理器：Swing中用于控制容器内部子组件的布局方式的对象(FlowLayout、BorderLayout、GridLayout、BoxLayout)。
>**FlowLayout**：按照水平方向从左到右排列组件，当一行排满时，自动切换到下一行
>
>特点：默认居中对齐，可以设置左对齐或右对齐；适用于需要简单排列的场景。
> 
>       JFrame frame = new JFrame("FlowLayout布局管理器");
>       frame.setSize(400, 300);
>       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
>
>       frame.setLayout(new FlowLayout());//设置窗口的布局管理器对象
>
>       frame.add(new JButton("按钮1"));
>       frame.add(new JButton("按钮2"));
>       frame.setVisible(true);

>**BorderLayout**：将容器分为5个区域，North、South、East、West、Center，每个区域只能添加一个组件。
> 
> 特点：适用于要在特定区域布局组件的场景；中间的组件会自动填充剩余的空间。
> 
> 代码见：oopExpert2.GUI.Swing.createWindowBorderLayout方法

>**GridLayout**：将容器按照指定的行数和列数进行布局，每个组件占一个单元格,所有组件大小相同。
> 
> 特点：适用于需要将组件均分到容器中的场景；行和列的数量可以指定。
> 
> 代码见：oopExpert2.GUI.Swing.createWindowGridLayout方法

>**BoxLayout**：将容器按照单一水平或垂直方向排列组件，每个组件占一个单元格，所有组件大小相同。
> 
> 特点：适用于需要沿单一方向排列组件的场景；可以添加垂直或水平方向的间隔来调整组件间距。
> 
> 代码见：oopExpert2.GUI.Swing.createWindowBoxLayout方法

4、事件处理：Java通过事件监听器（EventListener）来完成。
>事件的几种常见写法：
> 
>       1、直接提供实现类，用于创建监听器对象（见GUI.Event）
>       2、直接使用匿名内部类对象，代表事件监听器对象（见GUI.Event）
>       3、自定义窗口，让窗口对象实现事件接口，重写监听器接口方法（见GUI.LoginFrame和GUI.LoginEvent）
>           即：public class LoginFrame extends JFrame implements ActionListener
### 三、参考

1. 学习主要链接来源于[[黑马程序员](https://www.bilibili.com/video/BV1gb42177hm?p=83&vd_source=2140b8696bb75ad7bd33e1195bf24372)]
2.  其他可能用得上的链接[[Lambda表达式理解](https://blog.csdn.net/u014331138/article/details/137213669)]