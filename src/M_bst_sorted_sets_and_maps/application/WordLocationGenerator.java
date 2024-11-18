package M_bst_sorted_sets_and_maps.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;

public class WordLocationGenerator implements Iterable<WordLocation> {
    private final Queue<Character> characters = new ArrayDeque<>();

    public WordLocationGenerator(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));

        while (scanner.hasNextLine()) {
            for (char ch : scanner.nextLine().toCharArray()) {
                characters.add(ch);
            }

            characters.add('\n');
        }
    }

    public Iterator<WordLocation> iterator() {
        return new WordLocationIterator();
    }

    private class WordLocationIterator implements Iterator<WordLocation> {
        private WordLocation nextWordLocation;
        private int lineNumber = 1, columnNumber = 1;

        public WordLocationIterator() {
            findNextWordLocation();
        }

        @Override
        public boolean hasNext() {
            return nextWordLocation != null;
        }

        @Override
        public WordLocation next() {
            WordLocation result = nextWordLocation;
            findNextWordLocation();
            return result;
        }

        private void findNextWordLocation() {
            StringBuilder word = new StringBuilder();

            // skip non-letters
            while (!characters.isEmpty() && !Character.isLetter(characters.peek())) {
                if (characters.remove() == '\n') {
                    lineNumber++;
                    columnNumber = 1;
                } else {
                    columnNumber++;
                }
            }

            // read letters and add them to the word
            while (!characters.isEmpty() && Character.isLetter(characters.peek())) {
                word.append(characters.remove());
                columnNumber++;
            }

            if (word.isEmpty()) {
                nextWordLocation = null;
            } else {
                nextWordLocation = new WordLocation(word.toString(), new Location(lineNumber, columnNumber - word.length()));
            }
        }
    }
}

