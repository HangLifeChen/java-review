package com.rasion.oopExpert2.StringDemo;

public class StringDemo {
    public static void main(String[] args) {
        String s1="rasion";//快速创建字符串
        System.out.println(s1);//输出rasion而不是地址

        String s2=new String();//通过构造器创建字符串
        String s3=new String("rasion");

        char[] chs={'r','a','s','i','o','n'};
        String s4=new String(chs);//把字符数组转换成字符串

        System.out.println(s1=="rasion");//true
        System.out.println(s3==s4);//false

        //随机验证码在之前的测试中已经做过了，此处不再赘述。
    }
}
