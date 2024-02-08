package by.aston;

import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T>{
    private int size =10;
    private T[] array;
//    private static final int CAPACITY = 10;
    private double LOAD_FACTOR = 1.5D;

    public ArrayList(List<? extends T> collection) { //Task 2
        int size = 0;
        while (true) {
            try {
                collection.get(size);
                size++;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

        this.size = size;
        array = (T[]) new Object[this.size + 10];
        if (size > array.length) resize();
        for (int i = 0; i < size; i++) array[i] = collection.get(i);
    }

    public ArrayList() {
            array = (T[]) new Object[10];
    }

    public ArrayList(int capacity, double loadFactor){
        LOAD_FACTOR = loadFactor;
        array = (T[])new Object[capacity];
    }

    @Override
    public boolean add(T t) {
        if (t ==null)return false;
        if(array.length == size)resize();
        array[size++] =t;
        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }


    @Override
    public T remove(int index) {
        if (index<0 || index>=size)throw new IndexOutOfBoundsException();

        T removedOne = array[index];
        for (int i = index; i < size-1; i++) {
            array[i] = array[i+1];
        }
        size--;
        return removedOne;
    }

    @Override
    public boolean addAll(List<? extends T> collection) {
        boolean isModified = false;
        int i = 0;
        while (true){
            try {
                if (add(collection.get(i)))isModified =true;
                i++;
            }catch (IndexOutOfBoundsException e){
                break;
            }
        }
        return isModified;
    }



    public void resize(){
        int newSize = (int)(array.length * LOAD_FACTOR);
        T[] newArray = (T[]) new Object[newSize];

        for (int i = 0; i < size; i++) {
            newArray[i]=array[i];
        }
        array = newArray;
    }
    @Override
    public boolean isEmpty() {
        return size==0;
    }
    @Override
    public int indexOf(T t) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(t))return  i; // не проверяем равенство с null, так как add не допускает null
        }
        return -1;
    }



    public ListIterator<T> iterator(){return new ArrayListIterator();}
    private class ArrayListIterator implements ListIterator<T>{
        private int currentlyIndex =-1;

        @Override
        public boolean hasNext() {return currentlyIndex+1 < size;}

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return array[++currentlyIndex];
        }
    }

}
