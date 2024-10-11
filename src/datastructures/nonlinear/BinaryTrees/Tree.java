package datastructures.nonlinear.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private class Node {
        int value;
        Node leftChild;
        Node rightChild;
        public Node (int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }
    private Node root;
    public void insert(int value) {
        var node = new Node(value);
        if(root == null) {
            root = node;
            return;
        }
            var current = root;
            while(true) {
                if (value < current.value) {
                    if (current.leftChild == null) {
                        current.leftChild = node;
                        break;
                    }
                    current = current.leftChild;
                }
                else if (value > current.value) {
                    if (current.rightChild == null) {
                        current.rightChild = node;
                        break;
                    }
                    current = current.rightChild;
                }
                else
                    break;
            }
    }
    public boolean find(int value) {
        var current = root;
        while(current != null) {
            if (current.value < value)
                current = current.rightChild;
            else if (current.value > value)
                current = current.leftChild;
            else
                return true;
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }
    private void traversePreOrder(Node root) {
        if (root == null)
            return;
        System.out.println(root);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }
    public void traverseInorder() {
        traverseInOrder(root);
    }
    private void traverseInOrder(Node root) {
        if (root == null)
            return;
        traverseInOrder(root.leftChild);
        System.out.println(root);
        traverseInOrder(root.rightChild);

    }
    public void traversePostOrder() {
        traversePostOrder(root);
    }
    private void traversePostOrder(Node root) {
        if (root == null)
            return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root);
    }
    public int height() {
        return height(root);
    }
    private int height(Node root) {
        if (root == null)
            return -1;
        if (isLeaf(root))
            return 0;
        return 1 + Math.max(
                height(root.leftChild),
                height(root.rightChild));
    }
    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }
    public int min() {
        return min(root);
    }
//    for binary tree O(n)
    private int min(Node root) {
        if (isLeaf(root))
            return root.value;
        int left = min(root.leftChild);
        int right = min(root.rightChild);
        return Math.min(Math.min(left, right), root.value);
    }
    public boolean equals(Tree other) {
        if (other.root == null)
            return false;
        return equals(root, other.root);
    }
    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return false;
        if (first != null && second != null)
            return (first.value == second.value &&
                    equals(first.leftChild, second.leftChild) &&
                    equals(first.rightChild, second.rightChild));

        return false;
    }
    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBinarySearchTree(Node root, int min, int max){
        if (root == null)
            return true;
        if (root.value < min || root.value > max)
            return false;
        return isBinarySearchTree(root.leftChild, min, root.value - 1) &&
                isBinarySearchTree(root.rightChild, root.value + 1, max);
    }
    public ArrayList<Integer> getNodesAtDistance(int distance) {
        ArrayList<Integer> list = new ArrayList<>();
        if (distance < 0)
            throw new IllegalArgumentException("The distance K must be greater than 0.");
        getNodesAtDistance(root, distance, list);
        return list;
    }
    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        if (distance == 0) {
            list.add(root.value);
        }
        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }
    public void traverseLevelOrder() {
        for (int i = 0; i <= height(); i++)
            for (int value : getNodesAtDistance(i))
                System.out.println(value);
    }
    public int size() {
        return size(root);
    }
    private int size(Node root) {
        if (root == null)
            return 0;
        return 1 + size(root.leftChild) + size(root.rightChild);


    }
    public int countLeaves() {
        return countLeaves(root);
    }
    private int countLeaves(Node root) {
        if (root == null)
            return 0;
        if (isLeaf(root))
            return 1;
        return countLeaves(root.leftChild) + countLeaves(root.rightChild);


    }
    public int maxBST() {
        return maxBST(root);
    }
//    Using recursion
    private int maxBST(Node root) {
        if (root == null)
            throw new IllegalStateException();
        if (root.rightChild == null)
            return root.value;
        return maxBST(root.rightChild);
    }
    public boolean isContains(int value) {
        return isContains(root, value);
    }
    private boolean isContains (Node root, int value) {
        if (root == null)
            return false;
        if (root.value == value)
            return true;
        return (isContains(root.leftChild, value) ||
                isContains(root.rightChild, value));

    }
    public boolean areSibiling(int first, int second){
        return areSibiling(root, first, second);
    }
    private boolean areSibiling(Node root, int first, int second) {
        if(root == null)
            return false;
        boolean areSibiling = false;
        if (!isLeaf(root))
           areSibiling = (root.leftChild.value == first && root.rightChild.value == second) ||
                    (root.rightChild.value == first && root.leftChild.value == second);
        return areSibiling ||
                areSibiling(root.leftChild, first, second) ||
                areSibiling(root.rightChild, first, second);
    }
    public List<Integer> getAncestors(int value) {
        var list = new ArrayList<Integer>();
        getAncestors(root, value, list);
        return list;
    }

    private boolean getAncestors(Node root, int value, List<Integer> list) {
        // We should traverse the tree until we find the target value. If we
        // find the target value, we return true without adding the current node
        // to the list; otherwise, if we ask for ancestors of 5, 5 will be also
        // added to the list.
        if (root == null)
            return false;

        if (root.value == value)
            return true;

        // If we find the target value in the left or right sub-trees, that means
        // the current node (root) is one of the ancestors. So we add it to the list.
        if (getAncestors(root.leftChild, value, list) ||
                getAncestors(root.rightChild, value, list)) {
            list.add(root.value);
            return true;
        }

        return false;
    }
    public boolean isBalanced() {
        return isBalanced(root);
    }
    private boolean isBalanced(Node root) {
        if (root == null)
            return true;
        return Math.abs(height(root.leftChild) - height(root.rightChild)) <= 1;
    }
    public boolean isPerfect() {
        return size() == 2 * countLeaves() - 1;
    }

}
