# JavaLearnA3

### 一、简介
A3模块学习：Java异常、泛型、集合框架、Stream流、方法传递、字符集、IO流。
### 二、Java异常
#### (一)、认识异常
Java异常体系：Java.lang.Throwable之下的异常类。

Throwable(父类)-->Error/ (Exception-->RuntimeException/其他异常) 

>**Error**:系统级别错误（严重问题），系统出问题会封装成Error对象抛出，如：内存溢出、栈溢出等。  
> 
> **Exception:异常**，程序运行过程中出现的问题，又分为**运行时异常和编译时异常**。
>       
>       RuntimeException:运行时异常，程序运行过程中出现的问题，如：空指针异常、数组越界等。
>       编译时异常：编译时出现的问题，如：语法错误、类型转换错误等。
>       
>       抛出异常：方法() throws 异常1,异常2{ }//或遇到两个异常只抛出父异常Exception。
>       捕获异常：try{ }catch(异常类型1 变量){ }catch(异常类型2 变量){ }
```java
public class LearnException{
    public static void main(String[] args) {
    //        Runtimeshow();
    //        CompileShow();//方法一、在main添加throws ParseException标签抛出异常
        try {//方法二、捕获异常
            CompileShow();
        } catch (ParseException e){
            e.printStackTrace();//输出异常信息
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        
        try {//两个异常时可以只抛一个Exception类异常，同时CompileShow只需捕获Exception异常即可
            CompileShow();
        } catch (java.lang.Exception e){
            e.printStackTrace();
        }
    }
    public static void Runtimeshow(){//运行时异常
        System.out.println("程序开始");
        //运行时异常：编译阶段不报错，运行时出现的异常，继承自 RuntimeException
        int[] arr = new int[]{1,2,3};
        System.out.println(arr[3]);//java.lang.ArrayIndexOutOfBoundsException——数组索引越界

        System.out.println(10/0);//java.lang.ArithmeticException——除数0，数字操作异常

        System.out.println(String.valueOf(null));//java.lang.NullPointerException——空指针异常
        System.out.println("程序结束");
    }
    public static void CompileShow() throws ParseException, FileNotFoundException {//两个异常一起抛可以只抛一个Exception父异常
        System.out.println("程序开始");
        //编译时异常：编译阶段报错，继承自 Exception
        String str = "2024-08-09 11:40:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(str);//编译时异常，提醒这里代码容易出错
        System.out.println(date);

        InputStream is = new FileInputStream("D/file");
        System.out.println("程序结束");
    }
}
```

#### (二)、异常作用
1、用来定位程序bug关键信息

2、可以作为方法内的一种特殊的返回值，以便通知上层调用者，方法的执行出现问题，用来查找bug。
```java
public class ExceptionAffect {
    public static void main(String[] args) {
        try{
            System.out.println(div(10,0));
            System.out.println("方法执行成功");
        }catch(Exception e){//抛出异常能让程序知道下一步要执行什么
            e.printStackTrace();
            System.out.println("程序出现异常，程序退出");
        }//执行完异常程序也不会死亡
    }
    public static int div(int a,int b) throws Exception{
        if(b==0){
            System.out.println("除数不能为0");
            throw new Exception("除数不能为0,参数有问题");//可以替代return -1;而且更具安全性
        }
        int result=a/b;
        return result;
    }
}
```
#### (三)、自定义异常
1、Java无法定义所有异常，企业内部某种问题想通过异常管理，以便用异常来管理问题，需要**自定义异常**。

2、自定义编译异常：定义一个异常类继承Exception类，并重写构造方法，通过throw new 异常类(**) 创建异常对象并抛出。

3、自定义运行时异常：定义一个异常类继承RuntimeException类，并重写构造方法，通过throw new 异常类(**) 创建异常对象并抛出。

