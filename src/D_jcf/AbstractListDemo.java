package D_jcf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

// A list where all the elements have the same value.
// Most of the List methods are implemented by AbstractList.
// This class doesn't need to actually store the elements anywhere.
class ConstantList<E> extends AbstractList<E> implements List<E> {
    private final int size;
    private final E value;

    public ConstantList(int size, E value) {
        this.size = size;
        this.value = value;
    }

    @Override
    public E get(int index) {
        return value;
    }

    @Override
    public int size() {
        return size;
    }
}

// Another example of a class that implements AbstractList.
class RandomIntegerList extends AbstractList<Integer> implements List<Integer> {
    private final int size;
    private final Random generator;

    public RandomIntegerList(int size) {
        this.size = size;
        generator = new Random();
    }

    @Override
    public Integer get(int index) {
        return generator.nextInt();
    }

    @Override
    public int size() {
        return size;
    }
}

public class AbstractListDemo {
    public static void main(String[] args) {
        List<String> allA = new ConstantList<>(5, "a");
        System.out.println(allA); // [a, a, a, a, a]
        System.out.println(allA.contains("a")); // true
        System.out.println(allA.contains("b")); // false
        // contains is implemented by AbstractCollection

        List<Integer> indexMultipleList = getIndexMultipleList(10, 3);

        Iterator<Integer> iter = indexMultipleList.iterator();
        // iterator() is implemented by AbstractList on top of our get and size methods

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    // Returns a List<Integer> of the specified size, where the element at index i
    // is equal to i multiplied by the provided multiple.
    public static List<Integer> getIndexMultipleList(int size, int multiple) {
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return index * multiple;
            }

            @Override
            public int size() {
                return size;
            }
        };
    }
}
