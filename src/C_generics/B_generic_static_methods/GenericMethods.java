package C_generics.B_generic_static_methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericMethods {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "d", "e"};
        System.out.println("array: " + Arrays.toString(arr));
        System.out.println("middle element of array: " + middle(arr));

        Integer[] integers = {1, 2, 3, 4};
        System.out.println("integers: "
                           + Arrays.toString(integers));
        System.out.println("middle element of integers array: "
                           + middle(integers));

        List<String> stringList = new ArrayList<>(List.of("a", "b", "c", "d", "e"));
        System.out.println("original String list: " + stringList);

        swap(stringList, 0, 2);
        System.out.println("list after swapping the elements at indexes 0 and 2: "
                           + stringList);

        System.out.println("the index of String list's minimum element: "
                           + indexOfMin(stringList, 0));

        selectionSort(stringList);
        System.out.println("String list after sorting: " + stringList);

        List<String> strings = new ArrayList<>(List.of(
                "train", "car", "bus", "boat"
        ));
        System.out.println("original strings list: " + strings);
        selectionSort(strings);
        System.out.println("strings list after sorting: " + strings);
    }

    /**
     * Returns the element at the midpoint of arr (if arr.length is odd)
     * or the element right after the midpoint (if arr.length is even).
     */
    // we can pass to this method a String[] or an Integer[], for example
    // but not an int[] or double[]
    public static <E> E middle(E[] arr) {
        return arr[arr.length / 2];
    }

    /**
     * Swaps the element at index1 with the element at index2.
     */
    // we can pass an ArrayList<String> to this method, for example
    public static <E> void swap(List<E> list,
                                int index1, int index2) {
        E temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    /**
     * Returns the index of the minimum element that is at or after
     * startIndex.
     */
    public static <E extends Comparable<E>> int indexOfMin(List<E> list,
                                                           int startIndex) {
        int indexOfMin = startIndex;

        for (int i = startIndex + 1; i < list.size(); i++) {
            // if (list.get(i) < list.get(indexOfMin))
            if (list.get(i).compareTo(list.get(indexOfMin)) < 0) {
                indexOfMin = i;
            }
        }

        return indexOfMin;
    }

    /**
     * Sorts the list using selection sort.
     */
    public static <E extends Comparable<E>> void selectionSort(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            int indexOfMin = indexOfMin(list, i);
            if (indexOfMin != i) {
                swap(list, i, indexOfMin);
            }
        }
    }
  /*
  Approximately how many steps does selection sort require for a list of 
  size n?
  - We need to make n iterations of the loop in the selectionSort method.
  - In the first iteration, we need to search through all n elements of 
    the array to find the min, which takes about n steps.
  - In the second iteration, we need to search through n - 1 elements of 
    the array to find the min, which takes about n - 1 steps.
  - In the third iteration, we need to search through n - 2 elements of 
    the array to find the min, which takes about n - 2 steps.
  - And so on.
  - In each iteration, we need to search through n - i + 1 elements.
  - In total, we must perform approximately 
      = n + (n - 1) + (n - 2) + ... + (n - n + 1)
    steps.
  - Formula: 
        n + (n - 1) + (n - 2) + ... + (n - n + 1) 
      = (1/2)n^2 + (1/2)n.
  - Focusing on the term with the highest degree and ignoring the  
    multiplicative constant, we are left with n^2.
  - Thus we say that the running time of selection sort is O(n^2) 
    ["big-O of n squared"].
   */
}