4、如果想要表达**强烈的提醒**(他人易犯的错误)，就要用**编译时异常(少用)**，若然程序员自己能避免(别人不易犯错)，就使用**运行时异常(多用)**。
```java
public class SelfException {
//运行时异常和编译时异常代码基本一致，只有名称有些差别：AgeIllegalRuntimeException和AgeIllegalException
    public static void main(String[] args) {
        try {checkAge(15);
        } catch (AgeIllegalRuntimeException e) {
            e.printStackTrace();
            System.out.println("运行异常：程序出现异常，程序退出");
        }
    }
    public static void checkAge2(int age) throws AgeIllegalRuntimeException{
        if(age<18||age>200){
            throw new AgeIllegalRuntimeException("运行异常：年龄非法，年龄不能小于18，不能大于200");
        }else{System.out.println("年龄合法");}
    }
}
//自定义编译时异常
class AgeIllegalException extends Exception{
    public AgeIllegalException(){}
    public AgeIllegalException(String message){
        super(message);
    }
}

//自定义运行时异常
class AgeIllegalRuntimeException extends RuntimeException{
    public AgeIllegalRuntimeException(){}
    public AgeIllegalRuntimeException(String message){
        super(message);
    }
}
```
#### (四)、异常处理方案
1、底层异常层层上抛，最外层捕获异常，记录下异常信息，并响应适合用户观看的信息进行提醒。

2、最外层获取异常后，尝试重新修复。
```java
public class ExceptionDeal {//最外层获取异常后，尝试重新修复。
    public static void main(String[] args) throws Exception {
        while(true){
            try {
                int age=checkAge();
                System.out.println("年龄："+age);
                break;
            }catch (Exception e){
//                e.printStackTrace();//用来报错
                System.out.println("请重新输入：");
            }
        }
    }
    public static int checkAge( ) throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println("请你输入年龄：");
        int age=sc.nextInt();
        if(age<18||age>200){
            throw new Exception("年龄非法，年龄不能小于18，不能大于200");
        }else{
            return age;
        }
    }
}
```
### 三、泛型(Generic)
#### (一)、认识泛型
1、定义泛型：在类、方法、接口等定义中添加<>，<>中可以添加一个或多个变量类型。

2、作用：提供了在编译阶段约束所能操作的数据类型，并自动进行检查的能力，可以避免强制类型转换，及其有可能出现的异常。

3、泛型本质：把具体的数据类型作为参数传给类型变量，其中我发现集合`ArraryList<Object>`相当于`Object类型`的数组
#### (二)、**泛型类**
基本语法：`修饰符 class 类名<类型变量1、类型变量2...>{   }`

应用场景：在工具类中，经常会有一些方法需要处理不同类型的对象，如集合操作、数据转换等，这时可以使用泛型方法来增强工具类的通用性。

>注意：类型变量用大写字母，如：`T`、`E`、`K`、`V`等。
>
> 可以控制类接收的类型变量，由于支持多个类型变量，故需注意类型变量的顺序，如：`<T,E>`、`<E,T>`之类的。
#### (三)、**泛型接口**
基本语法：`修饰符 interface 接口名<类型变量1、类型变量2...>{   }`
```java
/*====以下代码见com.rasion.generic.InterfaceGeneric包====*/
public interface Data<E> {//既可以接User又可以接Customer
    void add(E e);
    void delete(E e);
    E get(int index);
}
public class User implements Data<User>{//Customer类也是这样的实现，类型变量为Customer
    @Override
    public void add(User e) { }//重构接口方法
    @Override
    public void delete(User e) {}
    @Override
    public User get(int index) {return null;}
    @Override
    public void update(User e) {}
}
public class Generic {
    public static void main(String[] args) {//对象实现区域
        User user = new User();
        user.add(new User());
        Customer customer = new Customer();
        customer.add(new Customer());

        Datff a<User> data1 = new User();
        data1.add(new User());
        data.get(0);

        Data<Customer> data2 = new Customer();
        data2.add(new Customer());
    }
}
```
#### (四)、**泛型方法**、通配符、上下限
##### 1、泛型方法
定义一个方法，在方法定义中添加类型变量，然后在方法中使用类型变量。

