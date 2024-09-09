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

3、泛型本质：把具体的数据类型作为参数传给类型变量
#### (二)、泛型类
`修饰符 class 类名<类型变量1、类型变量2...>{   }`

类型变量用大写字母，如：T、E、K、V等。
### 四、集合框架

### 五、Stream流

### 六、方法传递

### 七、字符集

### 八、IO流

### 九、学习链接
1、[黑马程序员Java课程](https://www.bilibili.com/video/BV1gb42177hm?p=114&spm_id_from=pageDriver&vd_source=2140b8696bb75ad7bd33e1195bf24372)

2、[A3部分代码仓库](https://gitee.com/RasionLS/java-learn/tree/master/A3)