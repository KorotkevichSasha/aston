package by.aston;


public interface List<T> {
    boolean add(T t);
    T get(int index);
    T remove(int index);
    boolean addAll(List<? extends T> collection);
    //Task 1

    boolean add(int index,T t);
    void resize();
    boolean isEmpty();
    int indexOf(T t);
}
