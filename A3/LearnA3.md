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
  //这里的 throws 就是在声明：这个方法在执行过程中“可能抛出这些异常” 但要注意一点：它只是声明可能抛出，并不一定真的会抛出
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

3、`Collection<E>`、L`ist<E>`、`Set<E>`和`Map<K,V>`只是接口，其子类都是其实现类。
>**Collection代表单列集合**，每个元素（数据）只包含一个值
> 
>**Map代表双列集合**，每个元素包含两个值，key和value（键值对）
#### (一)、Collection集合
> **Collection集合体系**：
>
> | 接口                | 接口             | 实现类                   | 实现类               |
> |-------------------|----------------|-----------------------|-------------------|
> |                   |                | ->`LinkedList<E>`(常用) |                   |
> |                   | ->`List<E> `   < | ->`ArrayList<E>`      |                   |
> | `Collection<E>`   < |                |                       |                   |
> |                   | ->`Set<E>`     < | ->`HashSet<E> `       | ->`LinkedHashSet<E>` |
> |                   |                | ->`TreeSet<E> `       |                   |
>
> **Collection集合特点**：
>
> | Collection集合                        | 特点说明          |
> |---------------------------|---------------| 
> | List系列集合：                 | 有序、可重复、有索引的   |
> | ArrayList(`根据数组`)         | 有序、可重复、有索引的   |
> | LinkedList(`根据链表`)        | 有序、可重复、有索引的   | 
> | Set系列集合：                  | 无序、不可重复、无索引的  |
> | HashSet(`根据哈希表`)          | `无序`、不可重复、无索引的  | 
> | LinkedHashSet(`双链表索引哈希表`) | `有序`、不可重复、无索引的  |
> | TreeSet(`根据红黑树`)          | `可排序`、不可重复、无索引的 |

##### 1、Collection集合方法：
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
                it.remove();//这里是直接用迭代器自己方法删除指向的元素 迭代器读取内容后不要使用list去更改
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
Map集合也叫做`键值对集合`，格式：`Map<K,V>`，其中K为键，V为值。

注意：所有键不允许重复，但值可以重复，键与值是一一对应的，每一个键只能找到自己对应的值

应用场景：存储一一对应的数据时。
> **Map集合体系**：
>
> | 接口           | 实现类                      | 实现类                  |
> |--------------|--------------------------|--------------------|
> |              | ->HashMap<k,V>(常用)    -> | LinkedHashMap<K,V> |
> | Map<K,V>   < |                          |                    | 
> |              | ->TreeMap<K,V>           |                    |
> 
> **Map集合特点**：都是由键决定，值只是一个附属品，值不做要求
> 
> | Map集合                  | 特点说明         |
> |------------------------|--------------|
> | HashMap(由键决定特点)        | 无序、不重复、无索引   |
> | LinkedHashMap(由键决定特点)  | `有序`、不重复、无索引 |
> | TreeMap(由键决定特点)        | `排序`、不重复、无索引   |
#### (一)、Map集合
##### 1、Map集合方法
| 方法名称                                | 说明                        |
|-------------------------------------|---------------------------|
| V put(K key,V value)                | 添加元素                      |
| V get(Object key)                   | 根据键获取值                    |
| V remove(Object key)                | 根据键删除键值对                  |
| int size()                          | 获取元素大小                    |
| void clear()                        | 清空集合                      |
| boolean containsKey(Object key)     | 判断是否包含键key                | 
| boolean containsValue(Object value) | 判断是否包含值value              |
| boolean isEmpty()                   | 判断是否为空                    |
| boolean equals(Object o)            | 判断是否相等                    |
| Set<K> keySet()                     | 获取全部键的集合(Set集合不可重复)       |
| Collection<V> values()              | 获取全部值的集合(Collection集合可重复) |
| Set<Map.Entry<K,V>> entrySet()      | 获取全部键值对集合(Set集合不可重复)      |
| default void forEach(BiConsumer<? super K,? super V> action)| 结合Lambda表达式遍历集合|
##### 2、Map集合遍历方式
###### 键找值
思想：先获取Map集合全部键，再通过遍历的方式来找值（Set<K> keySet()、V get(Object key)）
```java
//遍历
    Set<String> keySet=map.keySet();
    for(String key:keySet){
        System.out.println(key+":"+map.get(key));
    }
```
###### 键值对
思想：把`键值对`整体包装成一个Entry的实现类对象进行遍历（Set<Map.Entry<K,V>> entrySet()）
```java
//键值对遍历
    Set<Map.Entry<String,String>> entrySet=map.entrySet();
    for(Map.Entry<String,String> entry:entrySet){
        String key=entry.getKey();
        String value=entry.getValue();
        System.out.println(key+":"+value);
//        System.out.println(entry);//一步到位，和上面三行代码一样功能
    }
//一步到位，不需要在for外创建Set对象entrySet()
    for(Map.Entry<String,String> entry:map.entrySet()){
        System.out.println(entry);
    }
```
###### Lambda
default void forEach(BiConsumer<? super K,? super V> action)方法，结合Lambda表达式遍历集合
```java
//Lambda 遍历
    map.forEach(new BiConsumer<String, String>() {
        @Override
        public void accept(String s, String s2) {
            System.out.println(s+":"+s2);
        }
    });
//函数式接口的匿名内部类
    map.forEach((key,value)-> System.out.println(key+":"+value));
```
#### (二)、Map集合实现类
##### 1、HashMap(用的最多)
其实HashSet在底层实现上就是用HashMap的键，舍弃值，故HashMap底层原理与HashSet一致