**泛型方法作用**：泛型方法可以避免强制类型转换，在编译时就能够报错，同时能够确保方法接收参数的多样性，提升方法的复用性。
```java
public class GenericFunction {
    public static void main(String[] args) {
        //需求：打印任意数组的内容
        Integer[] arr = {1,2,3,4,5};
        print(arr);
        Integer arr2=get(arr, 2);
        System.out.println(arr2);
    }
    public static <T> void print(T[] arr){//泛型无返回值使用方法，打印任意数组类型T
        for (T o : arr) {
            System.out.print(o+" ");
        }
    }
    public static <T> T get(T[] arr,int index){//泛型方法，返回值为T类型
        return arr[index];//返回数组指定索引位置的元素
    }
}
```
##### 2、**通配符(wildcard)与上下限**
通配符是泛型类型的占位符，通配符可以接受任意类型，如：`List<?>`、`List<? extends Car>`、`List<? super BYD>`等。
> **其中泛型上限**：`? extends Car`表示只能接受Car及其子类
> 
> **其中泛型下限**：`? super BYD`表示只能接受BYD及其父类
> 
> 如果通配符是`?`，则能够接受所有的类型变量
```java
public class WildcardGeneric {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Bmw());
        cars.add(new BYD());
        run(cars);//输出：汽车在跑\n宝马在跑\n比亚迪在跑

        ArrayList<Bmw> bmws = new ArrayList<>();
//        run(bmws);//报错，因为集合里面只能是Car类
        bmws.add(new Bmw());
        SystemOut(bmws);//输出：BMW
    }
    
    public static void run(ArrayList<Car> cars){
        //这里是虽然是父类，但是只能够访问Car类，不能访问子类，不像多态
        for (Car car : cars) {  car.run();  }
    }
    
    public static void SystemOut(ArrayList<? extends Car> cars){
        //这里使用通配符上限，可以访问Car类，也可以访问Car子类
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
class Car{
    public void run(){  System.out.println("汽车在跑"); }
    @Override
    public String toString() {  return "Car"; }
}
class Bmw extends Car{...}//重写Car的run和toString
class BYD extends Car{...}//重写Car的run和toString
```
##### 3、泛型支持的类型
泛型不支持基本数据类型，如：`int`、`char`、`boolean`等，但可以支持对象类型(引用类型)
> **解释**：泛型工作在编译阶段，编译阶段结束后不工作了，故泛型在编译后会被擦除，所有类型都会恢复成`Object`类型
>
> 而Object类型**只能接收引用类型（自定义类型或包装类）**，如：`Integer`、`Character`等包装类(把基本数据类型的数据包装成对象的类型)。
> 
> 包装类：`Integer`、`Character`、`Boolean`、`Byte`、`Short`、`Long`、`Float`、`Double`
```java
Integer it1 = Integer.valueOf(10);//把10包装为Integer对象给it
//这样包装可以不用创建一个新的10对象，而是把对象10直接传入it，省去创建一个10对象的过程
//java缓存了Integer对象-128~127，能够直接返回缓存中的对象
Integer it2 = Integer.valueOf(10);
System.out.println(it1==it2);//true，但是如果二者都传入对象130，则返回false

//自动包装：基本数据类型的数据可以自动包装成包装对象的数据，不需要做额外的事情
Integer it3 = 10;//与Integer it3 = Integer.valueOf(10);效果一样
ArrayList<Integer> list = new ArrayList<>();
list.add(1234);//自动装箱

//自动拆箱：包装对象可以自动拆箱成基本数据类型的数据
System.out.println(it3);//true
int i = list.get(0);//自动拆箱

//===================================================
//把基本数据类型转换成字符串，public static String toString(doubel d)
System.out.println(Integer.toString(list.get(0))+1);//12341
Interger p=list.get(0);
String s = p.toString();
System.out.println(s+1);//12341

//字符串类型转基本数据类型，public static Integer valueOf(String s)
String s1="98";
//int i1 = Integer.parseInt(s1);//parseInt/parseDouble和valueOf效果一样
int i1 = Integer.valueOf(s1);
System.out.println(i1+2);//100
```
### 四、Collection集合
1、集合：一种容器，类似数组，但集合大小不固定。

