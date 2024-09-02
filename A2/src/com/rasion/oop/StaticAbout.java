package com.rasion.oop;

public class StaticAbout {
    static String name;//（二）、5、static修饰成员变量
    int age;

    //（二）、7、工具类没有创建对象的需求，建议讲工具类的构造器私有。
    private StaticAbout() {
    }
    public static String getCode(int n) {//（二）、7、静态方法与工具类
        String code = "";
        for (int i = 0; i < n; i++) {
            int type = (int) (Math.random() * 3);//0-9 1-26 2-26
            switch (type) {
                case 0:
                    code += (int) (Math.random() * 10);
                    break;
                case 1:
                    code += (char) (Math.random() * 26 + 'a');//得到小写字母的区间
                    break;
                case 2:
                    code += (char) (Math.random() * 26 + 'A');
            }
        }
        return code;
    }
}
