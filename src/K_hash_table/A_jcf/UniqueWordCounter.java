package K_hash_table.A_jcf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueWordCounter {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("words.txt"));
        Set<String> uniqueWords = new HashSet<>();
        
        while (scanner.hasNext()) {
            String word = scanner.next();
            uniqueWords.add(word);
        }

        System.out.println("Number of unique words: " + uniqueWords.size());
    }
}