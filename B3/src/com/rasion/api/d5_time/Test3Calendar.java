package com.rasion.api.d5_time;
/*
    Calendar类
        代表的是系统此刻时间对应的日历，通过它可以单独获取、修改时间中的年、月、日、时、分、秒等。
    Calendar日历类的常见方法
        public static Calendar getInstance()	获取当前日历对象
        public int get(int field)	获取日历中的某个信息。
        public final Date getTime()	获取日期对象。
        public long getTimeInMillis()	获取时间毫秒值
        public void set(int field,int value)	修改日历的某个信息。
        public void add(int field,int amount)	为某个信息增加/减少指定的值
    注意：calendar是可变对象，一旦修改后其对象本身表示的时间将产生变化。
 */

import java.util.Calendar;
import java.util.Date;

public class Test3Calendar {

    public static void main(String[] args) {
//        public static Calendar getInstance()	获取当前日历对象
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        // public int get(int field)	获取日历中的某个信息。
        int year = calendar.get(Calendar.YEAR);
//        int year = calendar.get(2);
        int month = calendar.get(Calendar.MONTH);
        System.out.println(year);
        System.out.println(month); // 月份从0开始,获取到月份 +1操作

        //        public final Date getTime()	获取日期对象。
        Date date = calendar.getTime();
        System.out.println(date);

        // 如果现在我有一个date 对象-----> 日历对象中
        //calendar.setTime(date);
        //        public long getTimeInMillis()	获取时间毫秒值
        long timeInMillis = calendar.getTimeInMillis();
        System.out.println(timeInMillis);
        //        public void set(int field,int value)	修改日历的某个信息。
//        calendar.set(Calendar.YEAR,2025);

        //        public void add(int field,int amount)	为某个信息增加/减少指定的值
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);


    }

}
