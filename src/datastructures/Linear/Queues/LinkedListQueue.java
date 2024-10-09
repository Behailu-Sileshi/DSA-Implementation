package datastructures.Linear.Queues;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListQueue {
    private class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
            next = null;
        }
    }
    private Node front;
    private Node rear;
    private int count;
    public void enqueue(int value) {
        Node newValue = new Node(value);
        if (front == null)
            front = rear = newValue;
        else {
            rear.next = newValue;
            rear = newValue;
        }
        count++;
    }
    public int dequeue() {
        int frontItem = front.value;
        front = front.next;
        count--;
        return frontItem;
    }
    public boolean isEmpty() {
        return front == null;
    }
    private int [] toArray(){
        var current = front;
        int [] array = new int[count];
        int index = 0;
        while(current != null) {
                array[index++] = current.value;
                current = current.next;

        }
        return array;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
