package com.rasion.collection.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class set {
    public static void main(String[] args) {
        //HashSet：无序、不重复、无索引
        Set<String> set = new HashSet<>();//经典代码
        set.add("张三");
        set.add("李四");
        set.add("王五");
        set.add("赵六");
        set.add("赵六");
        System.out.println("HashSet: "+set);

        //LinkedHashSet：有序、不重复、无索引
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("张三");
        set1.add("李四");
        set1.add("王五");
        set1.add("赵六");
        set1.add("赵六");
        System.out.println("LinkedHashSet: "+set1);

        //TreeSet：排序（默认大小升序排序）、不重复、无索引
        Set<Integer> set2 = new TreeSet<>();
        set2.add(100);
        set2.add(20);
        set2.add(300);
        set2.add(300);
        set2.add(40);
        System.out.println("TreeSet: "+set2);
    }
}