底层原理：数组+链表+红黑树
##### 2、LinkedHashMap
LinkedHashSet底层原理是LinkedHashMap，每个键值对元素的Entry对象又额外多了一个双链表的机制记录元素顺序。
##### 3、TreeMap
TreeSet是TreeMap的键，舍弃值，都是基于红黑树实现的排序。

也自带一个Comparator比较器，默认是自然排序，也可以自定义排序规则，重写compareTo方法。
#### (三)、MapTest
```java
public class MapTest {
    public static void main(String[] args) {
        List<String> location = new ArrayList<>();
        String[] locat = {"北京", "上海", "广州", "深圳"};
        Random random = new Random();
        for (int i = 1; i <= 80; i++) {
            int index = random.nextInt(locat.length);
            location.add(locat[index]);
        }
//        System.out.println(location);

        //最终统计为键值对集合
        Map<String, Integer> map = new HashMap<>();
        for (String str : location) {
            if (map.containsKey(str)) {//判断是否包含键
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);//键不存在，添加键值对
            }
        }
        map.forEach((k, v) -> System.out.println(k + ":" + v));

        //选出最多的城市
        Collection<Map.Entry<String, Integer>> col = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = col.iterator();//collection的迭代器
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() == Collections.max(map.values())) {
                System.out.println("投票最多的城市是：" + entry.getKey());
            }
        }
    }
}
```
### 六、Stream流(辅助集合)
Stream流是Java8新特性，结合Lambda，**用来简化集合遍历，简化数据处理，简化数据收集**的一种编程方式。

#### (一)、Stream流开发步骤：

    1、创建数据源（集合/数组），获取数据源的Stream流
    2、获取一个流中的数据，对数据进行操作，得到一个结果（对数据处理计算）
    3、获取处理的结果（遍历统计收集到一个新的集合中返回）
```java
List<String> list = List.of("张三峰", "张三", "流水","qiqi");

//传统方案找出姓张的三个字的人
    List<String> newlist=new ArrayList<>();
    for (String s : list) {
        if(s.startsWith("张")&&s.length()==3){
            newlist.add(s);
        }
    }
    System.out.println(newlist);

//stream流
    list.stream().filter(s->s.startsWith("张"))
                .filter(s->s.length()==3)
                .forEach(System.out::println);

//stream流收集传回对象
    List<String> newlist2=list.stream().filter(s->s.startsWith("张")).filter(s->s.length()==3).collect(Collectors.toList());
    System.out.println(newlist2);
```
#### (二)、获取Stream流
Stream流本身是一个接口，所以需要通过Collection集合的`Stream<E> stream()`方法获取，数组的通过`Stream<T> stream(T[] array)`/`stream<T> of(T.. values)`工具类获取。
```java
public static void getstreams(){
    //获取Stream流
    //1、集合stream流，所有单列结合获取Stream流都要调用stream方法
    Collection<String> list = new ArrayList<>();
    Stream<String> liststream = list.stream();

    //2、Map集合获取Stream流，获取键流，值流，键值对流
    Map<String, String> map=new HashMap<>();
    Stream<String> valueStream = map.values().stream();//值流
    Stream<String> keyStream = map.keySet().stream();//键流
    Stream<Map.Entry<String, String>> entryStream = map.entrySet().stream();//键值对流

    //3、获取数组的流
    String[] strs = {"a","b","c"};
    Stream<String> stream = Arrays.stream(strs);
    Stream<String> stream1 = Stream.of(strs);
    Stream<String> stream2 = Stream.of("a","b","c");//等价于Arrays.stream(strs)
}
```
#### (三)、Stream流中间方法
Stream流为链式编程，用完一个流后会返回一个新的流再接着使用。

