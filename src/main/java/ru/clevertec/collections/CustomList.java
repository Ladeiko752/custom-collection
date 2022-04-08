package ru.clevertec.collections;

public interface CustomList <T>{
    int size();
    boolean add(T t);
    boolean add(int index, T t);
    boolean remove();
    boolean removeByObject(Object o);
    boolean removeByIndex(int index);
    boolean isEmpty();
    void clear();
    T getByIndex(int index);
    void trim();
    int find(Object o);
    Object[] toArray();
    <S> S[] toArray(S[] a);
    T set(int index, T t);
    void setMaxSize(int maxSize);
}
