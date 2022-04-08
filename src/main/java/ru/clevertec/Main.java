package ru.clevertec;


import ru.clevertec.collections.CustomLinkedList;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        /*CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
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
        CustomLinkedList<String> newLinkedList = new CustomLinkedList<>();
        newLinkedList.add("0");
        newLinkedList.add("1");
        newLinkedList.add("2");
        newLinkedList.add("3");
        newLinkedList.add("4");
        newLinkedList.add("5");
        System.out.println("linked list before trim: " + newLinkedList);
        newLinkedList.set(3, "228");
        //System.out.println(newLinkedList.find("1323"));
        //System.out.println("linked list after trim: " + newLinkedList);

        *//*String[] array = newLinkedList.toArray(new String[newLinkedList.size()]);
        for (String s: array){
            System.out.println(s);
        }*//*
        System.out.println();
        System.out.println("-----------------------------------------------------------");

        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("1");
        customLinkedList.add("2");
        customLinkedList.add("3");
        customLinkedList.add("4");

        System.out.println("CustomLinkedList has next: " + customLinkedList.iterator().hasNext());
        System.out.println("CustomLinkedList next: " + customLinkedList.iterator().next());

        System.out.println("-----------------------------------------------------------");
        System.out.println();
        System.out.println("-----------------------------------------------------------");*/
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.setMaxSize(10);
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.addFirst("228");
        System.out.println(list);

        //System.out.println(newLinkedList.iterator().hasNext());

        /*Object[] array = list.toArray();
        for (Object s: array){
            System.out.println(s);
        }*/
    }
}
