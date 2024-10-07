package H_array_list;

import java.util.Objects;

public class ArrayList<E> implements List<E> {
    private E[] elements;
    private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 10;

    public ArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int initialCapacity) {
        elements = (E[]) new Object[initialCapacity];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E e) {
        add(size, e);
        return true;
    }

    @Override
    public void add(int index, E element) {
        Objects.checkIndex(index, size + 1);

        // TODO
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        return elements[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("]");

        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);

            if (i < size - 1) {
                sb.append(", ");
            }
        }

        return sb.append("]").toString();
    }
}
