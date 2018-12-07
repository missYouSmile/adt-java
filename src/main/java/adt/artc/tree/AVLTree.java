package adt.artc.tree;

public class AVLTree<K extends Comparable<K>, V> {

    private Node root;
    private int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(K key, V value) {
        Node node = new Node(key, value);
        root = insert(root, node);
    }

    public V delete(K key) {
        Node delNode = find(root, key);
        if (delNode == null)
            return null;
        root = delete(root, delNode);
        return delNode.value;
    }

    private Node delete(Node node, Node delNode) {
        if (node == null)
            throw new NullPointerException("Empty AVL!");

        if (node.key.compareTo(delNode.key) < 0) {
            node.right = delete(node.right, delNode);
        } else if (node.key.compareTo(delNode.key) > 0) {
            node.left = delete(node.left, delNode);
        } else {
            // 删除
            if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                Node min = findMin(node.right);
                Node rightNode = delete(node.right, min);
                size++; // 维护 size
                min.left = node.left;
                min.right = rightNode;
                node.left = node.right = null;
                node = min;
            }
            size--;
        }

        return balance(node);
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

    private Node insert(Node node, Node newNode) {

        if (node == null) {
            size++;
            node = newNode;
            node.height = 1;
            return node;
        }

        int cmp = node.key.compareTo(newNode.key);
        if (cmp < 0) {
            node.right = insert(node.right, newNode);
        } else if (cmp > 0) {
            node.left = insert(node.left, newNode);
        } else // 如果key 相等, 更新 value
            node.value = newNode.value;

        return balance(node);
    }

    /**
     * 维护平衡
     */
    private Node balance(Node node) {
        if (node == null)
            return null;

        int rh = height(node.right);
        int lh = height(node.left);
        if (rh - lh > 1) {
            int factor = height(node.right.left) - height(node.right.right);
            if (factor > 0) { // RL
                node.right = rightRotation(node.right);
                node = leftRotation(node);
            } else if (factor < 0) { // RR
                node = leftRotation(node);
            }
        } else if (lh - rh > 1) {
            int factor = height(node.left.left) - height(node.left.right);
            if (factor < 0) { // LR
                node.left = leftRotation(node.left);
                node = rightRotation(node);
            } else if (factor > 0) { // LL
                node = rightRotation(node);
            }
        }
        // 维护 node 高度
        node.height = Math.max(height(node.right), height(node.left)) + 1;
        return node;
    }

    public void inOrder() {
        inOrder(root);
        System.out.println(" size = " + size + " , root key is : " + root.key);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node + ", ");
        inOrder(node.right);
    }

    private Node leftRotation(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;

        node.height = Math.max(height(node.right), height(node.left)) + 1;
        temp.height = Math.max(height(temp.right), height(temp.left)) + 1;
        return temp;
    }

    private Node rightRotation(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;

        node.height = Math.max(height(node.right), height(node.left)) + 1;
        temp.height = Math.max(height(temp.right), height(temp.left)) + 1;
        return temp;
    }

    private int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    private class Node {
        K key;
        V value;
        Node left;
        Node right;

        int height;

        Node() {
        }

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "|" + height(this);
        }
    }
}
