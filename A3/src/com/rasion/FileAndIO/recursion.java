package com.rasion.FileAndIO;

public class recursion {
    public static void main(String[] args) {
//        startRecursion();//递归调用测试
//        System.out.println("1到10的阶乘："+factorial(10));//阶乘测试
//        System.out.println("1到10的和："+function(10));//函数求和测试
        //猴子吃桃问题，猴子每第n+1天会吃掉第n天的一半多一个桃，求第一天吃掉的桃子数
        System.out.println("吃了10天，第一天吃的桃子数："+monkey(1));
    }
    private static int i=1;
    public static void startRecursion(){
        if(i<10){
            System.out.println("递归调用："+i);
            i++;
            startRecursion();
        }
    }
    public static int factorial(int n){
        if(n==1){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }
    public static int function(int n){
        if(n==1){
            return 1;
        }else{
            return n+function(n-1);
        }
    }
    public static int monkey(int day){
        if(day==10){
            return 1;//终结点f(10)=1
        }
        return 2*monkey(day+1)+2;
        //公式：
        //f(2)=f(1)/2-1
        //2f(n+1)=f(n)-2
        //f(n)=2f(n+1)+2
    }
}
