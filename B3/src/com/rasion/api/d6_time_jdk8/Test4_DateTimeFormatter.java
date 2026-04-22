package com.rasion.api.d6_time_jdk8;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/*
    目标：掌握JDK 8新增的DateTimeFormatter格式化器的用法。
    DateTimeFormatter: 日期格式化器类
        public static DateTimeFormatter ofPattern(时间格式) 	获取格式化器对象
        public String format(时间对象) 	格式化时间
    LocalDateTime提供的格式化、解析时间的方法
        public String format(DateTimeFormatter formatter)	格式化时间
        public static LocalDateTime parse(CharSequence text, DateTimeFormatter formatter) 	解析时间
 */
public class Test4_DateTimeFormatter {
    public static void main(String[] args) {
//        格式化:  日期对象---->字符串
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd HH:mm:ss");
        String res = dateTimeFormatter.format(now);
        System.out.println(res);

        String res2 = now.format(dateTimeFormatter);
        System.out.println(res2);

        String str="2035年10月15 12:30:00";
        LocalDateTime dateTime = LocalDateTime.parse(str, dateTimeFormatter);
        System.out.println(dateTime);

        LocalDateTime localDateTime = now.plusDays(20);
        System.out.println(localDateTime);


        ZoneId.of("Asia/Shanghai");
    }
}






