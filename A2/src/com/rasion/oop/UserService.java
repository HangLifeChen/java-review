package com.rasion.oop;

public class UserService {//（二）、4、JavaBean_User的操作对象
    private JavaBean_User s;//（二）、4、封装实体类的引用
    public UserService(JavaBean_User s){this.s=s;}
    public void printAll(){
        System.out.println(s.getName()+"总成绩是"+(s.getMath()+s.getChinese()));
    }
    public void printAverage(){
        System.out.println(s.getName()+"平均成绩是"+(s.getMath()+s.getChinese())/2);
    }
}
