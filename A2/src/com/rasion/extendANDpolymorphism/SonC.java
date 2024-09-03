package com.rasion.extendANDpolymorphism;

import com.rasion.extendANDpolymorphism.extend.Father;

public class SonC extends Father {
    //二、2、权限修饰符
    public void list(){
//        privateMethod();
//        defaultMethod();//不能访问父类的private方法，和缺省方法
        protectedMethod();
        publicMethod();
    }
}
