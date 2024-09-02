package com.rasion.oop;

public class JavaBean_User { //（二）、4、实体类
    //1、成员变量私有化
    private String name;
    private Integer age;
    private boolean gender;
    private String email;
    private String password;
    private Integer math;
    private Integer chinese;
    //2、提供公开的访问方式
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getChinese() {
        return chinese;
    }

    public void setChinese(Integer chinese) {
        this.chinese = chinese;
    }

    //3、提供有参构造器
    public JavaBean_User(String name, Integer age, boolean gender, String email, String password, Integer math, Integer chinese) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.math = math;
        this.chinese = chinese;
    }
    //4、提供无参构造器
    public JavaBean_User() {
    }

    //5、提供toString方法
    @Override
    public String toString() {
        return "JavaBean_User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", math=" + math +
                ", chinese=" + chinese +
                '}';
    }
}
