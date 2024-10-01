package G_complexity;

import java.util.List;
import java.util.ArrayList;

public class BigOhExamples {
    public static void main(String[] args) {

    }

    // O(1)
    public static void m1(int n) {
        int sum = 0;
        for (int i = 0; i < 100_000; i++) { // 100,000 times
            sum++;
        }
        System.out.println(sum);
    }

    // O(n)
    public static void m2(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) { // n times
            sum++;
        }
        System.out.println(sum);
    }

    // 1 + n^2 + 100,000n + 1
    // O(n^2)
    public static void m3(int n) {
        int sum = 0;
        for (int i = 0; i < n * n; i++) { // n^2 times
            sum++;
        }

        for (int i = 0; i < 100_000 * n; i++) { // 100,000*n
            sum++;
        }

        System.out.println(sum);
    }

    // 1 + (n^2)*100,000*n + 1
    // O(n^3)
    public static void m4(int n) {
        int sum = 0;
        for (int i = 0; i < n * n; i++) { // n^2 times
            for (int j = 0; j < 100_000 * n; j++) { // 100,000*n times
                sum++;
            }
        }

        System.out.println(sum);
    }

    // O(n^3)
    public static void m5(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * n; j++) {
                sum++;
            }
        }
        System.out.println(sum);
    }

    /*
    How many times does sum++ run in method m6?
      1 + 2 + 3 + 4 + .... + n
    = (1/2)n^2 + (1/2)n
    which is O(n^2)
    */
    public static void m6(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                sum++;
            }
        }
        System.out.println(sum);
    }

    // (2n-2)(n+4) = c1*n^2 + c2*n + c3
    // O(n^2)
    public static void m7(int n) {
        int sum = 0;
        for (int i = 1; i <= 2 * n - 2; i++) { // 2n-2 times
            for (int j = 1; j <= n + 4; j++) { // n+4 times
                sum++;
            }
        }
        System.out.println(sum);
    }

    /*
    Formula:
      1 + 2 + 3 + 4 + 5 + .... + n
    = (1/2)n^2 + (1/2)n

    How many times does sum++ run in method m8?
      5 + 6 + 7 + ... + (n-3)+4 + (n-2)+4
    = 5 + 6 + 7 + ... + (n+1) + (n+2)
    = (1 + 2 + 3 + 4 + 5 + .... + n) - (1 + 2 + 3 + 4) + (n+1) + (n+2)
    = (1/2)n^2 + (1/2)n - 10 + (n+1) + (n+2)
    which is O(n^2)
    */
    public static void m8(int n) {
        int sum = 0;
        for (int i = 1; i <= n - 2; i++) {
            for (int j = 1; j <= i + 4; j++) {
                sum++;
            }
        }
        System.out.println(sum);
    }

    /*
    Running times of ArrayList methods and constructor:
    - new ArrayList(): O(1)
    - get(int index): O(1)
    - add(E element): O(1)
    - add(int index, E element): O(n)
    - remove(Object o): O(n)
    - remove(int index): O(n)
    where n is the size of the ArrayList.
    */
    // n + n*(n + n) = 2n^2 + n
    // O(n^2)
    public static void m9(int n) {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < n; i++) { // n times
            list1.add(i); // constant time
        }

        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) { // n times
            list2.add(0, list1.get(0)); // linear time
            list1.remove(0); // linear time
        }
    }

    /*
    approximately log base 3 of n
    which is O(log n)
    */
    public void m10(int n) {
        while (n > 1) {
            System.out.println(n);
            n = n / 3;
        }
    }

    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int indexOfMin = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[indexOfMin]) {
                    indexOfMin = j;
                }
            }

            swap(a, i, indexOfMin);
        }
    }

    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    /*
    Approximately how many steps does selection sort require for an
    array of length n?
    - We need to make n - 1 iterations (passes) of the outer loop.
    - In the first pass, we need to search through all n elements of
      the array to find the min, which takes about n steps.
    - In the second pass, we need to search through n - 1 elements of
      the array to find the min, which takes about n - 1 steps.
    - In the third pass, we need to search through n - 2 elements of
      the array to find the min, which takes about n - 2 steps.
    - And so on.
    - In each pass, we need to search through n - i elements to find the min.
    - In total, we must perform approximately
        n + (n - 1) + (n - 2) + ... + 2 + 1
      steps.
    - Formula:
        1 + 2 + 3 + ... + n = (1/2)n(n + 1) = (1/2)n^2 + (1/2)n.
    - Focusing on the term with the highest degree and ignoring the
      multiplicative constant, we are left with n^2.
    - Thus we say that the running time of selection sort is O(n^2)
      ["big-O of n squared"].
    */
}