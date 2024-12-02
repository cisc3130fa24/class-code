package O_lambdas;

import java.util.Arrays;
import java.util.Comparator;

/*
The Comparator interface is a functional interface. It has
many non-abstract methods, but only two abstract methods,
one of which is the equals method (which doesn't count,
since it's found in the Object class). A lambda expression
that is an instance of Comparator is a function that has
the ability to compare two objects and determine their order.
*/
public class BasicComparatorDemo {
    public static void main(String[] args) {
        String[] arr = {"rabbit", "dog", "baboon", "eagle", "hamster", "bat", "cat"};

        System.out.println("original array: " + Arrays.toString(arr));

        /*
         Create a Comparator using a lambda expression.
         Java knows that Comparator is a functional interface whose
         only abstract method (except for the equals method) is named compare.
         So Java uses the lambda expression to implement the
         compare method.
         */

        /*
         Comparator<String> byLength = (String s1, String s2) -> {
             if (s1.length() > s2.length()) {
                 return 99;
             } else if (s1.length() < s2.length()) {
                 return -67;
             } else {
                 return 0;
             }
         };
         */

        // Comparator<String> byLength = (String s1, String s2) -> {
        //     return Integer.compare(s1.length(), s2.length());
        // };

        /*
        Since the type of our byLength variable is
        Comparator<String> Java can infer the parameter types
        for the method, so we don't need to explicitly state them.

        Additionally, when a lambda expression consists of a
        single statement, Java lets us omit the word
        "return" as well as the curly braces around the body.
        */

        // Comparator<String> byLength = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        // Arrays.sort(arr, byLength); // uses byLength to order the elements
        // System.out.println("sorted by length: " + Arrays.toString(arr));

        // Using the Comparator.comparing(Function keyExtractor) method to create the byLength
        // Comparator<String> byLength = Comparator.comparing(s -> s.length());
        // Now with a method reference instead of a lambda expression:
        // Comparator<String> byLength = Comparator.comparing(String::length);
        // Arrays.sort(arr, byLength);
        // System.out.println("sorted by length: " + Arrays.toString(arr));

        // Using the thenComparing(Comparator other) method
        Comparator<String> byLengthThenAlphabetically =
                Comparator.comparing(String::length).thenComparing(String::compareTo);
        Arrays.sort(arr, byLengthThenAlphabetically);
        System.out.println("sorted by length then alphabetically: " + Arrays.toString(arr));
    }
}