| Stream流提供的中间方法                                                              | 说明                                                  |
|-----------------------------------------------------------------------------|-----------------------------------------------------|
| `Stream<T> filter(Predicate<? super T> predicate)`                          | 筛选，过滤，过滤流中的元素，返回一个新流，该流包含所有满足指定条件的元素                |
| `<R> Stream<T> map(Function<? super T,? extends R> mapper)`                 | 映射，把流中的元素按照一定的规则映射到另一个流中                            |
| `static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)` | 合并两个流，返回一个新流                                        |
| `Stream<T> sorted()`                                                        | 对元素进行升序排序                                           |
| `Stream<T> sorted(Comparator<? super T> comparator)`                        | 按照指定规则排序                                            |
| `Stream<T> distinct()`                                                      | 去除流中重复元素(基本类型已经重写HashCode和equals方法，所以可以去除自定义对象重复元素) |
| `Stream<T> limit(long maxSize)`                                             | 获取前n个元素，返回一个新流                                      |
| `Stream<T> skip(long n)`                                                    | 跳过前n个元素，返回一个新流                                      |
| `Stream<T> peek(Consumer<? super T> action)`                                | 对每个元素进行操作                                           |

```java
public static void getdouble(){
    List<Double> list = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5,5.5, 6.6, 7.7, 8.8, 9.9, 10.1);
    //默认升序,去重
    list.stream().sorted().distinct().forEach(System.out::println);
    System.out.println("=====");
    //只需要最大的两个元素
    list.stream().sorted(Comparator.reverseOrder()).distinct().limit(2).forEach(System.out::println);
    System.out.println("=====");
    //跳过前两个
    list.stream().skip(2).forEach(System.out::println);
    System.out.println("=====");
    //加工方法
    list.stream().map(s->"加十分后"+(s+10)).forEach(System.out::println);
    System.out.println("=====");
    //合并流
    Stream<Double> stream1 = Stream.of(1.1, 2.2, 3.3);
    //统计合并的流的长度
    System.out.println(Stream.concat(stream1,list.stream()).count());
  	//操作元素
 		List<String> list = List.of("张三", "李四", "王五");
    list.stream()
        .peek(s -> System.out.println("元素: " + s))
        .forEach(System.out::println);
}
```
#### (四)、Stream流终结方法
终结方法是指调用完成后，不会返回新的Stream流，没法继续使用流。

| Stream流终结方法 | 说明                                         |
|-------------|--------------------------------------------|
| `void forEach(Consumer<? super T> action)` | 遍历，对流中的元素进行消费，不返回新的流，遍历完就结束了               |
|`long count()` | 统计流中元素个数                                   |
|`Optional<T> min(Comparator<? super T> comparator)` | 返回流中的最小元素(给一个比较器)，如果流为空，返回Optional.empty() |
|`Optional<T> max(Comparator<? super T> comparator)` | 返回流中的最大元素，如果流为空，返回Optional.empty()         |
```        
//Optional的Stream流终结方法
    Optional<Double> max=list.stream().max((list1,list2)->Double.compare(list1,list2));
    System.out.println(max);//输出最大的值
```
#### (五)、收集Stream流
Stream流是方便操作集合/数组的手段，但是数组/集合才是开发中的目的，我们要**把流操作后的结果转到数组/集合中**。

| Stream流收集方法 | 说明                                                |
|-------------|---------------------------------------------------|
| `R collect(Collector<? super T, A, R> collector)` | 收集流中的元素，返回一个新集合，或者一个新数组，或者一个新值，具体看Collector接口的实现  |
|`Object[] toArray()` | 把流中的元素收集到数组中，返回一个Object数组，元素类型为流中元素的类型            |
|`static <T> collector toList()` | 把流中的元素收集到List集合中，返回一个List集合，元素类型为流中元素的类型            |
|`static <T> collector toSet()` | 把流中的元素收集到Set集合中，返回一个Set集合，元素类型为流中元素的类型            |
|`static <T> collector toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper)` | 把流中的元素收集到Map集合中，返回一个Map集合，元素类型为流中元素的类型，keyMapper和valueMapper是函数式接口，用来获取键值对 |

一个流只能收集一次，所以想要把流转到两个集合/数组中去只能重新创建流，或者使用函数赋值。
#### (六)、综合案例
1、可变参数：格式`数据类型...参数名称`

优势：接收参数灵活，可以替代数组传参，内部拿取数据为数组，可变参数在形参列表中只能有一个，只能在形参列表中最后面。

2、Collectors工具类：操作集合的工具类，静态方法。

    批量加数据：`Collections.addAll(list,元素1,元素2,元素3...);`
    打乱List集合中元素排序：`Collections.shuffle(list);`
    对List集合元素升序排序：`Collections.sort(list);`
    对List集合按照比较器排序：`Collections.sort(list,比较器);`
