package com.rasion.generic;

public class GenericFunction {
    public static void main(String[] args) {
        //需求：打印任意数组的内容
        Integer[] arr = {1,2,3,4,5};
        print(arr);
        Integer arr2=get(arr, 2);
        System.out.println(arr2);
    }
    public static <T> void print(T[] arr){//打印任意数组类型T
        for (T o : arr) {
            System.out.print(o+" ");
        }
    }
    public static <T> T get(T[] arr,int index){//泛型方法，返回值为T类型
        return arr[index];//返回数组指定索引位置的元素
    }
}