2、两类集合：单列集合、双列集合。
>**Collection代表单列集合**，每个元素（数据）只包含一个值
> 
>**Map代表双列集合**，每个元素包含两个值，key和value（键值对）
#### (一)、Collection集合
> **Collection集合体系**：
>
> |                 |              | ->LinkedList<E> |                    |
> |-----------------| ------------ | --------------- | ------------------ |
> |                 | ->List<E>    < | ->ArrayList<E>  |                    |
> | Collection<E>   < |              |                 |                    |
> |                 | ->Set<E>     < | ->HashSet<E>    | ->LinkedHashSet<E> |
> |                 |              | ->TreeSet<E>    |                    |
>
> **Collection集合特点**：
>
>       List系列集合特点：添加的元素是有序、可重复、有索引的
>       Set系列集合特点：添加的元素是无序（不按照添加顺序展示）、**不可重复**、**无索引的**
>         |HasheSet:无序、不重复、无索引
>         |LinkedHashSet:**有序**、不重复、无索引
>         |TreeSet:**按照大小默认升序排列**、不重复、无索引

##### 1、Collection集合功能：
Collection<E>集合为其他单列集合祖宗接口，它的方法是全部单列结合都会继承。

| Collection方法名                | 说明           |
|------------------------------|--------------|
| public boolean add(E e)      | 把元素e添加到集合中，并返回true |
| public void clear()          | 清空集合中的元素     |
| public boolean remove(E e)   | 删除集合中元素e，并返回true |
| public boolean contains(E e) | 判断集合中是否包含元素e，返回true |
| public boolean isEmpty()     | 判断集合是否为空，返回true |
| public int size()            | 返回集合中元素的个数   |
| public Object[] toArray()    | 把集合中的元素，存储到数组中 |
##### 2、**把集合中的元素，存储到数组中**：
```
String[ ] arr = list.toArray(new String[0]);
for (String s : arr) { System.out.print(s+" "); }//输出数组
```
##### 3、集合的三种遍历：

###### (1)、**迭代器**：Iterator<E> e=collection.iterator();
集合的专用遍历方式(数组没有)
```Java
Collection<String> collection = new ArrayList<>();
collection.add("张三");collection.add("李四");...//添加元素

Iterator<String> it= collection.iterator();//得到集合的迭代器对象
while (it.hasNext()) {//.hasNext()判断集合中是否还有元素，有返回true，没有返回false
    String next = it.next();
    System.out.print(next+" ");//输出：张三 李四 ...
}
```
###### (2)、**增强for循环**：for(元素数据类型 变量名 : 集合名){ }
增强for循环：可以遍历集合或者数组，其本质是迭代器遍历集合的简化写法
```Java
for (String s : collection) {
    System.out.print(s+" ");    }
```
###### (3)、Lambda表达式：集合对象名.forEach(E e)
Collection提供的方法
```Java
collection.forEach(new Consumer<String>() {//匿名内部类，函数接口，重写方法accept
    @Override
    public void accept(String s) {
        System.out.print(s+" ");
    }
});
collection.forEach(s -> System.out.print(s+" "));////使用Lambda方法
collection.forEach(System.out::println);//方法引用简化，每输出一个值都会换行
```
###### (4)、三种遍历方式区别
迭代器：没有索引时，遍历并操作只能用迭代器。有索引时，可以不用迭代器（可以解决并发修改异常的问题）。

增强for和Lambda：只适合做有索引时的遍历。（无法解决并发修改异常的问题）
```Java
Collection<String> list= new ArrayList<>();
list1.add("田五");list1.add("田六");...//添加元素
//迭代器
    Iterator<String> it= list1.iterator();
        while (it.hasNext()){
            String name=it.next();
            if(name.contains("田")){
                it.remove();//这里是直接用迭代器自己方法删除指向的元素
                //list1.remove(name);//要是这样删除就会报异常，会出现并发修改异常
        }
    }
//普通for
    for(int i=0;i<list.size();i++){//或使用倒叙遍历
        String name=list.get(i);
        if(name.contains("田")){
            list.remove(name);
        //没有i--时，每次删除数据导致后一位数据前进，i有跨位的问题，导致漏删
            i--;//加上，删除后后撤一步
        }
    }
//增强for
    for(String s:list1){
        if(s.contains("田")){
            list1.remove(s);//出现并发修改异常
        }
    }
//Lambda表达式
    list1.forEach(s->{
        if (s.contains("田"))
        list1.remove(s);//并发修改异常
    );
```
#### (二)、List集合
List集合：包括ArrayList、LinkedKist；都是有序、可重复、有索引的；同时继承Collectio集合方法。

