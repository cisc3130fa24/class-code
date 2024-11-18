package M_bst_sorted_sets_and_maps.application;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.SequencedSet;
import java.util.SortedMap;
import java.util.TreeMap;

public class Concordance {
    private final String filename;
    private final SortedMap<String, SequencedSet<WordLocation>> map;

	public Concordance(String filename) throws FileNotFoundException {
		this(filename, Comparator.naturalOrder());
	}

	public Concordance(String filename, Comparator<String> comparator) throws FileNotFoundException {
		this.filename = filename;
		this.map = new TreeMap<>(comparator);
        build();
	}

	private void build() throws FileNotFoundException {
		WordLocationGenerator generator = new WordLocationGenerator(filename);
	
		for (WordLocation wordLocation : generator) {
            String word = wordLocation.word();

            if (!map.containsKey(word)) {
                map.put(word, new LinkedHashSet<>());
            }

            map.get(word).add(wordLocation);
		}
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (var entry : map.entrySet()) {
            String word = entry.getKey();
            SequencedSet<WordLocation> wordLocations = entry.getValue();

            sb.append(word).append(": ");

            for (Iterator<WordLocation> iterator = wordLocations.iterator(); iterator.hasNext(); ) {
                WordLocation wordLocation = iterator.next();
                sb.append(wordLocation.location());

                if (iterator.hasNext()) {
                    sb.append(", ");
                }
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}