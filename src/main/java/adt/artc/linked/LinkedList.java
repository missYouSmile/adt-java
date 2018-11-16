package adt.artc.linked;

public class LinkedList<E> extends AbstractLinkedList<E> {

    @Override
    public boolean isEmpty() {
        return false;
    }


    @Override
    public void remove(E e) {

    }

    @Override
    public void add(E e) {

    }

    @Override
    public int size() {
        return 0;
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