### 七、文件操作与递归
#### (一)、存储数据
存储数据的方案：1、变量 2、数组 3、对象 4、集合 都存在内存中，一旦程序结束，数据就没有了。5、文件，存储在磁盘中，程序结束，数据还在。

1、File是java.io包下的类，File的对象代表当前操作系统的文件（文件或文件夹）。

2、注意：**FIle只能对文件本身进行操作**，但是不能读写文件里面存储的数据。而**IO流是用来读写数据**的（读写文件，或网络中的数据...）。
#### (二)、FIle对象
1、创建File对象：`File file = new File("文件路径");`可以创建文件或者文件夹

2、文件操作实例：
```java
public static void startFile(){//(见FileOperate.Files.java)以下为一些文件的操作
    //创建File对象，获取某个文件的信息，默认在工程下找
    String path = "resource\\mapper.png";//或是String path = "resource/mapper.png";
    String path2 = "resource/exists.txt";
    java.io.File file = new java.io.File(path);
    System.out.println("文件名："+file.getName());
    System.out.println("文件是否存在："+file.exists());
    System.out.println("文件是否可读："+file.canRead());
    System.out.println("文件是否可写："+file.canWrite());
    //获取字节个数
    System.out.println("文件大小："+file.length());
    System.out.println("文件大小(KB)："+new DecimalFormat("0.00").format(file.length()/1024.0) +"KB");
    System.out.println("文件大小(MB)："+new DecimalFormat("0.00").format(file.length()/(1024.0*1024))+"KB");
    //获取文件名字
    System.out.println("文件名字："+file.getName());
    //是不是文件，或文件夹
    System.out.println("是不是文件："+file.isFile());
    System.out.println("是不是文件夹："+file.isDirectory());
    //获取绝对路径
    System.out.println("绝对路径："+file.getAbsolutePath());
    //获取使用路径
    System.out.println("使用相对路径："+file.getPath());
    //获取最后修改时间，并格式化时间
    System.out.println("最后修改时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()));
/*
    //创建对象代表不存在的文件路径
    java.io.File file2 = new java.io.File(path2);
    if(!file2.exists()) {
        try {
            file2.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }else {
        System.out.println("文件已存在");
    }

    //创建对象代表不存在文件夹路径
    java.io.File file3 = new java.io.File("resource/test");//只能创建一级文件夹
    if(!file3.exists()) {
        file3.mkdir();
    }else {
        System.out.println("文件夹已存在");
    }
    //创建多级文件夹
    java.io.File file4 = new java.io.File("resource/test/test2/test3");//创建多级文件夹
    if(!file4.exists()) {
        file4.mkdirs();
    }else {
        System.out.println("文件夹已存在");
    }

    //删除操作
    System.out.println("删除"+path2+"结果："+file2.delete());
    System.out.println("删除resource/test/test2/test3结果："+file4.delete());
    //只能删除空文件夹，不能删除非空文件夹,，删除后的文件不会进回收站
    //要想删除有文件的文件夹，只能用递归算法写方法删除
*/
    //获取某个文件夹下的所有一级文件名称
    java.io.File file5 = new java.io.File("resource");
    String[] fileNames = file5.list();
    System.out.println("文件夹下文件个数："+fileNames.length);
    System.out.println("文件夹下文件名称：");
    for(String name:fileNames){
        System.out.println(name);
    }
    //获取一级文件对象，还可以对文件对象进行操作
    java.io.File[] files = file5.listFiles();
    System.out.println("文件夹下文件个数："+files.length);
    System.out.println("文件夹下文件名称与路径：");
    for(java.io.File f:files){//获取绝对路径
        System.out.println(f.getName()+":"+f.getAbsolutePath());
    }
        /**
         * 对listFiles()方法注意
         * 当主调是文件，或者路径不存在，返回null
         * 主调是空文件夹，返回长度为0的数组
         * 主调是一个有内容的文件夹时，将里面的所有一级文件和文件夹的路径放在File数组中返回
         * 当主调是一个文件夹，且里面有隐藏文件时，将里面的所有文件和文件夹的路径放在File数组中返回，包含隐藏文件
         * 当主调是一个文件夹，但是没有权限访问该问价夹时，返回null。
         */
}
```

#### (三)、多级文件搜索(递归)
方法自己调用自己为递归。

递归算法三要素(以阶乘为例)：递归要有公式、递归有终结点、递归方向要走向终结点。（有明确公式规定的）