| List方法名                 | 说明                  |
|-------------------------|---------------------|
| void add(int index,E e) | 在指定位置插入元素e          |
| E remove(int index)     | 删除指定位置的元素e，返回被删除的元素 |
| E set(int index,E e)    | 修改指定位置的元素e，返回被修改的元素 |
| E get(int index)        | 获取指定位置的元素e          | 
##### 1、ArrayList集合(基于数组,占内存少)：
基于数组存储数据：**内存中连续的一块区域A**，根据索引查询数据速度快(根据地址和索引快速定位，查询任意数据耗时相等)，但是增删数据效率低

注意：ArrayList集合**new对象的时候位空数组**，第一次添加数据时，会创建一个**默认大小为10的数组**，每当集合元素个数超过数组大小时，会**扩容成原来的1.5倍**。

##### 2、LinkedList集合(基于链表)(建队列/栈)：
基于双链表存储数据：**内存中不连续的一块区域B，每个结点包含数值和上、下一个结点地址**，查询数据慢，但是增删数据效率高，同时双链表相对于单链表查询较快，链表可以创建索引(跳表)。

LinkedList集合：相较于其他的集合，多了许多首尾操作的特有方法`void addFirst(E e)`,`void addLast(E e)`,`E removeFirst()`,`E getFirst()`等。

**应用场景**：可以用来设计队列（只在首位增删数据）。可以用来设计栈（只在栈顶增删数据）。

#### (三)、Set集合
Set集合：无序，不重复，无索引。

(Set家族自己几乎没有额外新增的常用功能，启用到的方法几乎都是Collection中的方法)

| Set系列集合          | 说明                    |
|------------------|-----------------------|
| HashSet<E>       | 无序，不重复，无索引            |
| LinkedHashSet<E> | `有序`，不重复，无索引          |
| TreeSet<E>        | `排序（默认大小升序排序）`，不重复，无索引 |

**应用场景**：常用于去重，去重后，Set集合中的元素个数就是去重后元素个数。
##### 1、HashSet集合：
没有重复的元素，无索引，耗内存（每个数组元素都挂着一串链表或一个红黑树），相对还是不错的集合。
> 哈希值：`int`类型的随机值，Java中每个对象都有自己的Hash值，`Object类`提供`int hashCode();`返回对象的Hash值。
> 
> 对象Hash值特点：同一个对象多次调用hashCode()方法，返回值是相同的。不同对象hash值大概率不相等，但可能相等（Hash碰撞）。

HashSet底层是Hash表存储数据的，JDK8之前：`Hash表=数组+链表`，JDK8始：`Hash表=数组+链表-+红黑树`。（Hash表增删改查性能都很好的数据结构）

> JDK8之前：数组+链表
> 
>       a、HashSet第一次添加数据，创建默认大小为16的数组，默认加载因子为0.75，数组名table。如果要扩容，则到16*0.75=12时，扩容到原来两倍。
>       b、使用元素的Hash值对数组的长度做运算计算出应存入的位置。
>       c、判断当前位置是否为null，如果是null直接存入。
>       d、如果不为null，表示有元素，则调用equals方法比较相等，则不存；不相等，则存入数组。
>           |JDK8之前，新元素存入数组，占老元素位置，老元素挂下面
>           |JDK8始，新元素直接挂在老元素下面
> 
> JDK8始：数组+链表+红黑树(查询性能比链表要好)
>       
>       当链表长度大于8，且数组长度>=64时，自动将链表转成红黑树。
>       红黑树（增删改查新能较好的数据结构/）：自平衡二叉树。
##### HashSet集合元素去重操作：
由于每一个对象的`Hash`值不一样，如果两个不同对象内的值相同，但是他们的Hash值不同，此时我们就需要**重写对象的`hashCode()`和`equals()`方法**，使得两个对象`HashCode`相等。

