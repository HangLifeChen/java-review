package com.rasion.oop;

public class User {
    private String name;//对象变量就是成员变量
    private Integer age;
    private boolean gender;
    private String email;
    private String password;
    private Integer math;
    private Integer chinese;

    public void printAllScore(){//输出总成绩
        System.out.println("总成绩为："+(math+chinese));
    }
    public void printAverageScore(){//输出平均成绩
        System.out.println("平均成绩为："+(math+chinese)/2);
    }
    public void print(){//（二）、2、this关键字
        //那个对象调用这个方法，this就拿到那个对象
        System.out.println(this);
    }
    public void print(String name){//（二）、2、this关键字解决变量冲突问题
        System.out.println(name+this.name);//this.name拿到的是对象的name,而不是局部变量name
    }
    public User() {System.out.println("==无参构造器执行了==");//（二）、1、构造器
    }

    public User(String name, Integer age, boolean gender, String email, String password, Integer math, Integer chinese) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.math = math;
        this.chinese = chinese;
        System.out.println("==有参构造器执行了==");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", math=" + math +
                ", chinese=" + chinese +
                '}';
    }

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
}
