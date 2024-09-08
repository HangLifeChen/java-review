package com.rasion.exception;

public class ExceptionAffect {
    public static void main(String[] args) {
        try{
            System.out.println(div(10,0));
            System.out.println("方法执行成功");
        }catch(Exception e){//抛出异常能让程序知道下一步要执行什么
            e.printStackTrace();
            System.out.println("程序出现异常，程序退出");
        }//执行完异常程序也不会死亡
    }
    public static int div(int a,int b) throws Exception{
        if(b==0){
            System.out.println("除数不能为0");
            throw new Exception("除数不能为0,参数有问题");//可以替代return -1;而且更具安全性
        }
        int result=a/b;
        return result;
    }
}
