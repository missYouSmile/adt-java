package adt.artc.list.linked;

import adt.artc.list.List;

public class LinkedList<E> implements List<E> {

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null);
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("index out of bound : " + index);

        Node cur = this.dummyHead.next;
        int i = 0;
        while (i < index) {
            i++;
            cur = cur.next;
        }

        return cur.val;
    }

    @Override
    public void remove(E e) {

        Node prev = dummyHead;
        while (!e.equals(prev.next.val)) {
            prev = prev.next;
        }

        if (prev.next == null)
            return;

        final Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
    }

    @Override
    public E removeAt(int index) {

        if (index < 0 || index >= size)
            throw new IllegalArgumentException("index out of bound : " + index);

        Node prev = this.dummyHead;
        int i = 0;
        while (i < index) {
            i++;
            prev = prev.next;
        }

        final Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;

        return delNode.val;
    }

    // 链表头添加元素
    @Override
    public void add(E e) {
        dummyHead.next = new Node(e, dummyHead.next);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            builder.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        builder.append("| element size is : ").append(size);
        return builder.toString();
    }

    private class Node {
        E val;
        Node next;

        public Node(E val) {
            this.val = val;
        }

        public Node(E val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val.toString();
        }
    }
}
