package ru.clevertec.collections;

public interface CustomIterator<T> {
    boolean hasNext();
    T next();
    boolean remove();
    void addBefore(T t);
    void addAfter(T t);
}
