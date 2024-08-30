package com.rasion.main;

import java.util.Scanner;

import static com.rasion.main.BasicJava.getRandom;

public class GuessNumber {
    public static void main(String[] args) {
        while (true) {
            guessNumberInterface();
            if (scannerNumber() == 2) {
                System.out.println("游戏结束");
                break;
            } else {
                int a = getRandom(3);//这里给的是三位数
                int b = 0;
                while (true) {
                    System.out.println("请输入一个数字");
                    b=scannerNumber();
                    ifOrnot(b,a);
                    if(a==b){
                        break;
                    }
                }
            }
        }
    }

    public static void guessNumberInterface() {
        System.out.println("======猜数字游戏======");
        System.out.println("      1.开始游戏");
        System.out.println("      2.退出游戏");
    }
    public static int scannerNumber() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    public static void ifOrnot(Integer a,Integer b) {
        if(a>b){
            System.out.println("猜大了\n");
        }else if(a<b){
            System.out.println("猜小了\n");
        }else{
            System.out.println("猜对了\n");
            return;
        }
//        System.out.println("数字是"+b);
    }
}
