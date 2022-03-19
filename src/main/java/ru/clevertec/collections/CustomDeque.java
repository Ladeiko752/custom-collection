package ru.clevertec.collections;

public interface CustomDeque<T> {
    void addFirst(T t);

    void addLast(T t);

    T removeFirst();

    T removeLast();


}
