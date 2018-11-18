package adt.artc.list;

public interface List<E> {

    boolean isEmpty();

    int capacity();

    E get(int index);

    void remove(E e);

    E removeAt(int index);

    void add(E e);

    int size();
}
