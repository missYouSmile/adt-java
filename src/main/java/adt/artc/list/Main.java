package adt.artc.list;

import adt.artc.list.array.ArrayList;
import adt.artc.list.linked.LinkedList;

public class Main {

    public static void main(String[] args) {

        linkedListTest();
        System.out.println("-------------------------------------------------------------------------");
        arrayListTest();
    }


    /**
     * my linked list option test
     * this is a stack
     */
    private static void linkedListTest() {
        List<Integer> list = new LinkedList<>();

        list.add(1321);
        System.out.println(list);
        list.add(12);
        System.out.println(list);

        for (int i = 0; i < 10; i++) {
            list.add(i);
            System.out.println(list);
        }

        list.remove(0);
        System.out.println(list);
        list.removeAt(0);
        System.out.println(list);
        list.removeAt(0);
        System.out.println(list);
        list.removeAt(0);
        System.out.println(list);
        list.removeAt(0);
        System.out.println(list);
        list.removeAt(0);
        System.out.println(list);
        list.removeAt(0);
        System.out.println(list);
        list.removeAt(0);
        System.out.println(list);
        list.removeAt(0);
        System.out.println(list);
        list.removeAt(0);
        System.out.println(list);
        list.removeAt(0);
        System.out.println(list);
        list.removeAt(0);
        System.out.println(list);
    }

    /**
     * my array list options test
     */
    private static void arrayListTest() {
        List<Integer> list = new ArrayList<>(5);

        for (int i = 0; i < 7; i++) {
            list.add(i);
            System.out.println(list);
        }

        list.remove(3);
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        list.removeAt(3);
        System.out.println(list);
        list.removeAt(3);
        System.out.println(list);
        list.removeAt(0);
        System.out.println(list);
        list.removeAt(0);
        System.out.println(list);
        list.removeAt(0);
        System.out.println(list);
        list.removeAt(0);
        System.out.println(list);

        for (int i = 0; i < 7; i++) {
            list.add(i);
            System.out.println(list);
        }

    }

}
