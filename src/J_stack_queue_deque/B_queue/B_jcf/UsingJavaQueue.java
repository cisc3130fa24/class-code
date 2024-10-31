package J_stack_queue_deque.B_queue.B_jcf;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/*
Java Queue methods

                Throws exception	Returns special value
    Insert	    add(e)	            offer(e)
    Remove	    remove()	        poll()
    Examine	    element()	        peek()

    size(), isEmpty(), and more

Two primary implementations of Deque in the JCF: LinkedList and ArrayDeque.
For both of these implementations, all the methods listed above run in O(1) time.
 */
public class UsingJavaQueue {
    public static void main(String[] args) {
        // Queue<String> queue = new ArrayDeque<>();

        // or:
        Queue<String> queue = new LinkedList<>();

        // compiler will not let us call get, which is a good thing!
        // queue.get(0);
        // compiler will not let us call addFirst, which is a good thing!
        // queue.addFirst("a");

        queue.add("a"); // or: queue.offer("a")
        queue.add("b");
        queue.add("c");

        System.out.println(queue.peek()); // or: queue.element()
        System.out.println(queue.peek());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove()); // or: queue.poll()
        }
    }
}