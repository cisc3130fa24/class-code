package G_complexity;

// comparing running times of selection sort and quick sort

import F_search_sort.QuickSort;
import F_search_sort.SelectionSort;

import java.util.Random;
import java.util.Arrays;

public class SortingExperiment {
    public static void main(String[] args) {
        testSorts(10_000);
        testSorts(100_000);
    }

    public static void testSorts(int n) {
        System.out.print("using selection sort,   ");
        int[] arr = getRandomArray(n);
        long startTime = System.currentTimeMillis();
        SelectionSort.selectionSort(arr);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        System.out.printf("n: %,12d took %,12d milliseconds%n", n, elapsed);

        System.out.print("using quick sort,       ");
        arr = getRandomArray(n);
        startTime = System.currentTimeMillis();
        QuickSort.quickSort(arr);
        endTime = System.currentTimeMillis();
        elapsed = endTime - startTime;
        System.out.printf("n: %,12d took %,12d milliseconds%n", n, elapsed);
    }

    public static int[] getRandomArray(int length) {
        Random random = new Random();
        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }

        return arr;
    }
}