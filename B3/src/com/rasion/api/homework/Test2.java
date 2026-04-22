package com.rasion.api.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test2 {


    public static void main(String[] args) throws ParseException {
        fn();
    }
//    方法体现功能
//    是否需要参数  不需要
//    需要返回结果  不需要
//    方法如何实现 :   Scanner  字符串---->日期对象--->毫秒值-->天

    public static void fn() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请您输入出生日期(eg.2000年10月01日)");
        String birthdayStr = sc.next();
        // birthdayStr ---->对象  解析
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = sdf.parse(birthdayStr);
        long time = date.getTime();
        Date now = new Date();
        long nowTime = now.getTime();
        time=nowTime-time;
        long day=time /(1000 * 60 *60 *24);
        System.out.println(day);
    }

}