无明确公式：如在D盘搜索WeChat.exe文件(见FileOperation.Search.java)和啤酒问题(见A3->FileOperation.Beer.java)
> 1. 获取D盘下的所有一级文件对象
> 2. 遍历全部一级文件对象，判断是否是文件WeChat.exe
> 3. 若为文件，判断是否为自己想要的
> 4. 若为文件夹，继续调用1步骤
```java
public class FileSearch {//利用递归搜索盘符内某一文件并打开
    public static void main(String[] args) {
//        String fileName=startFileSearch();
        File dir=new File("E:/");//搜索盘符
        try {
            searchFile(dir,"mapper.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String startFileSearch(){
        System.out.println("请输入要查找的文件名：");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        return scanner.nextLine();
    }
    public static void searchFile(File dir,String fileName) throws IOException {
        if(dir==null || !dir.exists() || !dir.isDirectory()) return;//文件不存在
        //获取目录下的所有一级文件或文件夹对象
        File[] files=dir.listFiles();
        if(files!=null && files.length>0) {//当前目录是否存在一级目录或文件
            for (File f : files) {
                if (f.isFile()) {//判断是否为文件夹
                    if (f.getName().contains(fileName)) {//模糊查询contains，精确查询equals
                        System.out.println("文件名：" + f.getName() + " 路径：" + f.getAbsolutePath());
                        Runtime.getRuntime().exec("explorer.exe "+f.getAbsolutePath());
                    }
                } else {
                searchFile(f, fileName);//递归调用
                }
            }
        }
    }
}
```
### 八、字符集(可以加密)
#### (一)、数据的存储方案：字符集

> 1. ASCII字符集，用一个字节存储一个字符，首位为0，共128个字符
> 2. GBK字符集，汉字编码字符集，国标码，一个汉字占两个字节，共21844个字符，兼容ASCII字符据。
> 3. 汉字的首位字节必须为1作为标识位，其他可以存储2^15=32768。
> 4. Unicode字符集，万国码，UTF-32:一个字符4个字节，共42亿个字符，兼容GBK字符集。
> 5. UTF-8字符集，可变长编码方案，共分4个长度区：1-4字节区。英文字符1字节区，汉字3字节区。
> 6. 前缀码来辨认UTF-8字符集的长度，0开头为ASCII码，`110***** 10******`为2字节，`1110**** 10****** 10******`为3字节，`11110*** 10****** 10****** 10******`为4字节。
#### (二)、对字符的编码和解码
| String提供编码                               | 说明                      |
|------------------------------------------|-------------------------|
| byte[ ] getByte( )                       | 使用平台默认的字符集进行编码，返回一个字节数组 |
| byte[ ] getBytes(String charsetName)     | 使用指定的字符集进行编码，返回一个字节数组   |   
| **String解码**                             | **说明**                  |
| String(byte[ ] bytes)                    | 通过使用平台默认的字符集解码，返回一个字符串  |
| String(byte[ ] bytes,String charsetName) | 通过指定的字符集解码，返回一个字符串      |
```java
String name="你好，Rasion";//可以用来加密
byte[] bytes=name.getBytes("GBK");//通过GBK编码,如果没有写为默认编码，默认为UTF-8
System.out.println(Arrays.toString(bytes));//打印字节数组
System.out.println(new String(bytes,"GBK"));//通过GBK解码
```
### 九、IO流
应用场景：写入读出数据。

#### (一)、IO流分类：
按照流防线分为——输入流和输出流。按照流的内容——字节流(所有类型文件)和字符流(只适合纯文本)。

    以下四类为抽象类
        字节输入流：InputStream（读字节数据），实现类：FileInputStream
        字节输出流：OutputStream（写字节数据），实现类：FileOutputStream
        字符输入流：Reader（读字符数据），实现类：FileReader
        字符输出流：Writer（写字符数据），实现类：FileWriter
#### (二)、字节流适合做数据的转移，如文件的复制。
· 资源释放的方式：`try{...代码主体}catch(Exception e){e.printStackTrace();}finally{...释放资源并检测异常}`

· 释放资源更完善的方式：`try(...资源对象){...代码主体}catch(Exception e){e.printStackTrace();}`

