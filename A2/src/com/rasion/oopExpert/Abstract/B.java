package com.rasion.oopExpert.Abstract;

public class B extends A{//3、一个类继承抽象类，必须重写完抽象类的全部抽象方法，否则这个类也必须定义为抽象类。
//    @Override//3、重写抽象方法
//    public void show()
//    {
//        System.out.println("this is "+super.getName());
//        System.out.println("B重写show方法！");
//    }

    @Override
    public void show(){
        System.out.println("B重写show方法！");
    }
}
