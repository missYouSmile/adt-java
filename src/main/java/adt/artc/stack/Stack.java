package adt.artc.stack;

/**
 * 栈: 按 '先进后出,后进先出' 顺序出入的 List
 * 基于 ArrayList 或者 LinkedList 实现
 *
 * Java 中的栈 为数组实现 , 继承于 Vector<E>
 */
public interface Stack<E> {

    int size();

    boolean isEmpty();

    E pop();

    E peek();

    void add(E e);

}
