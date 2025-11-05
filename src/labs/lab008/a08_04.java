package labs.lab008;
import java.util.Stack;

public class a08_04 {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        stack2.push(4);
        stack2.push(5);
        stack2.push(6);

        System.out.println("Before swap:");
        System.out.println("stack1 = " + stack1);
        System.out.println("stack2 = " + stack2);

        swapStacks(stack1, stack2);

        System.out.println("\nAfter swap:");
        System.out.println("stack1 = " + stack1);
        System.out.println("stack2 = " + stack2);
    }

    public static void swapStacks(Stack<Integer> s1, Stack<Integer> s2) {
        Stack<Integer> temp = new Stack<>();


        while (!s1.isEmpty()) {
            temp.push(s1.pop());
        }

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        while (!temp.isEmpty()) {
            s2.push(temp.pop());
        }
    }
}