· 资源对象：继承了AutoCloseable或Closeable接口的对象，如FileInputStream等
```java
//复制文件：文件->创建字节输入流管道->read->字节数组->write->创建字节输出流管道->另一个文件
public static void copyFile(){//复制文件的抛出异常
    FileOutputStream fos = null;
    FileInputStream fis = null;//定义流为空，确保finally内部能够使用
    try {
        fis = new FileInputStream("resource/mapper.png");//给流一个对象
        fos = new FileOutputStream("resource/hello.png");
        byte[] b = new byte[1024];
        int len;
        while ((len = fis.read(b)) != -1) {
            fos.write(b, 0, len);
        }
        System.out.println("复制完成");
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try{if(fos!=null)fos.close();}//释放资源也要检测异常，确保资源完美关闭完
        catch (Exception e){e.printStackTrace();}
        try{if(fos!=null)fis.close();}
        catch (Exception e){e.printStackTrace();}
    }
}
//抛出异常更加优雅
public static void copyFile() throws Exception {
    try(//这里只能放资源对象，用完后会自动关闭管道，不用finnally
        FileOutputStream fis = new FileInputStream("resource/mapper.png");//管道流定义
        FileInputStream fos = new FileOutputStream("resource/hello.png");)
    {   byte[] b = new byte[1024];
        int len;
        while ((len = fis.read(b)) != -1) {
            fos.write(b, 0, len);
        }
        System.out.println("复制完成");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```
文件字节输入流，输出流实例：
```java
public static void readFile() throws Exception {//文件字节输入流
    //文件字节输入流读取文件中的字节数组到内存中去
    //1、创建文件字节输入流对象
    FileInputStream fis = new FileInputStream("resource/mapper.png");

/*        //2、读取文件中字节并输出
    int a;
    while ((a = fis.read()) != -1) {//每次读取一次字节，读取汉字一定会乱码
        System.out.print((char) a);
    }//输出：HelloWorld!ä½ å¥½
*/  
/*
    //每次读多个字节
    byte[] b = new byte[7];
    //定义一个变量存储每次读取的字节个数
    int len;
    while ((len = fis.read(b)) != -1) {//每次读取多个字节，与文件交互少，单读汉字有可能被截断
        System.out.print(new String(b, 0, len));//读取多少倒多少出来
    }
*/
    //定义一个与文件一样大的字节数组，这样用字节读取汉字就不会乱码，只适合读小文件
    System.out.println(new String(fis.readAllBytes()));//用readAllBytes()方法一次性读取全部字节，避免乱码
    fis.close();//3、释放资源
}

public static void writeFile() throws Exception{//字节输出流，不覆盖要加true
/*        //文件字节输出流将字节数组写入文件中,当文件字节输出流输出后，文件原本的内容会被覆盖
    //1、创建文件字节输出流对象，覆盖掉原文件
    FileOutputStream fos = new FileOutputStream("resource/hello.txt");
    //2、将字节数组写入文件中
    fos.write(new byte[]{'a',100,'A',54,64});
    byte[] bytes = "hello world".getBytes();
    fos.write(bytes,0,bytes.length);
    //3、关闭文件输出流对象
    fos.close();
*/
    //追加数据
    FileOutputStream fileo = new FileOutputStream("resource/hello.txt",true);
    fileo.write("hello world".getBytes());
    fileo.close();//关闭文件输出流对象管道
}
```

#### (三)、字符流适合做数据的处理，如文本的读取。
字符输出流写出数据后，必须刷新流，或者关闭流，写出的数据才能生效。(先写在内存缓冲区，刷新.flush()缓冲区，才能写出数据，降低磁盘压力)
```java
public static void readFile() throws Exception {
    //文件字符输入流读取文件中的字节数组到内存中去
    try(Reader fr = new FileReader("resource/hello.txt");){
        char[] chars = new char[3];//创建一个数组，用来存储读取的字符数组
        int len = fr.read(chars);
        while (len!=-1){
            System.out.print(new String(chars,0,len));
            len = fr.read(chars);
        }
    }catch (Exception e){
        e.printStackTrace();
    }
}

public static void writeFile(){//字符输出流，不覆盖要加true
    try(Writer writer = new FileWriter("resource/hello.txt", true)){
    //异常抛出包含关闭流writer.close()的操作，可以不用写。
        writer.write("\n");
        writer.write("FileWirter",1,3);//写一部分出去
        writer.flush();//刷新缓冲区，写出数据
    }catch (Exception e){e.printStackTrace();}
}
```
#### (四)、缓冲流BufferedStream
##### 1、缓冲字节流
`BufferedInputStream`和`BufferedOutputStream`继承于`InputStream`和`OutputStream`

作用：用于提升文件字节**输出输入流读写数据的性能**。

原理：缓冲字节输入流自带8KB的缓冲池，缓冲字节输出流自带8KB的缓冲池。

