package F_generics.A_generic_types.set;

/**
 * A set of elements, that is, a collection of elements without duplicates.
 * The order of the elements is unspecified.
 */
public interface MySet<E> { // a generic interface
    /**
     * Attempts to add e to this set. Returns false if this set already
     * contains e, or if the set is full to capacity.
     * @param e the object to add
     * @return true if successfully added, false otherwise
     */
    boolean add(E e);

    /**
     * Attempts to remove o from this set. Returns false if this set does not contain o.
     * @param o the object to remove
     * @return true if successfully removed, false otherwise
     */
    boolean remove(Object o);

    /**
     * Determines whether this set contains o.
     * @param o the character to search for
     * @return true if this set contains o, false otherwise
     */
    boolean contains(Object o);

    /**
     * Returns the number of elements in this set
     */
    int size();

    /**
     * Returns the number of characters that this set can hold at once.
     */
    int capacity();

    /**
     * Determines whether the set is full.
     */
    default boolean isFull() {
        return size() == capacity();
    }
}
