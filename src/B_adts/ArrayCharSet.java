package B_adts;

public class ArrayCharSet implements CharSet {
    private char[] chars;
    private int size;

    /**
     * Creates a set of characters with the specified capacity.
     * @param capacity the number of characters that this set can hold at one time
     */
    public ArrayCharSet(int capacity) {
        chars = new char[capacity];
        size = 0;
    }

    /**
     * {@inheritDoc}
     *
     * This implementation also returns false if the set is full.
     */
    @Override
    public boolean add(char ch) {
        if (size == chars.length || contains(ch)) {
            return false;
        } else {
            chars[size] = ch;
            size++;
            return true;
        }
    }

    @Override
    public boolean remove(char ch) {
        int index = indexOf(ch);

        if (index < 0) {
            return false;
        } else {
            for (int i = index; i < size - 1; i++) {
                chars[i] = chars[i + 1];
            }

            size--;
            return true;
        }
    }

    @Override
    public boolean contains(char ch) {
        return indexOf(ch) >= 0;
    }

    private int indexOf(char ch) {
        for (int i = 0; i < size; i++) {
            if (chars[i] == ch) {
                return i;
            }
        }

        return -1;
    }

    /**
     * @return the capacity of this set
     */
    public int capacity() {
        return chars.length;
    }
}
