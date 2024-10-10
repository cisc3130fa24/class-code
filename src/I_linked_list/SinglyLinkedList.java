package I_linked_list;

/*
 Three cases to consider in most of the below methods:
 1. Immediately prior to the method being called, the list is empty.
    size == 0, head == null, tail == null
 2. Immediately prior to the method being called, the list contains exactly one element.
    size == 1, head == tail and head != null and tail != null
 3. Immediately prior to the method being called, the list contains more than one element.
    size > 1, head != tail and neither are null

 For some of these methods, we have to consider whether we are adding/removing a node:
 in the middle of the list, at the head, or at the tail.
 */

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this(data, null);
        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head, tail;
    private int size;

    public SinglyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E element) {
        head = new Node<>(element, head);
        size++;

        if (tail == null) {
            tail = head;
        }
    }

    public void addLast(E element) {
        if (isEmpty()) {
            addFirst(element);
        } else {
            tail = tail.next = new Node<>(element);
            size++;
        }
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("empty list");
        }

        return head.data;
    }

    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("empty list");
        }

        return tail.data;
    }
}
