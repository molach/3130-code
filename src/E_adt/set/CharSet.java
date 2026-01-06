
package E_adt.set;

/**
 * A set of characters, that is, a collection of characters without duplicates.
 * The order of the characters is unspecified.
 */
public interface CharSet {
    /**
     * Attempts to add ch to this CharSet. If successful, returns true.
     * Returns false if this CharSet already contains ch, or if is full to capacity.
     */
    boolean add(char ch);

    /**
     * Returns false if this CharSet does not contain ch. Otherwise, removes ch
     * and returns true.
     */
    boolean remove(char ch);

    /**
     * Determines whether this CharSet contains ch.
     */
    boolean contains(char ch);

    /**
     * Returns the number of characters currently in this set.
     */
    int size();

    /**
     * Returns the number of characters that this set can hold at once.
     */
    int capacity();

    /**
     * Returns a String of the form {chars} containing all the characters in the set.
     */
    @Override String toString();

    /**
     * Determines whether the set is full.
     */
    default boolean isFull() {
        return size() == capacity();
    }
}
