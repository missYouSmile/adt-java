package adt.artc;

import adt.artc.array.ArrayList;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
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
        list.removeAt(3);
        System.out.println(list);
        list.removeAt(3);
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
    }

}
