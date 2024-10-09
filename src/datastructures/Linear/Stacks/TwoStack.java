package datastructures.Linear.Stacks;

import java.util.Arrays;

public class TwoStack {
    int[] items = new int[10];
    int count1 = 0;
    int count2 = items.length - 1;

    public void push1(int item){
        if (count1 <= count2)
            items[count1++] = item;
        else
            throw new StackOverflowError("Stack1 is full.");
        }
    public void push2(int item){
        if (count1 <= count2)
            items[count2--] = item;
        else
            throw new StackOverflowError("Stack 2 is full.");
    }
    public int pop1() {
        if (count1 == 0)
            throw new IllegalStateException("Stack 1 is Empty.");
        int popped_item = items[--count1];
        items[count1] = 0;
        return popped_item;
    }
    public int pop2() {
        if (count2 == items.length)
            throw new IllegalStateException("Stack2 is empty.");
        int popped_item = items[++count2];
       items[count2] = 0;
       return popped_item;
    }
    public boolean isEmpty1() {
        return count1 == 0;
    }
    public boolean isEmpty2() {
        return count2 == items.length - 1;
    }
    public String Stack1(){
        int [] array =  Arrays.copyOfRange(items, 0, count1);
        return Arrays.toString(array);
    }
    public String Stack2(){
        int [] array =  Arrays.copyOfRange(items, count2 + 1, items.length);
        return Arrays.toString(array);
    }
}
