package datastructures.Linear.Stacks;

import java.util.Stack;

public class StringReverser {
    public String reverse(String str) {
        Stack<Character> stack = new Stack<>();
        for (char item : str.toCharArray()) {
            stack.push(item);
        }
        StringBuilder reversed = new StringBuilder();
        while(!stack.empty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }
}