| 构造器                                        | 说明                         |
|--------------------------------------------|----------------------------|
| `public BufferedInputStream(InputStream is)` | 把低级的流包装成高级的缓冲字节输入流，提升读数据性能 |
| `public BufferedOutputStream(OutputStream os)` | 把低级的流包装成高级的缓冲字节输出流，提升写数据性能 |
```java
public static void copyFile(String source, String destination) {
    try(// 创建一个文件输入流
        InputStream is=new FileInputStream(source);
        // 创建一个缓冲输入流，把文件输入流放到缓冲输入流中
        InputStream bis=new BufferedInputStream(is);
        // 创建一个文件输出流
        OutputStream os=new FileOutputStream(destination,true);
        // 创建一个缓冲输出流，把文件输出流放到缓冲输出流中
        OutputStream bos=new BufferedOutputStream(os);
    ){
        byte[] bytes=new byte[1024];
        int len;
        while ((len=bis.read(bytes))!=-1){//使用缓冲字节输入流读取数据
            bos.write(bytes,0,len);//使用缓冲字节输出流写出数据
        }
        bos.flush();
        System.out.println("文件复制成功");
    }catch (Exception e){throw new RuntimeException(e);}
}
```
##### 2、缓冲字符流
`BufferedReader`和`BufferedWriter`继承于`Reader`和`Writer`

作用：自带8192的字符缓冲池，可以提升字符输入流的读写性能。

| 构造器                               | 说明                         |
|-----------------------------------|----------------------------|
| `public BufferedReader(Reader r)` | 把低级的流包装成高级的缓冲字符输入流，提升读数据性能 |
| `public BufferedWriter(Writer w)` | 把低级的流包装成高级的缓冲字符输出流，提升写数据性能 |
| **方法**-                           | **说明**                     |
|public String readLine()| 读取一行数据，返回字符串，读到文件末尾返回null |
|public void newLine()| 写一行数据，换行，默认是\r\n，可以自定义换行符 |
```java
public static void bfRW(){
    try(BufferedReader br = new BufferedReader(new FileReader("resource/hello.txt"));//创建一个文件缓冲字符输入流
        BufferedWriter bw = new BufferedWriter(new FileWriter("resource/hello2.txt"))//创建一个文件缓冲字符输出流
    ){
        String line = null;
        while ((line = br.readLine())!=null){//Buffered.readLine()读取一行为独有的换行功能，不用多态写法
            //目前读取文本最优方案
            System.out.println(line);
//          bw.write(line);//复制语句
//          bw.newLine();//换行功能
        }
    }catch (Exception e){throw new RuntimeException(e);}
}
```
#### (五)、性能分析
默认桶大小设置为8KB，过大没有用，过小影响性能。当低级流读写数据时，桶加大可以媲美高级池。
```java
public static void main(String[] args){//见FileIO.performance包的Timetest.java
    //使用低级的字节流一个一个字节的形式复制代码:36.487s，能正常打开,如果桶大小为8KB，则速度为0.015s
    copyFileByte();
    //使用低级的字符流:0.337s，文件大小为24180KB为源文件大小两倍，无法正常打开
    copyFileCharacter();
    //使用高级的缓冲字节流:0.015s，能正常打开
    copyFileBufferedByte();
    //使用高级的缓冲字符流:0.3s，文件大小为24180KB为源文件大小两倍，无法正常打开
    copyFileBufferedCharacter();
    //输出：
//        Byte复制文件耗时：36.487s//此时桶大小为1B
    //若果桶大小为1KB，则Byte速度为0.015s
//        Character复制文件耗时：0.337s
//        BufferedByte复制文件耗时：0.015s//此时桶大小为1KB
    //若果桶大小为1KB，则BufferedByte速度为0.013s
//        BufferedCharacter复制文件耗时：0.3s
}

private static void copyFileBufferedByte(){//以缓冲字节流复制文件为例，字符流可以不写桶大小
    long start = System.currentTimeMillis();
    try(
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(FILE_PATH));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(FILE_PATH2+"bufferedByte.mp4"));
    ){
        byte[] bytes = new byte[1024*8];//桶大小为8KB
        int len;
        while((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    long end = System.currentTimeMillis();
    System.out.println("BufferedByte复制文件耗时："+(end-start)/1000.0+"s");
}
```
#### (六)、其他流
##### 1、字符输入转换流
`InputStreamReader`**字符输入转换流**继承于`Reader`**字符输入流**，

作用：用于解决不同编码时，字符流读取文本内容乱码的问题。

解决思路：先获取问及那原始字节流，再将其按照真实的字符集编码转成字符输入流，这样字符输入流中的字符就不乱码了。

**构造器**：`public InputStreamReader(InputStream is,String charset)`把原始字节输入流按照指定**字符集编码**`charset`转成字符输入流。
```
InputStreamReader isr=new InputStreamReader(new FileInputStream("resource/hello.txt"),"GBK");
BufferedReader br=new BufferedReader(isr);//缓冲字符输入流
```
##### 2、打印流
`PrintStream`字节输出流和`PrintWriter`字符输出流分别继承于`OutputStream`字节输出流和`Writer`字符输出流。

