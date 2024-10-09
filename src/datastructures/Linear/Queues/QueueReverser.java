package datastructures.Linear.Queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {
    private Queue<Integer> queue;
    public QueueReverser(Queue<Integer> queue) {
        this.queue = queue;
    }
    public  void reverse() {
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while(! stack.isEmpty())
            queue.add(stack.pop());
    }
    public void reverseTheFirstKthElement(int k) {
        if (queue == null || k > queue.size())
            throw new IllegalArgumentException("Invalid input");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++)
            stack.push(queue.remove());
        while(!stack.isEmpty())
            queue.add(stack.pop());
        for (int i = 0; i < queue.size() - k; i++) {
                int element = queue.remove();
                queue.add(element);
        }
    }

}
