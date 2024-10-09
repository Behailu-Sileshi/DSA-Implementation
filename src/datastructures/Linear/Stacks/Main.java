package datastructures.Linear.Stacks;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var stack = new StackArray(10);
        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(8);
        stack.push(2);
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.min());


    }
}