package com.rasion.extendANDpolymorphism.extend;

public class TestOverride {
    public static void main(String[] args) {//二、4、方法重写
        animal a=new cat();//用父类申明对象，利用多态性和向上转型的概念，以实现更加灵活和可扩展的程序设计，降低代码的耦合性
        a.eat();
        cat b=new cat();
        b.eat();

        //二、5、toString方法
        System.out.println(a.toString());//如果返回一个地址，则没有重写toString方法，但若不是地址，则被重写
        System.out.println(b);//com.rasion.extendANDpolymorphism.extend.cat@4e50df2e
        //即我们直接输出对象，会默认调用Object的toString方法，返回对象的地址信息
        //故我们可以重写toString方法，返回我们想要的信息
    }
}

class animal{
    private String name;
    public void eat(){
        System.out.println("animal eat");
    }

    @Override
    public String toString() {
        return "animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
class cat extends animal{
    @Override//方法重写的校验注解（标志），要求重写的方法与父类方法签名一致，否则编译报错，可读性好
    public void eat(){
        System.out.println("cat eat!!!");
    }
}

//二、6、子类构造器
/*public class TestOverride {
    public static void main(String[] args) {
        animal a=new cat("小猫","可爱");
        System.out.println(a);
    }
}
class animal{
    private String name;
    public animal(){}
    public animal(String name){//父类的有参构造器
        this.name=name;
    }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
class cat extends animal{
    private String cute;
    public cat(){}
    public cat(String name,String cute){//子类有参构造器
        super(name);//调用父类的有参构造器
        this.cute=cute;
    }
    @Override
    public String toString() {
        return "cat{" +
                "name='" + getName() + '\'' +
                ", cute='" + cute + '\'' +
                '}';
    }
}*/