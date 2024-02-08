package by.aston;

public class LinkedList<T> implements List<T>{
    private Node<T> head=null;
    private Node<T> tail=null;
    private int size=0;
    private static final int CAPACITY = 10;
    private static double LOAD_FACTOR = 0.75;


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
        if ((double)size / CAPACITY >= LOAD_FACTOR)resize();

        Node<T> newNode = new Node<>(t);
        if (head == null) {
            return false;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        Node<T> toRemove = (Node<T>) get(index);
        if (toRemove == head) {
            head = toRemove.next;
        } else {
            toRemove.prev.next = toRemove.next;
            return (T)toRemove; //
        }

         if (toRemove == tail) {
            tail = toRemove.prev;
        } else {
            toRemove.next.prev = toRemove.prev;
        }
        return (T)toRemove;
    }

    @Override
    public boolean addAll(List<? extends T> collection) {
        if ((double)size / CAPACITY >= LOAD_FACTOR) resize();

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
    public void resize() {
        int newSize = (int) (size / LOAD_FACTOR);
        Node<T>[] newArray = new Node[newSize];

        Node<T> current = head;
        int index = 0;
        while (current != null) {
            newArray[index] = current;
            current = current.next;
            index++;
        }
    }

    @Override
    public boolean add(int index, T t) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        if ((double)size / CAPACITY >= LOAD_FACTOR) resize();

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
