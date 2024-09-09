package com.rasion.generic.InterfaceGeneric;

public interface Data<E> {//既可以接User又可以接Customer
    void add(E e);
    void delete(E e);
    void update(E e);
    E get(int index);
}
