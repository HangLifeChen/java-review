package com.rasion.extendANDpolymorphism.extend;

public class Father {
    private String name;//二、1、继承关键字
    private int age;
    private String sex;
    private String job;

    private void privateMethod(){//二、2、权限修饰符之私有方法
        System.out.println("private method");
    }
    void defaultMethod(){//二、2、权限修饰符之缺省方法
        System.out.println("default method");
    }
    protected void protectedMethod(){//二、2、权限修饰符之受保护方法
        System.out.println("protected method");
    }
    public void publicMethod(){//二、2、权限修饰符之公共方法
        System.out.println("public method");
    }
    public static void main(String[] args) {
        Father father = new Father();
        father.privateMethod();
        father.defaultMethod();
        father.protectedMethod();
        father.publicMethod();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
