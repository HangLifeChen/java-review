package com.rasion.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class test {
    public static void main(String[] args) {
//        start();
//        getstreams();
        getdouble();
    }

    public static void getdouble(){
        List<Double> list = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5,5.5, 6.6, 7.7, 8.8, 9.9, 10.1);
        //默认升序,去重
        list.stream().sorted().distinct().forEach(System.out::println);
        System.out.println("=====");
        //只需要虽大的两个元素
        list.stream().sorted(Comparator.reverseOrder()).distinct().limit(2).forEach(System.out::println);
        //Optional的Stream流终结方法
        Optional<Double> max=list.stream().max((list1,list2)->Double.compare(list1,list2));
        System.out.println(max);
        System.out.println("=====");
        //跳过前两个
        list.stream().skip(2).forEach(System.out::println);
        System.out.println("=====");
        //加工方法
        list.stream().map(s->"加十分后"+(s+10)).forEach(System.out::println);
        System.out.println("=====");
        //合并流
        Stream<Double> stream1 = Stream.of(1.1, 2.2, 3.3);
        //统计合并的流的长度
        System.out.println(Stream.concat(stream1,list.stream()).count());
    }

    public static void getstreams(){
        //获取Stream流
        //1、集合stream流，所有单列结合获取Stream流都要调用stream方法
        Collection<String> list = new ArrayList<>();
        Stream<String> liststream = list.stream();

        //2、Map集合获取Stream流，获取键流，值流，键值对流
        Map<String, String> map=new HashMap<>();
        Stream<String> valueStream = map.values().stream();//值流
        Stream<String> keyStream = map.keySet().stream();//键流
        Stream<Map.Entry<String, String>> entryStream = map.entrySet().stream();//键值对流

        //3、获取数组的流
        String[] strs = {"a","b","c"};
        Stream<String> stream = stream(strs);
        Stream<String> stream1 = Stream.of(strs);
        Stream<String> stream2 = Stream.of("a","b","c");//等价于Arrays.stream(strs)
    }


    public static void start(){
        List<String> list = List.of("张三峰", "张三", "流水","qiqi");

        //传统方案找出姓张的三个字的人
        List<String> newlist=new ArrayList<>();
        for (String s : list) {
            if(s.startsWith("张")&&s.length()==3){
                newlist.add(s);
            }
        }
        System.out.println(newlist);

        //stream流
        list.stream().filter(s->s.startsWith("张"))
                .filter(s->s.length()==3)
                .forEach(System.out::println);

        //stream流收集传回对象
        List<String> newlist2=list.stream().filter(s->s.startsWith("张")).filter(s->s.length()==3).collect(Collectors.toList());
        System.out.println(newlist2);
    }
}
