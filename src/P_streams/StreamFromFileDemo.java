package P_streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class StreamFromFileDemo {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("input.txt");
        Files.lines(path)
                .filter(line -> line.startsWith("The"))
                .max(Comparator.comparing(String::length))
                .ifPresent(System.out::println);

        System.out.println("all lines: ");
        Files.lines(path).forEach(System.out::println);
    }
}
