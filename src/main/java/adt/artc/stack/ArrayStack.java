package adt.artc.stack;

import adt.artc.list.array.ArrayList;

public class ArrayStack<E> implements Stack<E> {

    private ArrayList<E> data;

    public ArrayStack() {
        data = new ArrayList<>();
    }

    public ArrayStack(int capacity) {
        data = new ArrayList<>(capacity);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public E pop() {
        if (isEmpty())
            throw new IllegalArgumentException("Empty Stack!");

        return data.removeAt(data.size() - 1);
    }

    @Override
    public E peek() {
        if (isEmpty())
            throw new IllegalArgumentException("Empty Stack!");

        return data.get(data.size() - 1);
    }

    @Override
    public void add(E e) {
        data.add(e);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
