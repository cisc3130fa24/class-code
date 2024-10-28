package J_stack_queue_deque.B_queue.A_our;

import java.util.NoSuchElementException;

/**
 * Implementation of the queue ADT by using a circular array, aka a ring buffer.
 */
public class ArrayQueue<E> implements Queue<E> {
    private E[] elements;
    private int indexOfFirst;
    private int indexOfLast;
    private static final int DEFAULT_INITIAL_CAPACITY = 10;

    public ArrayQueue() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }

        elements = (E[]) new Object[initialCapacity];
        indexOfFirst = indexOfLast = -1;
    }

    public int size() {
        if (indexOfFirst == -1 && indexOfLast == -1) {
            return 0;
        } else {
            return (indexOfLast - indexOfFirst + elements.length + 1) % elements.length;
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private boolean isFull() {
        return size() == capacity();
    }

    private int capacity() {
        return elements.length;
    }

    public void enqueue(E element) {
        if (isFull()) {
            ensureCapacity(2 * capacity() + 1);
        }

        if (isEmpty()) { // set front and rear to the start on first enqueue
            indexOfFirst = 0;
        }

        indexOfLast = (indexOfLast + 1) % elements.length;
        // equivalent to:
        // indexOfLast++;
        // if (indexOfLast == elements.length) indexOfLast = 0;

        elements[indexOfLast] = element;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        E result = elements[indexOfFirst];
        elements[indexOfFirst] = null; // optional

        if (indexOfFirst == indexOfLast) { // queue becomes empty after this dequeue
            indexOfFirst = indexOfLast = -1;
        } else {
            indexOfFirst = (indexOfFirst + 1) % elements.length;
            // equivalent to:
            // indexOfFirst++;
            // if (indexOfFirst == elements.length) indexOfFirst = 0;
        }

        return result;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return elements[indexOfFirst];
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int desiredCapacity) {
        if (capacity() < desiredCapacity) {
            E[] newArray = (E[]) new Object[desiredCapacity];

            for (int i = 0; i < size(); i++) {
                newArray[i] = elements[(indexOfFirst + i) % elements.length];
            }

            elements = newArray;
            int currentSize = size();
            indexOfFirst = 0;
            indexOfLast = currentSize - 1;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < size(); i++) {
            sb.append(elements[(indexOfFirst + 1) % elements.length]);

            if (i < size()) {
                sb.append(", ");
            }
        }

        return sb.append("]").toString();
    }
}