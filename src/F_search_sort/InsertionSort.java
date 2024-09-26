package F_search_sort;

/*
insertion sort: shift each element into a sorted sub-array at the front of the array
 */

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1, 9, 4, 6, 5, -4};
        insertionSort(arr);
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = current;
        }
    }
}
