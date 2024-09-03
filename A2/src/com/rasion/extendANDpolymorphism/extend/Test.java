package com.rasion.extendANDpolymorphism.extend;

public class Test {
    public static void main(String[] args){
        //二、1、继承关键字
//        SonA sonA = new SonA();
//        sonA.setName("A");
//        sonA.setAge(18);
//        sonA.setJob("student");
//        sonA.setSkill("java");
//        System.out.println(sonA.getName()+" "+sonA.getAge()+" "+sonA.getJob()+" "+sonA.getSkill());

    //二、2、访问权限
        Father father = new Father();
        //father.privateMethod();//私有，只能在父类本类中访问
        father.defaultMethod();
        father.protectedMethod();
        father.publicMethod();

        //二、7、子类构造器this(...)调用兄弟构造器
        User user = new User("rasion", 18);
        System.out.println(user);
    }
}
