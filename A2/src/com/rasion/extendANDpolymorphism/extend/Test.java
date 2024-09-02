package com.rasion.extendANDpolymorphism.extend;

public class Test {
    public static void main(String[] args){
        SonA sonA = new SonA();
        sonA.setName("A");
        sonA.setAge(18);
        sonA.setJob("student");
        sonA.setSkill("java");
        System.out.println(sonA.getName()+" "+sonA.getAge()+" "+sonA.getJob()+" "+sonA.getSkill());
    }
}
