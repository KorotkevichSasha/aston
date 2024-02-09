package by.aston;

import java.util.Arrays;

public class LinkedList<T> implements List<T>{
    private Node<T> head=null;
    private Node<T> tail=null;
    private int size=0;
    private static final int CAPACITY = 10;

    public LinkedList() {

    }
    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    public LinkedList(List<? extends T> list) { //Task2
        if (list != null) {
            int index = 0;
            while (true) {
                try {
                    T item = list.get(index);
                    add(item);
                    index++;
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }
        }
    }
    @Override
    public boolean add(T t) {
        Node<T> newNode = new Node<>(t);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    @SuppressWarnings("unchecked")
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        Node<T> toRemove = (Node<T>) get(index);
        if (toRemove == head) {
            head = toRemove.next;
        } else {
            toRemove.prev.next = toRemove.next;
        }
         if (toRemove == tail) {
            tail = toRemove.prev;
        } else {
            toRemove.next.prev = toRemove.prev;
        }
         size--;
        return toRemove.data;
    }

    @Override
    public boolean addAll(List<? extends T> collection) {
        if (collection == null || collection.isEmpty()) return false;

        for (int i = 0; i < collection.size(); i++) {
            add(collection.get(i));
        }

        return true;
    }


    public int size() {
        return size;
    }




    @Override
    public boolean add(int index, T t) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        if (index == size) {
            add(t);
        } else {
            Node<T> newNode = new Node<>(t);
            if (index == 0) {
                newNode.next = head;
                head = newNode;
            } else {
                Node<T> current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                newNode.next = current.next;
                newNode.prev = current;
                current.next = newNode;
                newNode.next.prev = newNode;
            }
            size++;
        }
        return true;
    }
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int indexOf(T t) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(t)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
}