| 构造器                                          | 说明                   |
|----------------------------------------------|----------------------|
| public PrintStream(OutputStream/File/String) | 打印流直接通向字节输出流/文件/文件路径 |
|public PrintStream(String fileName, String charset)| 打印流直接通向文件，指定字符集编码 |
| public PrintStream(OutputStream out, boolean autoFlush) | 打印流直接通向字节输出流，指定是否自动刷新 |
| public PrintStream(OutputStream out, boolean autoFlush, String encoding) | 打印流直接通向字节输出流，指定是否自动刷新，指定字符集编码 |
| **方法**-                                       | **说明**               |
| public void print(Object x) | 输出一个对象，不换行 |
| public void println(Object x) | 输出一个对象，换行 |
```
public static void printstream(){
    try(
        PrintStream ps = new PrintStream(new FileOutputStream("resource/hello.txt",true));
        //不能在高级管道追加，只能在低级管道追加
        PrintWriter pw = new PrintWriter(new FileOutputStream("resource/hello.txt",true));
        ){
        ps.println("hello world");
        ps.println(99);
        ps.println("你好");
        //和FileOutputStream一样，只不过PrintStream为高级管道
    }
    catch(Exception e){
        e.printStackTrace();
    }
}
```
##### 3、特殊数据流(通信)
`DataInputStream`和`DataOutputStream`是专门为**通信**设计的，允许把数据和其类型一并写出去。

| 构造器                                       | 说明                   |
|-------------------------------------------|----------------------|
| public DataoutputStream(OutputStream os)  | 创建新的数据输出流包装成基础的字节输出流 |
| **方法**                                    | **说明**               |
| public final void writeByte(int v)        | 将一个字节值写入此输出流         |
| public final void writeInt(int v)         | 将一个整数值写入此输出流         |
| public final void writeUTF(String str)    | 将一个字符串写入此输出流         |
| public void write(int/byte[ ]/byte[ ]一部分) | 支持写字节数据出去            |
> **打印与读取都要一一对应，不要跳读，不然会出错。**
#### (七)、总结-IO框架
IO流一般是用来写日志。

| IO流体系   | 字节输入流                    | 字节输出流                     | 字符输入流            | 字符输出流            |
|---------|--------------------------|---------------------------|------------------|------------------|
| 抽象类     | `InputStream`            | `OutputStream`            | `Reader`         | `Writer`         |
| **实现类** | `FileInputStream`        | `FileOutputStream`        | `FileReader`     | `FileWriter`     |
| 缓冲流     | `BufferedInputStream`    | `BufferedOutputStream`    | `BufferedReader` | `BufferedWriter` |
| 其他流     |                          | `PrintStream`(打印流)        | `InputStreamReader`(字符输入转换流)| `PrintWriter`(打印流)           |
| 特殊数据    | `DataInputStream`(特殊数据输入流) | `DataOutputStream`(特殊数据输出流) |                  |

IO框架

封装了java提供的对文件、数据进行操作的代码，对外提供了更加简单的方式来对文件进行操作，对数据进行读写等。
>   [!导入io框架]
> 
> 1. 把commons-io-2.16.0.jar文件放入到项目lib文件夹中。
> 2. 在jar文件上邮件，选择Add as Library。

| FileUtils类提供的部分方法                                                                          | 说明   |
|--------------------------------------------------------------------------------------------|------|
| public static void copyFile(File srcFile,File destFile)                                    | 复制文件 |
| public static void copyDirectory(File srcDir,File destDir)                                 | 复制文件夹 |
| public static void forceDelete(File file)                                                  | 删除文件，如果文件不存在，则不抛异常 |
| public static void forceMkdir(File directory)                                              | 创建文件夹，如果文件夹已经存在，则不抛异常 |
| public static void writeStringToFile(File file,String data,String charname,boolean append) | 把字符串写入文件 |
| public static String readFileToString(File file)                                           | 读取文件内容，返回字符串 |
### 十、工具类

#### （1）Hutool

​	https://www.hutool.cn/docs

#### （2）lombok

​	https://lombok.com.cn/features/Data

学习过程中要开启这个

![image-20260422115305145](img/image-20260422115305145.png)

![image-20260422114934217](img/image-20260422114934217.png)

### 十一、学习链接

1. [黑马程序员Java课程](https://www.bilibili.com/video/BV1gb42177hm?p=114&spm_id_from=pageDriver&vd_source=2140b8696bb75ad7bd33e1195bf24372)
2. [A3部分代码仓库](https://gitee.com/RasionLS/java-learn/tree/master/A3)
3. [泛型：继承和通配符](https://blog.csdn.net/yubin1285570923/article/details/108135595)
