package Z_final.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMultiset<E> implements Multiset<E> {
    private final Map<E, Integer> elementCounts = new HashMap<>();
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E element) {
        elementCounts.put(element, elementCounts.getOrDefault(element, 0) + 1);
        size++;
    }

    @Override
    public void add(E element, int occurrences) throws IllegalArgumentException {
        if (occurrences < 0) {
            throw new IllegalArgumentException("negative number of occurrences");
        }

        // if occurrences == 0, do nothing

        if (occurrences > 0) {
            elementCounts.put(element, elementCounts.getOrDefault(element, 0) + occurrences);
            size += occurrences;
        }
    }

    @Override
    public boolean contains(E element) {
        return count(element) > 0;
    }

    @Override
    public int count(E element) {
        return elementCounts.getOrDefault(element, 0);
    }

    @Override
    public boolean remove(E element) {
        int count = count(element);

        if (count == 0) {
            return false;
        }

        if (count == 1) {
            elementCounts.remove(element);
        } else {
            elementCounts.put(element, count - 1);
        }

        size--;
        return true;
    }

    @Override
    public int removeAllOccurrences(E element) {
        int count = count(element);
        elementCounts.remove(element);
        size -= count;
        return count;
    }

    @Override
    public int remove(E element, int occurrences) throws IllegalArgumentException {
        if (occurrences < 0) {
            throw new IllegalArgumentException("negative number of occurrences");
        }

        int count = count(element);

        if (occurrences >= count) {
            removeAllOccurrences(element); // also decreases size
        } else {
            elementCounts.put(element, count - occurrences);
            size -= occurrences;
        }

        return count;
    }

    @Override
    public Iterator<E> iterator() {
        List<E> elements = new ArrayList<>();

        for (var entry : elementCounts.entrySet()) {
            E element = entry.getKey();
            int count = entry.getValue();

            for (int i = 0; i < count; i++) {
                elements.add(element);
            }
        }

        return elements.iterator();
    }

    @Override
    public Set<E> elementSet() {
        return elementCounts.keySet();
    }
}