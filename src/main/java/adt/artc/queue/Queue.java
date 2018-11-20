package adt.artc.queue;

public interface Queue<E> {

    boolean isEmpty();

    boolean offer(E e);

    E take();

    E peek();

}
