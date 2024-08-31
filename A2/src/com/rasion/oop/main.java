package com.rasion.oop;

public class main {
    public static void main(String[] args) {
        User s1=insert();
        print(s1);
    }
    //定义一个返回值为User对象的存储对象数据的方法
    public static User insert(){
//        User user = new User();
//        user.setName("Rasion");
//        user.setAge(20);
//        user.setGender(true);
//        user.setEmail("rasion@gmail.com");
//        user.setPassword("123456");
//        user.setMath(100);
//        user.setChinese(100);
        User user = new User("Rasion",20,true,"rasion@gmail.com","123456",100,100);
        return user;
    }
    public static void print(User user){//定义一个打印对象的方法
        System.out.println("Name: "+user.getName());
        System.out.println("Age: "+user.getAge());
        System.out.println("Gender: "+user.isGender());
        System.out.println("Email: "+user.getEmail());
        System.out.println("Password: "+user.getPassword());
        System.out.println("Math: "+user.getMath());
        System.out.println("Chinese: "+user.getChinese());
        user.printAllScore();
        user.printAverageScore();
    }
}
