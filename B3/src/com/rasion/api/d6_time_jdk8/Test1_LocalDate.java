package com.rasion.api.d6_time_jdk8;
import java.time.LocalDate;

public class Test1_LocalDate {
    public static void main(String[] args) {
        // 0、获取本地日期对象(不可变对象)
        LocalDate ld = LocalDate.now(); // 年 月 日
        System.out.println(ld);
        // 5、获取指定日期的LocalDate对象： public static LocalDate of(int year, int month, int dayOfMonth)
        LocalDate ld1 = LocalDate.of(2027, 12, 12);
        LocalDate ld5 = LocalDate.of(2027, 12, 12);
        System.out.println(ld1.equals(ld5));
        System.out.println(ld1);
        // 1、获取日期对象中的信息
        int year = ld.getYear();
        int dayOfMonth = ld.getDayOfMonth();
        int monthValue = ld.getMonthValue();
        System.out.println(year);
        System.out.println(dayOfMonth);
        System.out.println(monthValue);
        // 2、直接修改某个信息: withYear、withMonth、withDayOfMonth、withDayOfYear
        LocalDate ld2 = ld.withYear(2028);
        System.out.println(ld);
        System.out.println(ld2);

        // 注意 : JDK8开始的日期类,是不可改变的
        // 3、把某个信息加多少: plusYears、plusMonths、plusDays、plusWeeks
        LocalDate ld3 = ld.plusMonths(2);
        System.out.println(ld3);
        // 4、把某个信息减多少：minusYears、minusMonths、minusDays、minusWeeks
        LocalDate ld4 = ld.minusDays(5);
        System.out.println(ld4);

        // 6、判断2个日期对象，是否相等，在前还是在后： equals isBefore isAfter
        System.out.println(ld.isBefore(ld1));
        System.out.println(ld.isAfter(ld1));
    }
}
