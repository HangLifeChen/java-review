package com.rasion.api.d5_time;

import java.util.Date;

/*
    Date : 代表的是日期和时间。

    构造器
        public Date()	创建一个Date对象，代表的是系统当前此刻日期时间。
        public Date(long time)	把时间毫秒值转换成Date日期对象。
    常见方法
        public long getTime()	返回从1970年1月1日    00:00:00走到此刻的总的毫秒数
        public void setTime(long time)	设置日期对象的时间为当前时间毫秒值对应的时间
 */
public class Test1Date {
    public static void main(String[] args) {
//         public Date()	创建一个Date对象，代表的是系统当前此刻日期时间。
        Date date = new Date();
        System.out.println(date);

//        public long getTime()	返回从1970年1月1日    00:00:00走到此刻的总的毫秒数
        long time = date.getTime();
        System.out.println(time);

//        public void setTime(long time)	设置日期对象的时间为当前时间毫秒值对应的时间
        date.setTime(time+2000);
        System.out.println(date);

//         public Date(long time)	把时间毫秒值转换成Date日期对象。
        Date date1 = new Date(0);
        System.out.println(date1);


    }
}
