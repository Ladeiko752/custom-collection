package ru.clevertec.collections;

import java.util.LinkedList;

public class CustomLinkedList <T> implements CustomList<T>, CustomDeque<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public CustomLinkedList() {}

    @Override
    public int size() {
        return size;
    }

    private void checkingIfCollectionIsEmpty(){
        if (isEmpty()) throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean add(T t) {
        addLast(t);
        return true;
    }

    @Override
    public boolean add(int index, T t) {
        int counter = 0;
        Node<T> node = head;
        while (counter!=index){
            if (counter == index + 1){
                addLast(t);
                return true;
            }else if (counter - index > 1){
                throw new IndexOutOfBoundsException();
            }
            else{
                node = node.nextItem;
                counter++;
            }
        }

        if (node == head){
            addFirst(t);
        }else if (node == tail){
            node = new Node<>(t, tail, tail.previousItem);
            tail.previousItem.nextItem = node;
            tail.previousItem = node;

        }else {
            Node<T> tNode = node;
            node = new Node<>(t, tNode, node.previousItem);
            tNode.previousItem = node;
            node.previousItem.nextItem = node;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove() {
        removeLast();
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> node = head;
        int counter = 0;

        if (o == null) {
            while (node.nextItem!=null){
                if (counter <= size){
                    if (node.value == null){
                        remove(counter);
                        return true;
                    }
                    counter++;
                }else {
                    throw new IndexOutOfBoundsException();
                }

            }
        } else {
            while (node.nextItem!=null){
                if (counter <= size){
                    if (o.equals(node.value)){
                        remove(counter);
                        return true;
                    }
                    counter++;
                }else {
                    throw new IndexOutOfBoundsException();
                }
            }
        }
        return false;
    }


    @Override
    public boolean remove(int index) {
        checkingIfCollectionIsEmpty();

        int counter = 0;
        Node<T> node = head;
        while (counter!=index){
            if (counter <= index){
                node = node.nextItem;
                counter++;
            }else throw new IndexOutOfBoundsException();
        }

        if (node == head){
            removeFirst();
        }else if (node == tail){
            removeLast();

        }else {
            node.previousItem.nextItem = node.nextItem;
            node.nextItem.previousItem = node.previousItem;
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void clear() {
        for (CustomLinkedList.Node<T> node = head; node != null; ) {
            CustomLinkedList.Node<T> next = node.nextItem;
            node.value = null;
            node.nextItem = null;
            node.previousItem = null;
            node = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public T getByIndex(int index) {
        Node<T> node;
        if (index < (size/2)){
            node = head;
            for (int i = 0; i < index; i++)
                node = node.nextItem;
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--)
                node = node.previousItem;
        }
        return node.value;
    }

    @Override
    public void addFirst(T t) {
        if (head == null){
            head = new Node<>(t, null, null);
            tail = head;
            size++;
            return;
        }

        Node<T> first = head;
        Node<T> newNode = new Node<>(t, first, null);
        first.previousItem = newNode;
        head = newNode;
        size++;
    }

    @Override
    public void addLast(T t) {
        if (head == null){
            head = new Node<>(t, null, null);
            tail = head;
            size++;
            return;
        }

        Node<T> newNode = head;
        while (newNode.nextItem != null){
            newNode = newNode.nextItem;
        }
        newNode.nextItem = new Node<>(t, null, newNode);
        tail = newNode.nextItem;
        size++;
    }

    @Override
    public T removeFirst() {
        checkingIfCollectionIsEmpty();

        T value = head.value;
        Node<T> node = head;

        if (node.nextItem!= null){
            head = node.nextItem;
            head.previousItem = null;
        }else {
            head = null;
        }
        size--;
        return value;
    }

    @Override
    public T removeLast() {
        checkingIfCollectionIsEmpty();

        T value = tail.value;
        Node<T> node = head;

        while (node.nextItem != null){
            node = node.nextItem;
        }
        if (node != head){
            tail = node.previousItem;
            tail.nextItem = null;
        }else {
            head = null;
        }
        size--;
        return value;
    }

    private static class Node<T>{
        T value;
        Node<T> nextItem;
        Node<T> previousItem;

        public Node(T value, Node<T> nextItem, Node<T> previousItem) {
            this.value = value;
            this.nextItem = nextItem;
            this.previousItem = previousItem;
        }

        @Override
        public String toString() {
            if (nextItem != null){
                return  value + ", " + nextItem;
            }else
                return value + "";
        }
    }

    @Override
    public String toString() {
        if (head == null){
            return "[ ]";
        }else
            return "[" + head + "]";
    }
}
