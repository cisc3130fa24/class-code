package N_heap;

import java.util.Arrays;
import java.util.Comparator;

public class HeapSort {
    public static <E extends Comparable<E>> void heapSort(E[] list) {
        heapSort(list, Comparator.naturalOrder());
    }

    public static <E> void heapSort(E[] list, Comparator<E> c) {
        MaxHeap<E> heap = new MaxHeap<>(c);

        // Add elements to the heap: O(n log n)
        for (E e : list) {
            heap.add(e);
        }

        // Remove elements from the heap: O(n log n)
        for (int i = list.length - 1; i >= 0; i--) {
            list[i] = heap.remove();
        }
    }
    // overall running time: O(n log n)

    public static void main(String[] args) {
        Integer[] arr = {-44, 3, 3, 1, -4, 0, 1, 4, 2, 5};
        System.out.println("original array: " + Arrays.toString(arr));

        heapSort(arr);
        System.out.println("after sorting using natural order: " + Arrays.toString(arr));

        heapSort(arr, Comparator.reverseOrder());
        System.out.println("after sorting using reverse of natural order: " + Arrays.toString(arr));
    }
}
