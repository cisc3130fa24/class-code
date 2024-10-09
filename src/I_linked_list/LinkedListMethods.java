package I_linked_list;

import java.util.ArrayList;
import java.util.List;

public class LinkedListMethods {
    public static void main(String[] args) {
        // one way to build a list
        ListNode<String> head1 = new ListNode<>("A", new ListNode<>("B", new ListNode<>("C")));

        // an empty list
        ListNode<String> head2 = null;

        // another way to build a list
        ListNode<Integer> head3 = new ListNode<>(1);
        head3.next = new ListNode<>(2);
        head3.next.next = new ListNode<>(3);
        head3.next.next.next = new ListNode<>(4);

        printIteratively(head1); // A B C 
        printIteratively(head2); // 
        printIteratively(head3); // 1 2 3 4

        printReversedRecursively(head1); // C B A
    }

    // time: O(n)
    // space: O(1)
    public static <E> void printIteratively(ListNode<E> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // time: O(n)
    // space: O(n)
    public static <E> void printRecursively(ListNode<E> head) {
        if (head != null) {
            System.out.print(head.data + " ");
            printRecursively(head.next);
        }
    }

    // time: O(n)
    // space: O(1)
    public static <E> int getSizeIteratively(ListNode<E> head) {
        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }

    // time: O(n)
    // space: O(n)
    public static <E> int getSizeRecursively(ListNode<E> head) {
        if (head == null) {
            return 0;
        } else {
            return 1 + getSizeRecursively(head.next);
        }
    }

    // time: O(n)
    // space: O(n)
    public static <E> void printReversedIteratively(ListNode<E> head) {
        List<E> aux = new ArrayList<>();

        while (head != null) {
            aux.add(head.data);
            head = head.next;
        }

        for (int i = aux.size() - 1; i >= 0; i--) {
            System.out.print(aux.get(i) + " ");
        }
    }

    // time: O(n)
    // space: O(n)
    public static <E> void printReversedRecursively(ListNode<E> head) {
        if (head != null) {
            printReversedRecursively(head.next);
            System.out.print(head.data + " ");
        }
    }

    // time: O(1)
    // space: O(1)
    public static <E> E getFirst(ListNode<E> head) {
        if (head == null) {
            throw new IllegalStateException("empty list");
        } else {
            return head.data;
        }
    }

    // time: O(n)
    // space: O(1)
    public static <E> E getLastIteratively(ListNode<E> head) {
        if (head == null) {
            throw new IllegalStateException("empty list");
        }

        ListNode<E> current = head;

        while (current.next != null) {
            current = current.next;
        }

        return current.data;
    }

    // time: O(n)
    // space: O(n)
    public static <E> E getLastRecursively(ListNode<E> head) {
        if (head == null) {
            throw new IllegalStateException("empty list");
        }

        if (head.next == null) {
            return head.data;
        } else {
            return getLastRecursively(head.next);
        }
    }

    // time: O(1)
    // space: O(1)
    public static <E> ListNode<E> addFirst(ListNode<E> head, E element) {
        return new ListNode<>(element, head);
    }

    // time: O(n)
    // space: O(1)
    public static <E> ListNode<E> addLastIteratively(ListNode<E> head, E element) {
        if (head == null) {
            return new ListNode<>(element);
        }

        ListNode<E> curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = new ListNode<>(element);
        return head;
    }

    // time: O(n)
    // space: O(n)
    public static <E> ListNode<E> addLastRecursively(ListNode<E> head, E element) {
        if (head == null) {
            return new ListNode<>(element);
        } else {
            head.next = addLastRecursively(head.next, element);
            return head;
        }
    }
}