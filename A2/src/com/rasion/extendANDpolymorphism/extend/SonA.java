package com.rasion.extendANDpolymorphism.extend;

public class  SonA extends Father{
    private String skill;//技术

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void test(){//二、2、权限修饰符
        //privateMethod();//私有方法只能父类本类调用
        defaultMethod();
        protectedMethod();
        publicMethod();
    }
}
