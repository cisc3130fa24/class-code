package F_search_sort;

import java.util.Comparator;

public class GenericSelectionSort {
    public static <E extends Comparable<E>> void selectionSort(E[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            // find index of smallest remaining value
            int indexOfMin = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[indexOfMin]) < 0) {
                    indexOfMin = j;
                }
            }

            // swap smallest value to its proper place, a[i]
            swap(a, i, indexOfMin);
        }
    }

    private static <E> void swap(E[] list, int i, int j) {
        E temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static <E> void selectionSort(E[] a, Comparator<? super E> comparator) {
        for (int i = 0; i < a.length - 1; i++) {
            // find index of smallest remaining value
            int indexOfMin = i;

            for (int j = i + 1; j < a.length; j++) {
                if (comparator.compare(a[j], (a[indexOfMin])) < 0) {
                    indexOfMin = j;
                }
            }

            // swap smallest value to its proper place, a[i]
            swap(a, i, indexOfMin);
        }
    }
}