```java
class Student {//重写hashCode()和equals()方法，可以自动生成
    private String name;
    private int age;
    private String gender;

    @Override
    public boolean equals(Object o) {//内容的比较，只要内容一样，结果一定是true
        if (this == o) return true;//this指当前对象，o指传入的对象，自己和自己比直接返回true
        if (o == null || getClass() != o.getClass()) return false;//判断是否为空，是否为同一个对象相比较
        Student student = (Student) o;//强转
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(gender, student.gender);//比较各个属性
    }

    @Override
    public int hashCode() {
        //保证不同的学生对象，如果内容一样返回的哈希值一定是一样的
        return Objects.hash(name, age, gender);
    }
    //...Getter()、Setter()、toString()、有参无参构造方法省略
}
```
##### 2、LinkedHashSet集合：
依然基于Hash表实现的，但是它的每个元素都额外的多了一个**双链表**的机制**记录它的前后元素位置**。

但是它每个结点更加占用内存。
##### 3、TreeSet集合：
底层基于红黑树实现的排序：

    (1). Integer,Double默认按照数值本身的大小进行升序排序
    (2). String默认按照字典序（即首字母编号）进行排序
    (3). 自定义对象不能直接排序，需要重写`Comparable`接口的`compareTo()`方法，按照自定义的规则进行排序
```java
//TreeSet不能为自定义对象排序，因为不知道大小规则
    //方案一：对象类实现一个Comparable比较接口，重写compareTo方法，指定大小比较规则
    @Override//Student类需要继承Comparable<Student>
    public int compareTo(Student o) {
        //比较者：this
        //被比较者：o
        //规则1：若左边大于右边，返回正整数
        //规则2：若左边小于右边，返回负整数
        //规则3：若左边等于右边，返回0
        //年龄升序
        if(this.age>o.age){
            return 1;
        }else if(this.age<o.age){
            return -1;
        }
        return 1;//如果为0的话，则会删除二者之一不显示，若为1的话返回this
        //return this.age-o.age;//升序
        //return o.age-this.age;//降序
    }

    //方案二：public TreeSet(Comparator c)集合自带比较器Comparator对象，指定比较规则
    TreeSet<Student> s2=new TreeSet<>(new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
    //           return o1.getAge()-o2.getAge();//若为double则强转有风险
    //           return Double.compare(o1.getAge(),o2.getAge());//使用封装函数
                if(o1.getAge()>o2.getAge()) return 1;
                else if(o1.getAge()<o2.getAge()) return -1;
                else return 1;//这样写更加保险并且操作性更高，可以免掉去重
            }
        });
    TreeSet<Student> s3=new TreeSet<>((o1, o2) -> Double.compare(o1.getAge(),o2.getAge()));//Lambda表达式简化
    TreeSet<Student> s4=new TreeSet<>(Comparator.comparingInt(Student::getAge));//方法引用简化
```
#### (四)、小结
> 若想记住元素添加顺序，需存储重复元素，又要**频繁根据索引查询数据**：用`ArrayList集合`(**最常用**)。
> 
> 若想记住元素添加顺序，且**增删首尾情况较多**：用`LinkedList集合`。
> 
> 不在意元素顺序，也无重复元素需要存储，只希望增删改查都快：用`HashSet集合`。
> 
> 希望记住元素添加顺序，也没有重复元素需要存储，且希望增删改查都快：用`LinkedHashSet集合`。
> 
> 若想对以元素进行排序，也无重复元素需要存储，且希望增删改查都快：用`TreeSet集合`。
### 五、Map集合

### 六、Stream流(辅助集合)

### 七、方法传递

### 八、字符集

### 九、IO流

### 十、学习链接
1. [黑马程序员Java课程](https://www.bilibili.com/video/BV1gb42177hm?p=114&spm_id_from=pageDriver&vd_source=2140b8696bb75ad7bd33e1195bf24372)
2. [A3部分代码仓库](https://gitee.com/RasionLS/java-learn/tree/master/A3)
3. [泛型：继承和通配符](https://blog.csdn.net/yubin1285570923/article/details/108135595)
