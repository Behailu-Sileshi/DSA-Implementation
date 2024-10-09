package datastructures.Linear.Stacks;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackArray {
    private int [] items;
    private int count;
    private int min;

    public StackArray(int capacity) {
        items = new int[capacity];
    }
    public void push(int item) {
        if (count == items.length)
            throw new StackOverflowError();
        items[count++] = item;
    }
    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();
        return items[--count];
    }
    public int peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return items[count - 1];
    }
    public boolean isEmpty() {
        return count == 0;
    }
    public int min() {
        return min;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(items,  0, count));
    }
}
