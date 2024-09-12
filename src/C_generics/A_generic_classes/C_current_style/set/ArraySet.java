package C_generics.A_generic_classes.C_current_style.set;

import java.util.Objects;

// a generic class that implements a generic interface
public class ArraySet<E> implements Set<E> {
    private final E[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public ArraySet(int capacity) {
        elements = (E[]) new Object[capacity];
        size = 0;
    }

    @Override
    public boolean add(E e) {
        if (isFull() || contains(e)) {
            return false;
        } else {
            elements[size] = e;
            size++;
            return true;
        }
    }

    private boolean isFull() {
        return size == elements.length;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);

        if (index < 0) {
            return false;
        } else {
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }

            size--;
            return true;
        }
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    private int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
