package com.rasion.oopExpert2.InnerClass;

public class AnonymityInnerClass {
    public static void main(String[] args) {
        //匿名内部类有名字：外部类名$编号.class
        //匿名内部类本质是一个子类，同时立即创建一个子类对象
        Animal cat=new Animal(){
            @Override
            public void run() {
                System.out.println("cat run");
            }
        };//匿名内部类，同cat类，即是一个子类又是一个子类对象
        print(cat);
    }
    public static void print(Animal animal){
        System.out.println("start==");
        animal.run();//对象回调
    }
}

interface Animal{
    public abstract void run();
}
//class cat extends Animal{
//    @Override
//    public void run() {
//        System.out.println("cat run");
//    }
//}