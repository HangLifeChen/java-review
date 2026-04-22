package com.rasion.api.d1_generics;

import java.util.ArrayList;

public class Test4 {

    /*
    * 目标: 掌握泛型方法
    *  格式:
    *     修饰符  <类型变量,....> 返回值 方法名(形参列表){}
    *     ? 通配符 代表一切类型
    *
    *   泛型的  上限  T extends 类型
    *   泛型的  下限  T super 类型
    *
    *需求: 设计一个方法 体现 车队比赛的功能
    * */

    public static void main(String[] args) {
//         定义车队
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<BYD> byds = new ArrayList<>();
        ArrayList<LiXiang> liXiangs = new ArrayList<>();
        ArrayList<Dog> dogs = new ArrayList<>();
        ArrayList<Qin> qins = new ArrayList<>();
        testRun(cars);
        testRun(byds);
        testRun(liXiangs);
        testRun(dogs);
        testRun2(cars);
        testRun2(byds);
        testRun2(liXiangs);
        testRun2(dogs);

        testRun3(cars);
        testRun3(byds);
        testRun3(liXiangs);
//        testRun3(dogs);

//        testRun4(cars);
//        testRun4(byds);
//        testRun4(qins);


//        testRun5(cars);
//        testRun5(byds);
//        testRun5(qins);
    }
    // 体现车队比赛
    public static <E> void testRun(ArrayList<E> catList){


    }
//    ? 通配符 代表一切类型
    public static void testRun2(ArrayList<?> catList){


    }
// 传递的泛型 必须是 Car 或者是Car子类  限制泛型的 上限
    public static void testRun3(ArrayList<? extends Car> catList){


    }
//
public static void testRun4(ArrayList<? extends BYD> catList){


}

//要求只能是  王朝车队的父类参加比赛   下限
public static void testRun5(ArrayList<? super BYDWangChao> catList){


}

}
//汽车类
class  Car{

}


//BYD
class BYD extends Car{

}
class BYDWangChao extends BYD{


}
class Qin extends BYDWangChao{

}
class LiXiang extends Car{


}
