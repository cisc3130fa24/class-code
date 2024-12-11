package P_streams;

import java.util.List;

public class ReduceDemo {
    public static void main(String[] args) {
        List<Integer> list = List.of(5, 3, 2, 4, 1, 7, 9);
        int sum = list.stream()              // 5, 3, 2, 4, 1, 7, 9
                .filter(i -> i % 2 != 0)     // 5, 3, 1, 7, 9
                .reduce(0, (a, b) -> a + b); // 25
        System.out.println(sum);

        int product = list.stream()
                .filter(i -> i % 2 != 0)
                .reduce(1, (a, b) -> a * b);
        System.out.println(product);

        int result = list.stream()
                .filter(i -> i % 2 != 0) // 5, 3, 1, 7, 9
                .reduce(2, (a, b) -> a * 3 + b);
        // ((((2 * 3 + 5) * 3 + 3) * 3 + 1) * 3 + 7) * 3 + 9
        System.out.println(result);
    }
}
