package adt.artc.heap;

public class IndexHeap<E extends Comparable<E>> {

    private E[] data;
    private int[] indexes;
    private int[] reverse;
    private int size;

    public IndexHeap(int capacity) {
        data = (E[]) new Comparable[capacity];
        indexes = new int[capacity];
        reverse = new int[capacity];
    }

    public int maxIndex() {
        if (isEmpty())
            throw new RuntimeException("Empty Heap!");
        return indexes[0];
    }

    public E peek() {
        return data[maxIndex()];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void offer(E e) {
        data[size] = e;
        indexes[size] = size;
        size++;
        shiftUp(size - 1);
    }

    public E extract() {
        if (size <= 0)
            throw new RuntimeException("Empty Heap!");

        E top = data[indexes[0]];
        swap(0, size - 1);
        size--;
        data[indexes[size]] = null;
        shiftDown(0);
        return top;
    }

    public void printfData() {
        StringBuilder builder = new StringBuilder("Data : [");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i < size - 1)
                builder.append(", ");
            else
                builder.append("]");
        }
        System.out.println(builder);
    }

    private void shiftDown(int i) {
        while (left(i) < size) {
            int left = left(i);
            int right = right(i);

            int maxIndex = left;
            if (right < size && data[indexes[left]].compareTo(data[indexes[right]]) < 0)
                maxIndex = right;

            if (data[indexes[maxIndex]].compareTo(data[indexes[i]]) > 0) {
                swap(i, maxIndex);
                i = maxIndex;
            } else
                break;
        }
    }

    private void shiftUp(int i) {
        while (i > 0) {
            int parent = parent(i);
            if (data[indexes[i]].compareTo(data[indexes[parent]]) > 0) {
                swap(i, parent);
                i = parent;
            } else
                break;
        }
    }

    private int left(int p) {
        return (p << 1) + 1;
    }

    private int right(int p) {
        return (p << 1) + 2;
    }

    private int parent(int k) {
        if (k <= 0)
            throw new IllegalArgumentException("illegal parent index : " + k);
        return (k - 1) >> 1;
    }

    private void swap(int i, int j) {
        int temp = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = temp;
    }
}
