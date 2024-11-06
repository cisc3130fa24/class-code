package K_hash_table.A_jcf;

import java.util.*;

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
    /*
    Recall that a hashCode() method must return equal results for equal objects.
    If this rule is violated, and objects of the class are used as elements of a
    (Linked)HashSet or as the keys of a (Linked)HashMap,
    the HashSet and HashMap will not work correctly.

    Additionally, a good hashCode() method endeavors to return unequal results
    for unequal objects. If this isn't followed, HashSet and HashMap will work
    correctly, but slowly (O(n) instead of O(1)).
     */
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