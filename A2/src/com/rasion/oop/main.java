package com.rasion.oop;

public class main {
    public static void main(String[] args) {
/*        User s1=insert();
        System.out.println(s1);//（二）、1、构造器

        User s2=new User();
        s2.print();//（二）、2、this关键字，可以拿到对象的信息
        System.out.println(s2);

        JavaBean_User jb= new JavaBean_User("Rasion",20,true,"rasion@gmail.com","123456",90,100);
        System.out.println(jb);//（二）、4、JavaBean实体类的调用

        UserService us=new UserService(jb);//（二）、4、我们一般不直接调用实体类在总文件中进行操作，而是调用实体类的操作对象
        us.printAll();
        us.printAverage();

        StaticAbout sa2= new StaticAbout();//（二）、5、static修饰成员变量
        StaticAbout sa1= new StaticAbout();
        StaticAbout.name="Rasion";
        sa2.age=20;
        sa1.age=20;
        System.out.println(StaticAbout.name+sa2.age+sa1.age+sa1.name+sa2.name);
        //System.out.println(StaticAbout.age);//报错，
*/
        //（二）、7、静态方法与工具类
        System.out.println(StaticAbout.getCode(6));
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
