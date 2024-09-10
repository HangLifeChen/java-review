package com.rasion.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CollectionTraversal {
    public static void main(String[] args) {
/*        //1、遍历集合：使用迭代器
        Collection<String> collection = new ArrayList<>();
        collection.add("张三");
        collection.add("李四");
        collection.add("王五");
        collection.add("赵六");
        collection.add("田七");
        //得到集合的迭代器对象
        Iterator<String> it= collection.iterator();
        while (it.hasNext()) {//判断集合中是否还有元素，有返回true，没有返回false
            String next = it.next();
            System.out.print(next+" ");
        }
        System.out.println();

        //2、遍历集合：使用增强for循环
        for (String s : collection) {
            System.out.print(s+" ");
        }
        System.out.println();

        //3、Lambda表达式
        collection.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s+" ");
            }
        });
        collection.forEach(System.out::println);
        collection.forEach(s -> System.out.print(s+" "));
*/ /*
        //4、并发修改异常，每种遍历问题
        ArrayList<String> list=new ArrayList<>();
        list.add("田五");
        list.add("田六");
        list.add("田七");
        list.add("田八");
        list.add("田九");
        //支持索引
        for(int i=0;i<list.size();i++){
            String name=list.get(i);
            if(name.contains("田")){
                list.remove(name);
//                i--;//加上，删除后后撤一步
            }
        }
        System.out.println(list);//输出：[田六, 田八]
        //每次删除数据导致后一位数据前进，i有跨位的问题，导致漏删
        for(int i=list.size()-1;i>=0;i--){//倒序遍历
            String name=list.get(i);
            if(name.contains("田")){
                list.remove(name);
            }
        }
        System.out.println(list);
*/
        //无索引
        //迭代器遍历
        Collection<String> list1= new ArrayList<>();
        list1.add("田五");
        list1.add("田六");
        list1.add("田七");
        list1.add("田八");
        list1.add("田九");
//        Iterator<String> it= list1.iterator();
//        while (it.hasNext()){
//            String name=it.next();
//            if(name.contains("田")){
//                it.remove();//这里是直接用迭代器自己方法删除指向的元素
//                //list1.remove(name);//要是这样删除就会报异常，会出现并发修改异常
//            }
//        }
        System.out.println(list1);
        //增强for循环，Lambda表达式
//        for(String s:list1){
////            if(s.contains("田")){
////                list1.remove(s);//并发修改异常
////            }
////        }
////        System.out.println(list1);
        //Lambda表达式
        list1.forEach(s->{
            if (s.contains("田"))
                list1.remove(s);//并发修改异常
        });
        System.out.println(list1);
    }
}
