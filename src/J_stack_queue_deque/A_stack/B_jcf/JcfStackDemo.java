package J_stack_queue_deque.A_stack.B_jcf;

import java.util.Deque;
import java.util.LinkedList;

public class JcfStackDemo {
    public static void main(String[] args) {
        /*
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        // the fact that this is allowed is bad
        System.out.println(stack.get(1));

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        */

        // one way to create a stack
        // Deque<String> stack = new ArrayDeque<>();

        // another way:
        Deque<String> stack = new LinkedList<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        // this line will correctly not compile, even though LinkedList has a get(index) method:
        // System.out.println(stack.get(1));

        System.out.println(stack.peek());
        System.out.println(stack.peek());
        
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}