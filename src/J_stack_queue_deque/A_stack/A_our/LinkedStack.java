package J_stack_queue_deque.A_stack.A_our;

import I_linked_list.SinglyLinkedList;

/**
 * Implementation of the Stack ADT by adapting a singly-linked list.
 * O(1) time for all Stack operations.
 */
public class LinkedStack<E> implements Stack<E> {
    private SinglyLinkedList<E> list; // stores the elements of the stack

    public LinkedStack() {
        list = new SinglyLinkedList<>();
    }

    @Override
    public int size() {
        return list.size();
    }
    // O(1)

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    // O(1)

    @Override
    public void push(E element) {
        list.addFirst(element);
    }
    // O(1)

    @Override
    public E peek() {
        return list.getFirst();
    }
    // O(1)

    @Override
    public E pop() {
        return list.removeFirst();
    }
    // O(1)

    /**
     * Produces a string representation of the stack (ordered from top to bottom)
     */
    @Override
    public String toString() {
        return "top " + list.toString() + " bottom";
    }
    // O(n)
}
