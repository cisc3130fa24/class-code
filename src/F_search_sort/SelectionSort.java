package F_search_sort;

/*
Selection sort: orders a list of values by repeatedly putting
the smallest unplaced value into its final position.

The algorithm:
- Look through the list to find the smallest value.
- Swap it so that it is at index 0.

- Look through the list to find the second-smallest value.
- Swap it so that it is at index 1.

- ...

- Repeat until all values are in their proper places.
 */

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {12, 123, 1, 28, 183, 16};
        System.out.println("Before: " + Arrays.toString(nums));
        selectionSort(nums);
        System.out.println("After: " + Arrays.toString(nums));
    }

    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            // find index of smallest remaining value
            int indexOfMin = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[indexOfMin]) {
                    indexOfMin = j;
                }
            }

            // swap smallest value to its proper place, a[i]
            swap(a, i, indexOfMin);

            // System.out.println("After pass " + (i + 1) + ": " + Arrays.toString(a));
        }
    }

    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
