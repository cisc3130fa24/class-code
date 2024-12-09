package P_streams;

import java.util.*;
import java.util.stream.Collectors;

/*
A stream pipeline has three parts:
- source, such as a collection (a pipeline has exactly one)
- intermediate operations (as many as you want, even none)
- terminal operation (must have exactly one)

We use streams to construct a "pipeline" through which elements flow
- from the source
- through the intermediate operations
- to the terminal operation.

A stream does not modify the contents of the source.

Each intermediate operation returns a new Stream, so operations can be chained.

Intermediate operations: filter, map, mapToInt, distinct, sorted

Terminal operations: count, max, toList, average, sum, forEach, findAny, collect

The elements of a stream are not processed until a terminal operation is invoked.
At that point, the elements are generated, the intermediate operations are
performed, and the terminal operation returns a result.
This allows for the source of a stream to be potentially infinite.
For example, new Random().ints() creates an infinite stream. But no elements are
actually generated until the terminal operation is invoked. So, for example,
    new Random().ints().distinct().limit(10).boxed().toList()
creates a List<Integer> containing 10 distinct random integers, and it does not
take infinite time to complete.

Optional: an object that is either empty or contains a value.
Like a collection that contains at most 1 element.
Used as the return type of methods like max that can't always
return a value, since the stream might be empty.

Stream is a generic interface, so we can have Stream<String>, Stream<Person>, Stream<Integer>.

There are also primitive specializations for int, long and double: IntStream, LongStream, and DoubleStream.

To convert from IntStream to Stream<Integer> (for example) use the boxed() method of IntStream, which returns a Stream<Integer>.
To covert from a primitive stream to a Stream<T>, where T is any type, use the mapToObj intermediate operation.

To convert from Stream<T> (where T is String or Integer, etc.) to IntStream (for example) use the mapToInt method, which takes a function that maps objects of type T to ints.

Just as there are primitive specializations for Stream<Integer>, etc., so too are there
primitive specializations for Optional<Integer>: OptionalInt, OptionalLong, OptionalDouble


 */

public class StreamDemos {
    public static void main(String[] args) {
        List<String> strings = List.of(
                "chocolate", "coffee", "tea", "", "biscuit", "muffin", "doughnut", "tea", "cookie"
        );

        // count strings starting with 'c'
        long numStartingWithC = strings.stream() // Stream<String>
                .filter(s -> s.startsWith("c"))  // Stream<String>
                .count(); // long
        System.out.println("numStartingWithC = " + numStartingWithC);

        // find any longest string; print if present
        Optional<String> longestString = strings.stream() // Stream<String>
                .max(Comparator.comparing(String::length)); // Optional<String>
        longestString.ifPresent(System.out::println); // will print the max if there is one, otherwise does nothing

        // print any longest string, if present
        strings.stream()
                .max(Comparator.comparing(String::length))
                .ifPresent(System.out::println);

        // find any longest string starting with 'c'
        Optional<String> longestStringStartingWithC = strings.stream() // Stream<String>
                .filter(s -> s.startsWith("c")) // Stream<String>
                .max(Comparator.comparing(String::length));
        System.out.println(longestStringStartingWithC.orElse("no longest string starting with 'c' available"));

        // find length of the longest string
        OptionalInt lengthOfLongestString = strings.stream() // Stream<String>
                // .map(String::length) // Stream<Integer>, but we want to be able to call no-arg max method
                .mapToInt(String::length) // IntStream
                .max();
        System.out.println("lengthOfLongestString = " + lengthOfLongestString.orElseThrow());

        // get sorted list of distinct strings with length <= 6; then print the list
        List<String> shortDistinctSortedStrings = strings.stream()
                .filter(s -> s.length() <= 6)
                .distinct()
                .sorted()
                .toList();
        shortDistinctSortedStrings.forEach(System.out::println);

        // get average length of strings that start with 'c'
        OptionalDouble averageLengthOfStringsStartingWithC = strings.stream()
                .filter(s -> s.startsWith("c")) // Stream<String>
                .mapToInt(String::length)
                .average();
        averageLengthOfStringsStartingWithC.ifPresent(System.out::println);

        // count the number of characters used (including duplicates)
        long numCharactersIncludingDuplicates = strings.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("numCharactersIncludingDuplicates = " + numCharactersIncludingDuplicates);

        // print each distinct string
        strings.stream()
                .distinct()
                .forEach(System.out::println);

        // print number of distinct strings
        System.out.println("number of distinct strings: " + strings.stream().distinct().count());

        // print in uppercase each string starting with 'c'
        strings.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // print strings sorted by length, then alphabetically
        strings.stream()
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);

        // print any string of length 6. if there are multiple ones, print any;
        // if there are none, print nothing
        strings.stream()
                .filter(s -> s.length() == 6) // Stream<String>
                .findAny()
                .ifPresent(System.out::println);

        // get sorted list of distinct first characters of the strings
        List<Character> firstCharacters = strings.stream()
                .filter(s -> !s.isEmpty()) // Stream<String>, no empty Strings
                .map(s -> s.charAt(0))
                .distinct() // Stream<Character>, but without duplicates
                .sorted() // Stream<Character>, but now sorted
                .toList(); // List<Character>
        firstCharacters.forEach(System.out::println);

        // group the strings into lists by their lengths: have one List of Strings of length 0, another List of Strings of length 6, etc.
        Map<Integer, List<String>> map1 = strings.stream()
                .collect(Collectors.groupingBy(String::length));
        map1.forEach((len, wordList) -> System.out.println(len + ": " + wordList));

        // OPTIONAL:
        // group the strings into sets by their lengths
        Map<Integer, Set<String>> map2 = strings.stream().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        map2.forEach((len, wordSet) -> System.out.println(len + ": " + wordSet));

        // OPTIONAL:
        // create a map from string lengths to the number of strings of those lengths (for length 6 there are 3 strings, etc.)
        Map<Integer, Long> map3 = strings.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        map3.forEach((len, count) -> System.out.println(len + ": " + count));
    }
}
