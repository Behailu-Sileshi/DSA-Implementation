package datastructures.Linear.Stacks;

import java.util.Arrays;
import java.util.EmptyStackException;

public class LinkedListStack {
    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node top;
    private int size;

    public void push(int value) {
        Node newNode = new Node(value);
        // Point the new node to the current top
        newNode.next = top;
        // Update the top to be the new node
        top = newNode;
        size++;
    }

    public int pop() {
        if (isEmpty())
            throw new EmptyStackException();
        int poppedValue = top.value;
        // Move the top to the next node
        top = top.next;
        size--;
        return poppedValue;
    }

    public int peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        int[] array = new int[size];
        int count = 0;
        Node current = top;
        while (current != null) {
            array[count++] = current.value;
            current = current.next;
        }
        return Arrays.toString(array);
    }
}
