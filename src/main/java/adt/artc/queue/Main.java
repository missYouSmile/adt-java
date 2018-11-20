package adt.artc.queue;

public class Main {

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>(5);
        System.out.println(loopQueue);
        for (int i = 0; i < 9; i++) {
            loopQueue.offer(i + 1);
            System.out.println(loopQueue);
        }

        for (int i = 0; i < 7; i++) {
            Integer take = loopQueue.take();
            System.out.println(loopQueue + " -------- take :" + take);
        }

        Integer take = loopQueue.take();
        System.out.println(loopQueue + " -------- take :" + take);
        take = loopQueue.take();
        System.out.println(loopQueue + " -------- take :" + take);

        for (int i = 0; i < 9; i++) {
            loopQueue.offer(i + 1);
            System.out.println(loopQueue);
        }
        System.out.println(loopQueue);
    }

}
