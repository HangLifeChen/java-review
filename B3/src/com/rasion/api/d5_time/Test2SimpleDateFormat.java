package com.rasion.api.d5_time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    1 SimpleDateFormat类
        代表简单日期格式化，可以用来把日期对象、时间毫秒值格式化成我们想要的形式。
    2 常见构造器
        public SimpleDateFormat(String pattern)	创建简单日期格式化对象，并封装时间的格式
    3 格式化时间的方法
        public final String format(Date date)	将日期格式化成日期/时间字符串
        public final String format(Object time)	将时间毫秒值式化成日期/时间字符串
    4 字符串解析方法
        public Date parse(String source)	把字符串时间解析成日期对象
 */
public class Test2SimpleDateFormat {

    public static void main(String[] args) throws ParseException {
//        解析: 字符串------>日期对象
        String str="2026年04月15日 17:30:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月嘻嘻dd日 HH:mm:ss");
        Date date = simpleDateFormat.parse(str);
        System.out.println(date);
        long time = date.getTime();
        time=time+1000*60*60*24*2;
        date.setTime(time);
        System.out.println(date);
        //test();

    }

    private static void test() {
        //        格式化:  毫秒值 date对象 转成 字符串
//        ctrl+alt+m 快速封装方法
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("公元yyyy年MM月dd日 HH:mm:ss 嘻嘻");
        String res = sdf.format(date);
        String res2 = sdf.format(date.getTime());
        System.out.println(res);
        System.out.println(res2);
    }
}






