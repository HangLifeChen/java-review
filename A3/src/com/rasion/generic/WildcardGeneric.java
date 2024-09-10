package com.rasion.generic;

import java.util.ArrayList;

public class WildcardGeneric {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Bmw());
        cars.add(new BYD());
//        WhitchCar(cars);
        run(cars);

        ArrayList<Bmw> bmws = new ArrayList<>();
//        run(bmws);//报错，因为集合里面只能是Car类
        bmws.add(new Bmw());
        SystemOut(bmws);

        ArrayList<Integer> list=new ArrayList<>();//泛型支持的类型
        list.add(1234);
        System.out.println(list.get(0));
        System.out.println(Integer.toString(list.get(0))+1);

        Integer i= list.get(0);
        String i2=i.toString();
        System.out.println(i2+1);
    }
    public static <T> void WhitchCar(ArrayList<T> cars){
            System.out.println(cars);
    }
    public static void run(ArrayList<Car> cars){//这里是虽然是父类，但是只能够访问Car类，不能访问子类，不像多态
        for (Car car : cars) {
            car.run();
        }
    }
    public static void SystemOut(ArrayList<? extends Car> cars){//这里使用通配符，可以访问Car类，也可以访问Car子类
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
class Car{
    public void run(){
        System.out.println("汽车在跑");
    }
    @Override
    public String toString() {
        return "Car";
    }
}
class Bmw extends Car{
    public void run(){
        System.out.println("宝马在跑");
    }
    @Override
    public String toString() {
        return "BMW";
    }
}
class BYD extends Car{
    public void run(){
        System.out.println("比亚迪在跑");
    }
    @Override
    public String toString() {
        return "BYD";
    }
}