package ru.clevertec;


import ru.clevertec.collections.CustomLinkedList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        System.out.println("Is Empty: " + linkedList.isEmpty());
        System.out.println("--------Creating LinkedList--------");
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        System.out.println("LinkedList: " + linkedList);
        System.out.println("Size: " + linkedList.size());
        System.out.println("--------Operations with LinkedList--------");
        System.out.println("Get index: " + linkedList.getByIndex(3));
        linkedList.addFirst(10);
        System.out.println("LinkedList after adding element in head:" + linkedList);
        linkedList.addLast(20);
        System.out.println("LinkedList after adding element in tail:" + linkedList);
        linkedList.removeFirst();
        System.out.println("LinkedList after remove element in head:" + linkedList);
        linkedList.removeLast();
        System.out.println("LinkedList after remove element in tail:" + linkedList);
        linkedList.add(0, 22);
        linkedList.add(6, 33);
        linkedList.add(3, 44);
        System.out.println("LinkedList after add by index:" + linkedList);
        linkedList.clear();
        System.out.println("LinkedList after clear: " + linkedList);
        System.out.println("------------------------------------------");
    }
}
