package F_search_sort;

import java.util.Arrays;

/*
Merge sort: Repeatedly divides the array in half, sorts each half,
and combines the sorted halves into a sorted whole.

The algorithm:
- Divide the list into two roughly equal halves.
- Sort the left half.
- Sort the right half.
- Merge the two sorted halves into one sorted list.

Often implemented recursively. An example of a "divide and conquer" algorithm.
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] list = {14, 32, 67, 76, 23, 41, 58, 85};
        mergeSort(list);
    }

    public static void mergeSort(int[] a) {
        // System.out.println("sorting " + Arrays.toString(a));

        // implicit base case: if a.length <= 1, do nothing (already sorted)

        if (a.length > 1) {
            // split array into roughly two halves
            int[] left = Arrays.copyOfRange(a, 0, a.length / 2);
            int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);

            // recursively sort the two halves
            mergeSort(left);
            mergeSort(right);

            // merge the sorted halves into a
            merge(left, right, a);
        }
    }

    // merge sorted arrays arr1 and arr2 together,
    // putting the elements in the result array in sorted order
    public static void merge(int[] arr1, int[] arr2, int[] result) {
        // System.out.println("merging " + Arrays.toString(arr1) + " and " + Arrays.toString(arr2));

        int index1 = 0;      // current index in arr1
        int index2 = 0;      // current index in arr2
        int resultIndex = 0; // current index in result

        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] < arr2[index2]) {
                result[resultIndex++] = arr1[index1++];
            } else {
                result[resultIndex++] = arr2[index2++];
            }
        }

        while (index1 < arr1.length) {
            result[resultIndex++] = arr1[index1++];
        }

        while (index2 < arr2.length) {
            result[resultIndex++] = arr2[index2++];
        }
    }
}
