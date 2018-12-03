package adt.artc.tree;

public class BinarySearchTreeMain {

    public static void main(String[] args) {

        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();

        Integer[] key = {123, 32, 432, 5, 534, 243, 43, 543, 6456, 54, 13, 321, 547, 6574, 1};

        for (int i = 0; i < key.length; i++) {
            bst.insert(key[i], i + 1);
            bst.inOrder();
        }

        boolean b = bst.containsKey(123);
        System.out.println("b = " + b);

        boolean b1 = bst.containsKey(12);
        System.out.println("b1 = " + b1);

        Integer node = bst.delete(1);
        System.out.println("delete key is " + 1 + " value is " + node);
        bst.inOrder();


        node = bst.delete(543);
        System.out.println("delete key is " + 543 + " value is " + node);
        bst.inOrder();

        node = bst.delete(123);
        System.out.println("delete key is " + 123 + " value is " + node);
        bst.inOrder();

        for (int i = 0; i < key.length; i++) {
            node = bst.delete(key[i]);
            System.out.println("delete key is " + key[i] + " value is " + node);
            bst.inOrder();
        }

        for (int i = 0; i < key.length; i++) {
            bst.insert(key[i], i + 1);
            bst.inOrder();
        }

    }

}
