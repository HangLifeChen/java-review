package com.rasion.exception;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LearnException {
    public static void main(String[] args) {
//        Runtimeshow();
//        CompileShow();//方法一、在main添加throws ParseException标签抛出异常
        try {//方法二、捕获异常
            CompileShow();
        } catch (java.lang.Exception e){
            e.printStackTrace();//输出异常信息
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
    public static void CompileShow() throws java.lang.Exception {//编译时异常
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
