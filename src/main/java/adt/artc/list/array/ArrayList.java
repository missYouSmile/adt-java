package adt.artc.list.array;

import adt.artc.list.List;

public class ArrayList<E> implements List<E> {

    private E[] data;
    private int size;

    public ArrayList() {
        this(8);
    }

    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    @Override
    public int capacity() {
        return data.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("index out of bound : " + index);

        return data[index];
    }

    @Override
    public void remove(E e) {
        int index = 0;
        while (index < size) {
            if (e.equals(data[index]))
                removeAt(index);
            else
                index++;
        }
    }

    @Override
    public E removeAt(int index) {

        if (index < 0 || index >= size)
            throw new IllegalArgumentException("index out of bound : " + index);

        E ret = data[index];
        for (int i = index; i < size; i++) {
            if (i + 1 < size)
                data[i] = data[i + 1];
            data[i + 1] = null;
        }
        size--;

        reduceIfNecessary(size);

        return ret;
    }

    private void reduceIfNecessary(int size) {
        if (size <= data.length / 3) {
            E[] newData = (E[]) new Object[data.length >> 1];
            for (int i = 0; i < this.size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    @Override
    public void add(E e) {
        growIfNecessary(size + 1);
        data[size] = e;
        size++;
    }

    private void growIfNecessary(int newCapacity) {
        if (newCapacity < data.length) {
            return;
        }
        // capacity grow
        E[] newData = (E[]) new Object[data.length << 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(data[i]).append(" -> ");
        }
        builder.append("| element size is : ").append(size);
        builder.append(" , and capacity is : ").append(data.length);
        return builder.toString();
    }
}
