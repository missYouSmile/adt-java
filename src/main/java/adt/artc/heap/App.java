package adt.artc.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    private final static int MAX_VALUE = Integer.MAX_VALUE;
    private final static int MAX_OPTIONS = 10000000;

    public static void main(String[] args) {
        // maxHeapTest();

        IndexHeap<Integer> indexHeap = new IndexHeap<>(MAX_OPTIONS);
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            indexHeap.offer(random.nextInt(2000));
            indexHeap.printfData();
        }

        List<Integer> list = new ArrayList<>();
        while (!indexHeap.isEmpty()) {
            Integer top = indexHeap.extract();
            list.add(top);
        }

        System.out.println(list);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(i - 1))
                throw new RuntimeException("No sorted");
        }

    }

    private static void maxHeapTest() {
        long start = System.nanoTime();

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < MAX_OPTIONS; i++) {
            maxHeap.offer(random.nextInt(MAX_VALUE));
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < maxHeap.size(); i++) {
            list.add(maxHeap.extract());
        }

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) < list.get(i))
                throw new RuntimeException("no-sort");
        }

        long end = System.nanoTime();
        double time = (end - start) / 1000000000.0;
        System.out.println("execute completed and right! time is : " + time + " s");
    }

}
