package J_stack_queue_deque.B_queue.B_jcf;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class UsingJavaQueue {
    public static void main(String[] args) {
        // Queue<Integer> queue = new ArrayDeque<>();

        // or:
        Queue<Integer> queue = new LinkedList<>();

        // compiler will not let us call get, which is a good thing!
        // queue.get(0);
        // compiler will not let us call addFirst, which is a good thing!
        // queue.addFirst(11);

        for (int i = 5; i < 10; i++) {
            System.out.println("Adding " + i);
            queue.add(i); // or: queue.offer(i);
        }
        System.out.println("queue:          " + queue);
        System.out.println("Adding 7");
        queue.add(7);
        System.out.println("queue:          " + queue);
        System.out.println("queue.peek():   " + queue.peek());
        System.out.println("queue:          " + queue);
        System.out.println("queue.remove(): " + queue.remove());
        System.out.println("queue:          " + queue);
        System.out.println("queue.size():   " + queue.size());

        System.out.println("sum is " + sum(queue));

        while (!queue.isEmpty()) {
            System.out.println("queue.remove(): " + queue.remove());
        }
        System.out.println("queue:          " + queue);
    }

    // Return the sum of the elements in the given queue
    // Constraint: Do not use any auxiliary collections
    // (arrays, ArrayLists, etc.).
    // When the method terminates, the queue must be in the
    // same state that it was originally in.
    public static int sum(Queue<Integer> queue) {
        int sum = 0;

        for (int i = 0; i < queue.size(); i++) {
            int curr = queue.remove();
            sum += curr;
            queue.add(curr);
        }

        return sum;
    }
}