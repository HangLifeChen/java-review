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

2、可以作为方法内的一种特殊的返回值，以便通知上层调用者，方法的执行出现问题。
### 三、泛型

### 四、集合框架

### 五、Stream流

### 六、方法传递

### 七、字符集

### 八、IO流

### 九、学习链接
1、[黑马程序员Java课程](https://www.bilibili.com/video/BV1gb42177hm?p=114&spm_id_from=pageDriver&vd_source=2140b8696bb75ad7bd33e1195bf24372)

2、[A3部分代码仓库](https://gitee.com/RasionLS/java-learn/tree/master/A3)