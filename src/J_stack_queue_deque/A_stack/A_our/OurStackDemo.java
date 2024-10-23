package J_stack_queue_deque.A_stack.A_our;

public class OurStackDemo {
    public static void main(String[] args) {
                                                    // contents     output
        Stack<Integer> stack = new ArrayStack<>();  // []
        stack.push(5);                              // [5]
        stack.push(3);                              // [3, 5]
        System.out.println(stack);                  // [3, 5]       top [3, 5] bottom
        System.out.println(stack.size());           // [3, 5]       2
        System.out.println(stack.pop());            // [5]          3
        System.out.println(stack.isEmpty());        // [5]          false
        System.out.println(stack.pop());            // []           5
        System.out.println(stack.isEmpty());        // []           true
        stack.push(7);                              // [7]
        stack.push(3);                              // [3, 7]
        System.out.println(stack.peek());           // [3, 7]       3
        stack.push(4);                              // [4, 3, 7]
        System.out.println(stack.size());           // [4, 3, 7]    3
        System.out.println(stack.pop());            // [3, 7]       4
        stack.push(6);                              // [6, 3, 7]
        stack.push(8);                              // [8, 6, 3, 7]
        System.out.println(stack.pop());            // [6, 3, 7]    8
        System.out.println(stack);                  // [6, 3, 7]    top [6, 3, 7] bottom
    }
}
