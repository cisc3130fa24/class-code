package F_search_sort;

public class QuickSort {
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(arr, first, last);
            quickSort(arr, first, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, last);
        }
    }

    // Chooses a pivot element and partitions arr around that element:
    // all elements less than the pivot will be placed to the left of the pivot,
    // and all elements greater than or equal to the pivot will be placed to the right of the pivot.
    // There are many ways to accomplish this; here we are using
    // a relatively easy approach, though not the most efficient one.
    // The method returns the index of the pivot element.
    public static int partition(int[] arr, int low, int high) {
        // choose the pivot element (we're choosing the first element here,
        // but other approaches choose the last, the middle, or even a random element)
        int pivot = arr[low];

        // count how many elements are less than the pivot
        int count = 0;
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] < pivot) {
                count++;
            }
        }

        // move pivot to its proper place
        int pivotIndex = low + count;
        swap(arr, pivotIndex, low);

        // now rearrange elements around the pivot
        int i = low, j = high;
        while (i < pivotIndex && j > pivotIndex) {
            if (arr[i] < pivot) {
                i++;
            } else if (arr[j] >= pivot) {
                j--;
            } else {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        return pivotIndex;
    }

    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
