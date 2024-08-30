package com.rasion.main;

import java.util.Scanner;

public class VerificationCode {
    public static void main(String[] args) {
        //生成指定位数的验证码，验证码由数字、大小写字母组成
        System.out.println("请输入验证码位数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//验证码位数
        System.out.println(getCode(n));
    }
    public static String getCode(int n) {
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
