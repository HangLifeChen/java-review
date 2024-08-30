package com.rasion.main;

public class FindPrime {
    public static void main(String[] args) {
        //找到所有素数
        int temp=0;
        for(int i=1;i<=1000;i++){
            if(isPrime(i)){
                temp++;
                System.out.print(i+"\t ");
                if(temp%10==0) System.out.println();
            }
        }
    }
    public static boolean isPrime(int n) {//判断是否为素数
        if (n<=1){return false;}
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){return false;}
        }
        return true;
    }
}
