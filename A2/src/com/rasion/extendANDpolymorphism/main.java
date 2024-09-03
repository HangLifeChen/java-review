package com.rasion.extendANDpolymorphism;

import com.rasion.extendANDpolymorphism.extend.Father;

public class main {
    public static void main(String[] args) {
        //二、2、访问权限
        Father father = new Father();
        //father.privateMethod();
        //father.defaultMethod();
        //father.protectedMethod();
        father.publicMethod();//其他包中，只能访问public方法
    }
}
