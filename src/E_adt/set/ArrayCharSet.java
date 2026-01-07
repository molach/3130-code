package E_adt.set;

/**
 * A CharSet whose elements are stored in an array;
 * the capacity is the array's length.
 */
public class ArrayCharSet implements CharSet {
    /*
    Representation: the characters are stored in an array.
    The capacity is the array's length.
    We store the size, which is usually less than the array's length.
    The elements are stored at indexes 0 through (size - 1).
    For example, if size is 3, the elements are stored at indexes 0, 1, and 2.
    We only care about what's at indexes 0 through (size - 1);
    we don't care about what's at index size and beyond.
    */

    private final char[] chars;
    private int size = 0;

    /**
     * Creates an empty set with the specified capacity.
     */
    public ArrayCharSet(int capacity) {
        chars = new char[capacity];
    }

    // O(n) due to the call contains(ch)
    @Override
    public boolean add(char ch) {
        if (isFull() || contains(ch)) {
            return false;
        } else {
            chars[size++] = ch;
            return true;
        }
    }

    // O(n) due to the call indexOf(ch)
    @Override
    public boolean remove(char ch) {
        int index = indexOf(ch);

        if (index < 0) {
            return false;
        } else {
            chars[index] = chars[size - 1]; // replace ch with the last character
            size--;

            /*
            Note 1: We just changed the order of the elements, but that's OK
            since order doesn't matter in a set.

            Note 2: The array now contains two occurrences of the same character:
            chars[index] == chars[size]. But that's OK since we only care about
            what's at indexes 0 through (size - 1).
            */

            return true;
        }
    }

    // O(n) due to the call indexOf(ch)
    @Override
    public boolean contains(char ch) {
        return indexOf(ch) >= 0;
    }

    // O(1)
    @Override
    public int size() {
        return size;
    }

    // O(1)
    @Override
    public int capacity() {
        return chars.length;
    }

    // O(n) (would be O(n^2) if we used String instead of StringBuilder)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");

        for (int i = 0; i < size; i++) {
            sb.append(chars[i]);
        }

        return sb.append("}").toString();
    }

    // O(n)
    private int indexOf(char ch) {
        for (int i = 0; i < size; i++) {
            if (chars[i] == ch) {
                return i;
            }
        }

        return -1;
    }
}