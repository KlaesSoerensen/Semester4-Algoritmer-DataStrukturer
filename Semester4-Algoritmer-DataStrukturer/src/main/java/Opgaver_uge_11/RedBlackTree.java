package Opgaver_uge_11;

import Contracts.Sorting;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class RedBlackTree implements Sorting {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    @Override
    public String calculateTime(ArrayList<Integer> array, String name, long length) {
        int toFind = (int) (Math.random() * length);

        long startTime = System.currentTimeMillis();
        this.search(toFind);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        String className = this.getClass().getSimpleName();
        String toPrint = String.format("%02d min, %02d sec",
                TimeUnit.MILLISECONDS.toMinutes(totalTime),
                TimeUnit.MILLISECONDS.toSeconds(totalTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(totalTime))
        );

        return (className + " of size " + length + " and of type " + name + " took: " + toPrint + " - " + totalTime + " milliseconds.");
    }

    private class Node {
        int data;
        Node left, right, parent;
        boolean color;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
            this.color = RED; // New nodes are always red
        }
    }

    private Node root;

    public RedBlackTree() {
        root = null;
    }

    // Public insert method
    public void insert(int data) {
        Node node = new Node(data);
        root = insertRec(root, node);
        fixViolation(node);
    }

    // Recursive insertion
    private Node insertRec(Node root, Node node) {
        if (root == null) return node;

        if (node.data < root.data) {
            root.left = insertRec(root.left, node);
            root.left.parent = root;
        } else if (node.data > root.data) {
            root.right = insertRec(root.right, node);
            root.right.parent = root;
        }

        return root;
    }

    // Fixing violations after insertion
    private void fixViolation(Node node) {
        Node parent = null;
        Node grandParent = null;

        while (node != root && node.color != BLACK && node.parent.color == RED) {
            parent = node.parent;
            grandParent = node.parent.parent;

            // Case A: Parent of node is left child of Grand-parent of node
            if (parent == grandParent.left) {
                Node uncle = grandParent.right;

                // Case 1: The uncle of node is also red, only Recoloring required
                if (uncle != null && uncle.color == RED) {
                    grandParent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grandParent;
                } else {
                    // Case 2: node is right child of its parent, Left-rotation required
                    if (node == parent.right) {
                        rotateLeft(parent);
                        node = parent;
                        parent = node.parent;
                    }

                    // Case 3: node is left child of its parent, Right-rotation required
                    rotateRight(grandParent);
                    boolean tempColor = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = tempColor;
                    node = parent;
                }
            }
            // Case B: Parent of node is right child of Grand-parent of node
            else {
                Node uncle = grandParent.left;

                // Case 1: The uncle of node is also red, only Recoloring required
                if (uncle != null && uncle.color == RED) {
                    grandParent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grandParent;
                } else {
                    // Case 2: node is left child of its parent, Right-rotation required
                    if (node == parent.left) {
                        rotateRight(parent);
                        node = parent;
                        parent = node.parent;
                    }

                    // Case 3: node is right child of its parent, Left-rotation required
                    rotateLeft(grandParent);
                    boolean tempColor = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = tempColor;
                    node = parent;
                }
            }
        }

        root.color = BLACK;
    }

    // Left rotation
    private void rotateLeft(Node node) {
        Node temp = node.right;
        node.right = temp.left;

        if (node.right != null) node.right.parent = node;

        temp.parent = node.parent;

        if (node.parent == null) root = temp;
        else if (node == node.parent.left) node.parent.left = temp;
        else node.parent.right = temp;

        temp.left = node;
        node.parent = temp;
    }

    // Right rotation
    private void rotateRight(Node node) {
        Node temp = node.left;
        node.left = temp.right;

        if (node.left != null) node.left.parent = node;

        temp.parent = node.parent;

        if (node.parent == null) root = temp;
        else if (node == node.parent.right) node.parent.right = temp;
        else node.parent.left = temp;

        temp.right = node;
        node.parent = temp;
    }

    // Utility method to do inorder traversal of the tree
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.data + (root.color == RED ? "R" : "B"));
            inorderRec(root.right);
        }
    }

    // Search method to find a value in the tree
    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node root, int data) {
        if (root == null) return false;
        if (root.data == data) return true;
        return data < root.data ? searchRec(root.left, data) : searchRec(root.right, data);
    }

    // Driver method to test the RedBlackTree class
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(7);
        tree.insert(3);
        tree.insert(18);
        tree.insert(10);
        tree.insert(22);
        tree.insert(8);
        tree.insert(11);
        tree.insert(26);

        tree.inorder();

        if (tree.search(18)) {
            System.out.println("Found 18");
        } else {
            System.out.println("18 not found");
        }
    }

    public void insertAll(ArrayList<Integer> elements) {
        for (int element : elements) {
            insert(element);
        }
    }
}
