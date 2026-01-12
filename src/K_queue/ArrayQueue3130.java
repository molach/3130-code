package K_queue;

import java.util.NoSuchElementException;

// size, isEmpty, dequeue, peek: O(1)
// enqueue: amortized O(1)
// toString: O(n)
public class ArrayQueue3130<E> implements Queue3130<E> {
    // Representation: ring buffer, aka circular array.
    // We keep track of the index of the queue's front element
    // and the index of the queue's last element. The values are
    // -1 when the queue is empty.

    private E[] elements;
    private int indexOfFirst = -1, indexOfLast = -1;

    private static final int DEFAULT_INITIAL_CAPACITY = 10;

    /**
     * Creates an empty queue.
     */
    public ArrayQueue3130() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    /**
     * Creates an empty queue with the specified initial capacity.
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue3130(int initialCapacity) {
        elements = (E[]) new Object[initialCapacity];
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        } else if (indexOfFirst <= indexOfLast) {
            return indexOfLast - indexOfFirst + 1;
        } else {
            return (indexOfLast + 1) + (elements.length - indexOfFirst);
        }
    }

    @Override
    public boolean isEmpty() {
        return indexOfFirst == -1 && indexOfLast == -1;
    }

    public void enqueue(E element) {
        if (size() == elements.length) {
            grow();
        }

        if (isEmpty()) {
            indexOfFirst = indexOfLast = 0;
        } else {
            indexOfLast = (indexOfLast + 1) % elements.length;
            // equivalent to:
            // indexOfLast++;
            // if (indexOfLast == elements.length) indexOfLast = 0;
        }

        elements[indexOfLast] = element;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        E result = elements[indexOfFirst];
        elements[indexOfFirst] = null; // optional

        if (indexOfFirst == indexOfLast) { // queue becomes empty after this dequeue
            indexOfFirst = indexOfLast = -1;
        } else {
            indexOfFirst = (indexOfFirst + 1) % elements.length;
            // equivalent to:
            // indexOfFirst++;
            // if (indexOfFirst == elements.length) indexOfFirst = 0;
        }

        return result;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return elements[indexOfFirst];
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        E[] newArray = (E[]) new Object[2 * elements.length + 1];

        for (int i = 0; i < size(); i++) {
            newArray[i] = elements[(indexOfFirst + i) % elements.length];
        }

        indexOfLast = size() - 1;
        indexOfFirst = 0;
        elements = newArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < size(); i++) {
            sb.append(elements[(indexOfFirst + i) % elements.length]);

            if (i < size() - 1) {
                sb.append(", ");
            }
        }

        return sb.append("]").toString();
    }
}