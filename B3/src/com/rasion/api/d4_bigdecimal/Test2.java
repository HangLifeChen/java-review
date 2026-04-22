package com.rasion.api.d4_bigdecimal;

import java.math.BigDecimal;

public class Test2 {
    public static void main(String[] args) {
        // 目标：掌握BigDecimal进行精确运算的方案。
        double a = 0.1;
        double b = 0.3;
        // 1、把浮点型数据封装成BigDecimal对象，再来参与运算。
           // a、public BigDecimal(double val) 得到的BigDecimal对象是无法精确计算浮点型数据的。 ----禁用
           // b、public BigDecimal(String val)  得到的BigDecimal对象是可以精确计算浮点型数据的。 可以使用。
           // c、public static BigDecimal valueOf(double val): 通过这个静态方法得到的BigDecimal对象是可以精确运算的。是最好的方案。
        /*BigDecimal b1 = new BigDecimal(a);
        BigDecimal b2 = new BigDecimal(b);
        BigDecimal res = b1.add(b2);
        System.out.println(res);*/
        /*BigDecimal b1 = new BigDecimal("0.1");
        BigDecimal b2 = new BigDecimal("0.2");
        BigDecimal res = b1.add(b2);
        System.out.println(res);*/
        BigDecimal b1 = BigDecimal.valueOf(a);
        BigDecimal b2 = BigDecimal.valueOf(b);
        BigDecimal res = b1.add(b2);
        System.out.println(res);
        // 2、public BigDecimal add(BigDecimal augend): 加法
        // 3、public BigDecimal subtract(BigDecimal augend): 减法
        BigDecimal res2 = b2.subtract(b1);
        System.out.println(res2);
        // 4、public BigDecimal multiply(BigDecimal augend): 乘法
        BigDecimal res3 = b1.multiply(b2);
        System.out.println(res3);
        // 5、public BigDecimal divide(BigDecimal b): 除法
        BigDecimal res4 = b1.divide(b2,2,BigDecimal.ROUND_HALF_UP);
        System.out.println(res4);
        // 6、public BigDecimal divide(另一个BigDecimal对象，精确几位，舍入模式) : 除法，可以设置精确几位。
        // 舍入模式可以使用枚举 : RoundingMode
        // 7、public double doubleValue() : 把BigDecimal对象又转换成double类型的数据。
        double v = res4.doubleValue();
        System.out.println(v);
    }
}
