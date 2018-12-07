package adt.artc.tree;

public class AVLTreeMain {

    public static void main(String[] args) {
        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (int i = 0; i < 10; i++) {
            avl.insert(i, i);
            avl.inOrder();
        }

        delete(avl, 3);
        delete(avl, 6);
        delete(avl, 2);
        delete(avl, 0);
    }

    private static void delete(AVLTree<Integer, Integer> avl, int key) {
        Integer delete = avl.delete(key);
        System.out.println("delete key : " + key + " value : " + delete);
        avl.inOrder();
    }

}
