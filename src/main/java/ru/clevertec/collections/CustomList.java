package ru.clevertec.collections;

public interface CustomList <T>{
    int size();
    boolean add(T t);
    boolean add(int index, T t);
    boolean remove();
    boolean remove(Object o);
    boolean remove(int index);
    boolean isEmpty();
    void clear();
    T getByIndex(int index);
}
