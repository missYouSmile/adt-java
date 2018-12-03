package adt.artc.tree;

public class BinarySearchTree<K extends Comparable<K>, V> {

    private Node root;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(K key, V value) {
        Node node = new Node(key, value);
        root = insert(root, node);
    }

    public boolean containsKey(K key) {
        return find(key) != null;
    }

    public V find(K key) {
        Node node = find(root, key);
        return node == null ? null : node.value;
    }

    public V delete(K key) {

        Node delNode = find(root, key);

        if (delNode == null)
            return null;

        root = delete(root, key);

        return delNode.value;
    }

    public void inOrder() {
        inOrder(root);
        System.out.println(" size = " + size);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node + ", ");
        inOrder(node.right);
    }

    /**
     * 删除 key 对应的节点, 返回删除后子树的跟节点
     *
     * @param node 待删除的子树根节点
     * @param key  待删除的key
     * @return 删除后, 子树的跟节点
     */
    private Node delete(Node node, K key) {
        if (isEmpty())
            throw new IllegalArgumentException("delete fault! empty binary search tree!");

        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0) {
            node.left = delete(node.left, key);
        } else if (key.compareTo(node.key) > 0)
            node.right = delete(node.right, key);
        else {


            if (node.left == null) {
                Node newRoot = node.right;
                node.right = null;
                size--;
                return newRoot;
            }

            if (node.right == null) {
                Node newRoot = node.left;
                node.left = null;
                size--;
                return newRoot;
            }

            // 获取右子树的最小值
            Node rightMinimum = findMin(node.right);
            // 此处维护 size
            rightMinimum.right = delete(node.right, rightMinimum.key);
            rightMinimum.left = node.left;

            node.left = node.right = null;

            return rightMinimum;
        }

        return node;
    }

    /**
     * 获取根节点的最小节点
     *
     * @param node 树的根
     * @return 最小节点
     */
    private Node findMin(Node node) {
        if (node.left == null)
            return node;

        return findMin(node.left);
    }

    private Node find(Node node, K key) {
        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0)
            return find(node.left, key);
        else if (key.compareTo(node.key) > 0)
            return find(node.right, key);
        else
            return node;
    }

    private Node insert(Node node, Node newNode) {

        if (node == null) {
            size++;
            return newNode;
        }

        if (node.key.compareTo(newNode.key) < 0)
            node.right = insert(node.right, newNode);
        else if (node.key.compareTo(newNode.key) > 0)
            node.left = insert(node.left, newNode);
        else // 如果key 相等, 更新 value
            node.value = newNode.value;

        return node;
    }

    private class Node {
        K key;
        V value;
        Node left;
        Node right;

        public Node() {
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "-" + value;
        }
    }

}
