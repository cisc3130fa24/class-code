package P_streams;

import java.util.Random;

public class InfiniteStreamDemo {
    public static void main(String[] args) {
        Random rand = new Random();

        // rand.ints().forEach(System.out::println); // runs forever

        int[] arr = rand.ints()
                .distinct()
                .filter(i -> i % 2 == 0)
                .limit(10)
                .toArray();


    }
}
