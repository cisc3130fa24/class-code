package K_hash_table.A_jcf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class Name {
    private final String first, last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public String toString() {
        return first + " " + last;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Name other) {
            return this.first.equals(other.first) && this.last.equals(other.last);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }
}

// try running this program with Name's hashCode method commented out
public class HashCodeEffectDemo {
    public static void main(String[] args) {
        Set<Name> set = new HashSet<>();
        set.add(new Name("Jane", "Doe"));
        System.out.println("set = " + set);
        System.out.println("set contains Jane Doe? " +
                           set.contains(new Name("Jane", "Doe")));
        set.add(new Name("Jane", "Doe"));
        System.out.println("set = " + set);
        System.out.println();

        Map<Name, Integer> map = new HashMap<>();
        map.put(new Name("Jane", "Doe"), 4);
        System.out.println("map = " + map);
        System.out.println("map contains key Jane Doe? " +
                           map.containsKey(new Name("Jane", "Doe")));
        map.put(new Name("Jane", "Doe"), 10);
        System.out.println("map = " + map);
    }
}