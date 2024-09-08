package com.rasion.exception;

import java.util.Scanner;

public class ExceptionDeal {//最外层获取异常后，尝试重新修复。
    public static void main(String[] args) throws Exception {
        while(true){
            try {
                int age=checkAge();
                System.out.println("年龄："+age);
                break;
            }catch (Exception e){
//                e.printStackTrace();//用来报错
                System.out.println("请重新输入：");
            }
        }
    }
    public static int checkAge( ) throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println("请你输入年龄：");
        int age=sc.nextInt();
        if(age<18||age>200){
            throw new Exception("年龄非法，年龄不能小于18，不能大于200");
        }else{
            return age;
        }
    }
}
