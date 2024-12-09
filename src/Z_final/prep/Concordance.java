package Z_final.prep;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.SequencedSet;
import java.util.SortedMap;
import java.util.TreeMap;

public class Concordance {
    private final SortedMap<String, SequencedSet<Integer>> map = new TreeMap<>();
    // Note 1. To store the line numbers, we use a set instead of a list, since we don't want to store the same line number multiple times for one token, even if the token appears multiple times on the same line.
    // Note 2. Instead of SequencedSet and LinkedHashSet (created below in the constructor), we could have used SortedSet and TreeSet.

    public Concordance(String filename) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(filename));
        int lineNumber = 1;

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);

            while (lineScanner.hasNext()) {
                String token = lineScanner.next();

                if (!map.containsKey(token)) {
                    map.put(token, new LinkedHashSet<>());
                }

                map.get(token).add(lineNumber);
            }

            lineNumber++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (var entry : map.entrySet()) {
            String token = entry.getKey();
            sb.append(token).append(": ");

            SequencedSet<Integer> lineNumbers = entry.getValue();

            for (Iterator<Integer> iterator = lineNumbers.iterator(); iterator.hasNext(); ) {
                sb.append(iterator.next());

                if (iterator.hasNext()) {
                    sb.append(" ");
                }
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}
