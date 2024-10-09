package datastructures.Linear.Queues;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items;
    private int count;

    public PriorityQueue(int capacity) {
        items = new int[capacity];
    }

    public void enqueue(int item) {
        if (isFull())
            throw new IllegalStateException("The queue is full.");

        var i = shiftItemToInsert(item);
        items[i] = item;
        count++;
    }

    private int shiftItemToInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item)
                items[i + 1] = items[i];  // Shift items to the right
            else
                break;
        }
        return i + 1;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("The queue is empty.");

        int frontItem = items[0];
        for (int i = 0; i < count - 1; i++)
            items[i] = items[i + 1];

        items[--count] = 0;  // Clear the last element and decrement count
        return frontItem;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
