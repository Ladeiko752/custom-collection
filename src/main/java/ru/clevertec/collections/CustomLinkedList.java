package ru.clevertec.collections;

public class CustomLinkedList <T> implements CustomList<T>, CustomDeque<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;
    private int maxSize;

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
            addLast(t);
        }
        size++;
        checkForExceedingMaxSize();
        return true;
    }

    @Override
    public boolean remove() {
        removeLast();
        return true;
    }

    @Override
    public boolean removeByObject(Object o) {
        Node<T> node = head;

        if (o == null) {
            for(int i = 0; i < size; i++){
                if (node.value == null){
                    removeByIndex(i);
                    return true;
                }else {
                    node = node.nextItem;
                }
            }
        } else {
            for (int i = 0; i < size; i++){
                if (o.equals(node.value)){
                    removeByIndex(i);
                    return true;
                }else {
                    node = node.nextItem;
                }
            }
        }
        return false;
    }


    @Override
    public boolean removeByIndex(int index) {
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
    public void trim() {
        Node<T> node = head;
        for (int i = 0; i < size; i++){
            if (node.value == null){
                removeByObject(null);
            }
            node = node.nextItem;
        }
    }

    @Override
    public int find(Object o) {
        Node<T> node = head;
        if (o == null){
            for (int i = 0; i < size; i++){
                if (node.value == null){
                    return i;
                } else {
                    node = node.nextItem;
                }
            }
        }else {
            for (int i = 0; i < size; i++){
                if (o.equals(node.value)){
                    return i;
                } else {
                    node = node.nextItem;
                }
            }
        }
        return -1;
    }

    @Override
    public Object[] toArray() {
        Object array[] = new Object[size];
        Node<T> node = head;
        for (int i = 0; i < size; i++){
            array[i] = node.value;
            node = node.nextItem;
        }
        return array;
    }

    @Override
    public <S> S[] toArray(S[] a) {
        Object array[] = a;
        Node<T> node = head;
        for (int i = 0; i < size; i++){
            array[i] = node.value;
            node = node.nextItem;
        }
        return a;
    }

    @Override
    public T set(int index, T t) {
        Node<T> node = findNode(index);
        node.value = t;
        return node.value;
    }

    @Override
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void checkForExceedingMaxSize(){
        if (size > maxSize && maxSize!=0){
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void addFirst(T t) {
        if (head == null){
            head = new Node<>(t, null, null);
            tail = head;
            size++;
            checkForExceedingMaxSize();
            return;
        }

        Node<T> first = head;
        Node<T> newNode = new Node<>(t, first, null);
        first.previousItem = newNode;
        head = newNode;
        size++;
        checkForExceedingMaxSize();
    }

    @Override
    public void addLast(T t) {
        //checkForExceedingMaxSize();
        if (head == null){
            head = new Node<>(t, null, null);
            tail = head;
            size++;
            checkForExceedingMaxSize();
            return;
        }

        Node<T> newNode = head;
        while (newNode.nextItem != null){
            newNode = newNode.nextItem;
        }
        newNode.nextItem = new Node<>(t, null, newNode);
        tail = newNode.nextItem;
        size++;
        checkForExceedingMaxSize();
    }

    public Node<T> findNode(int index){
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
        return node;
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

    public CustomIterator<T> iterator() {
        CustomIterator<T> it = new CustomIterator<T>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                checkingIfCollectionIsEmpty();
                return currentIndex < size;
            }

            @Override
            public T next() {
                return getByIndex(currentIndex++);
            }

            @Override
            public boolean remove() {
                return removeByIndex(currentIndex);
            }

            @Override
            public void addBefore(T t) {
                checkingIfCollectionIsEmpty();
                add(currentIndex--, t);
            }

            @Override
            public void addAfter(T t) {
                add(currentIndex++, t);
            }
        };
        return it;
    }

    @Override
    public String toString() {
        if (head == null){
            return "[ ]";
        }else
            return "[" + head + "]";
    }
}
