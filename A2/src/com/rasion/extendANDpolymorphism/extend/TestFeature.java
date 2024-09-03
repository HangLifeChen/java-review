package com.rasion.extendANDpolymorphism.extend;

public class TestFeature {//测试类
//二、3、继承的特点
    public static void main(String[] args) {
        zilei zi=new zilei();
        zi.test();
    }
}
class fulei{
    String name="FUlei";
}
class zilei extends fulei{
    String name="ZiLei";
    public void test(){
        String name="ZiLeiTEST";
        System.out.println(name);//test的name
        System.out.println(this.name);//zilei的name
        System.out.println(super.name);//fulei的name
    }
}