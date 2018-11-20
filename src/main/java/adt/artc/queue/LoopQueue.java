package adt.artc.queue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int front;
    private int tail;

    public LoopQueue() {
        this(8);
    }

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = tail = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public boolean offer(E e) {

        growIfNecessary();

        data[tail] = e;
        tail = index(tail + 1);
        return true;
    }


    @Override
    public E take() {
        if (size() == 0)
            throw new IllegalArgumentException("Empty Queue!");

        final E retValue = data[front];
        data[front] = null;
        front = index(front + 1);

        reduceIfNecessary();

        return retValue;
    }

    @Override
    public E peek() {
        if (size() == 0)
            throw new IllegalArgumentException("Empty Queue!");

        return data[front];
    }

    /**
     * 检查, 缩容量
     */
    private void reduceIfNecessary() {

        if (size() > data.length / 3) {
            return;
        }

        int newCapacity = capacity() >> 1;
        E[] newData = (E[]) new Object[newCapacity + 1];
        int index = 0;
        for (int i = front; i % data.length != tail; i++) {
            newData[index] = data[index(i)];
            index++;
        }
        data = newData;
        front = 0;
        tail = index;

    }

    private int size() {
        if (front <= tail) {
            return tail - front;
        }
        return data.length - (front - tail + 1);
    }

    private int capacity() {
        if (data.length == 0)
            return 0;

        return data.length - 1;
    }

    /**
     * 检查扩容
     */
    private void growIfNecessary() {

        if (index(tail + 1) != front) {
            return;
        }

        int newCapacity = capacity() << 1;
        E[] newData = (E[]) new Object[newCapacity + 1];
        int index = 0;
        for (int i = front; i % data.length != tail; i++) {
            newData[index] = data[index(i)];
            index++;
        }
        data = newData;
        front = 0;
        tail = index;
    }

    private int index(int k) {
        return k % data.length;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("front : ");
        for (int i = front; index(i) != tail; i++) {
            builder.append(index(i)).append(" -> ");
        }
        builder.append(" tail | ");
        builder.append(" : front index is : ").append(front);
        builder.append(" : tail index is : ").append(tail);
        builder.append(" : capacity is : ").append(data.length - 1);
        builder.append(" : size is : ").append(size());
        return builder.toString();
    }
}
