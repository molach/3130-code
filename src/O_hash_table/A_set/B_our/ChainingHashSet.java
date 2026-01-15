package O_hash_table.A_set.B_our;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ChainingHashSet<E> implements Set3130<E> {
    // Representation: a hash table. We use chaining to resolve collisions: that is,
    // at each index, we have a linked list for all the elements that belong at that index.

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E>[] table;
    private int size = 0;
    private final double maxLoadFactor;
    // the highest that this set's load factor can go; when the load factor goes above this, we resize

    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private static final double DEFAULT_MAX_LOAD_FACTOR = 0.75;

    public ChainingHashSet() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }

    @SuppressWarnings("unchecked")
    public ChainingHashSet(int initialCapacity, double maxLoadFactor) {
        if (maxLoadFactor <= 0) {
            throw new IllegalArgumentException("max load factor must be positive");
        }

        table = (Node<E>[]) new Node[initialCapacity];
        this.maxLoadFactor = maxLoadFactor;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E e) {
        if (contains(e)) {
            return false;
        }

        // insert e at the front of the list
        int bucket = hash(e);
        table[bucket] = new Node<>(e, table[bucket]);
        size++;

        if (loadFactor() > maxLoadFactor) {
            growAndRehash();
        }

        return true;
    }

    @Override
    public boolean contains(Object o) {
        int bucket = hash(o);
        Node<E> current = table[bucket];

        while (current != null) {
            if (Objects.equals(current.data, o)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
        int bucket = hash(o);

        if (table[bucket] == null) {
            return false;
        }

        // check front of list
        if (Objects.equals(table[bucket].data, o)) {
            table[bucket] = table[bucket].next;
            size--;
            return true;
        }

        // check rest of list
        Node<E> current = table[bucket];
        while (current.next != null && !Objects.equals(current.next.data, o)) {
            current = current.next;
        }

        // if the element is found, remove it
        if (current.next != null && Objects.equals(current.next.data, o)) {
            current.next = current.next.next;
            size--;
            return true;
        }

        return false; // not found
    }

    @Override
    public Iterator<E> iterator() {
        // The following uses uses O(n) time and O(n) space.
        // It is possible to make both be O(1).

        List<E> aux = new ArrayList<>();

        for (int i = 0; i < table.length; i++) {
            Node<E> current = table[i];

            while (current != null) {
                aux.add(current.data);
                current = current.next;
            }
        }

        return aux.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        int count = 0;

        for (int i = 0; i < table.length; i++) {
            Node<E> current = table[i];

            while (current != null) {
                sb.append(current.data);
                count++;

                if (count < size) {
                    sb.append(", ");
                }

                current = current.next;
            }
        }

        return sb.append("]").toString();
    }

    // given an object, returns the index at which the object belongs
    private int hash(Object o) {
        return Math.abs(o.hashCode()) % table.length;
    }

    // returns the current load factor
    private double loadFactor() {
        return size / (double) table.length;
    }

    @SuppressWarnings("unchecked")
    private void growAndRehash() {
        Node<E>[] oldTable = table;
        table = (Node<E>[]) new Node[2 * oldTable.length + 1];
        size = 0;

        // re-add all the old data into the new array
        for (int i = 0; i < oldTable.length; i++) {
            Node<E> current = oldTable[i];

            while (current != null) {
                add(current.data);
                current = current.next;
            }
        }
    }
}
