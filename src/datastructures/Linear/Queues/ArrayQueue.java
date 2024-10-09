package datastructures.Linear.Queues;

import java.util.Arrays;

public class ArrayQueue {
    private int[] items;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
    }
    public void enqueue(int item) {
        if (count == items.length)
            throw new IllegalStateException("The Queue is full.");
        items[rear] = item;
//        using circular array.
        rear = (rear + 1) % items.length;
        count++;
    }
    public int dequeue(){
        if (count == 0)
            throw new IllegalStateException("The queue is empty.");
        int front_item =  items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return front_item;
    }
    public int peek() {
        if(isEmpty())
            throw new IllegalStateException("The queue is empty.");
        return items[front];
    }
    public boolean isEmpty() {
        return count == 0;
    }
    public boolean isFull() {
        return rear == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
