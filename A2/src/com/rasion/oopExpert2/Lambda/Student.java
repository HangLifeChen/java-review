package com.rasion.oopExpert2.Lambda;

public class Student {
    private String name;
    private int age;
    private String school;
    private char sex;

    public static int compareAge(Student s1,Student s2){//Student唯一静态方法
        return s1.getAge()-s2.getAge();
    }
    public int compareAgeInstant(Student s1,Student s2){
        return Integer.compare(s1.getAge(),s2.getAge());
    }

    public Student() {
    }

    public Student(String name, int age, String school, char sex) {
        this.name = name;
        this.age = age;
        this.school = school;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school='" + school + '\'' +
                ", sex=" + sex +
                '}';
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
