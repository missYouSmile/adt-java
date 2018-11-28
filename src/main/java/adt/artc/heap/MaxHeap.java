package adt.artc.heap;

import adt.artc.list.array.ArrayList;

public class MaxHeap<E extends Comparable<E>> {

    private ArrayList<E> data;

    public MaxHeap() {
        data = new ArrayList<>();
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int k) {
        if (k <= 0)
            throw new IllegalArgumentException("illegal parent index : " + k);
        return (k - 1) / 2;
    }

    private int leftChild(int k) {
        return 2 * k + 1;
    }

    private int rightChild(int k) {
        return 2 * k + 2;
    }

    private void swap(int i, int j) {
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    private void siftUp(int k) {
        while (k > 0) {
            int p = parent(k);
            if (data.get(p).compareTo(data.get(k)) < 0) {
                swap(p, k);
                k = p;
            } else
                break;
        }
    }

    public void offer(E e) {
        data.add(e);
        siftUp(data.size() - 1);
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.size()) {
            int maxIndex = leftChild(k);
            int rightIndex = rightChild(k);
            if (rightIndex < data.size() && data.get(rightIndex).compareTo(data.get(maxIndex)) > 0)
                maxIndex = rightIndex;

            if (data.get(maxIndex).compareTo(data.get(k)) > 0) {
                swap(k, maxIndex);
                k = maxIndex;
            } else
                break;
        }
    }

    public E extract() {
        if (isEmpty())
            throw new NullPointerException("Empty Heap!");

        E ret = data.get(0);

        E temp = data.removeAt(data.size() - 1);
        if (!data.isEmpty()) {
            data.set(0, temp);
            siftDown(0);
        }

        return ret;
    }
}
