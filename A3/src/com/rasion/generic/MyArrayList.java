package com.rasion.generic;

public class MyArrayList<E> {//约束类型为E
    private Object[] elementData;
    public boolean add(E e) {//添加与类型E相同类型的元素
        return true;
    }
}
