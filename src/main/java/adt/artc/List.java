package adt.artc;

public interface List<E> {

    boolean isEmpty();

    void remove(E e);
    
    abstract E removeAt(int index);

    void add(E e);

    int size();
}
