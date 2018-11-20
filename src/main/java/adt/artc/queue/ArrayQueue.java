package adt.artc.queue;

import adt.artc.list.array.ArrayList;

/**
 * 数组队列
 */
public class ArrayQueue<E> implements Queue<E> {

    private ArrayList<E> data;

    public ArrayQueue() {
        data = new ArrayList<>();
    }

    public ArrayQueue(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("capacity must be > 0");
        data = new ArrayList<>(capacity);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean offer(E e) {
        data.add(e);
        return true;
    }

    // O(n)
    @Override
    public E take() {
        if (isEmpty())
            throw new IllegalArgumentException("Empty Queue!");
        return data.removeAt(0);
    }

    @Override
    public E peek() {
        if (isEmpty())
            throw new IllegalArgumentException("Empty Queue!");
        return data.get(0);
    }
}
