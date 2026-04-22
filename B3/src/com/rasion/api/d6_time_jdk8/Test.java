package com.rasion.api.d6_time_jdk8;

import java.util.Calendar;
import java.util.Date;

/**
 *  目标：搞清楚为什么要用JDK 8开始新增的时间类。
 */
public class Test {
    public static void main(String[] args) {
//        JDK8 之前的 日期时间API(Date SimpleDateformat Calendar)
//        1.设计不合理使用不方便
        Date date = new Date();
        int year = date.getYear();
        System.out.println(year); //1900 + 126 = 2026
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(2);
        System.out.println(i);
//        2. 对象都是可变对象 修改后丢失最开始的时间
//        3. 线程不安全  SimpleDateformat
//        4. 时间精度到毫秒---->精确到纳秒
//          1秒=1000毫秒
//          1毫秒=1000微妙
//          1微妙=1000纳秒




    }
}
