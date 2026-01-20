package R_heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class MaxPriorityQueue<E> {
    @SuppressWarnings("unchecked")
    private E[] elements = (E[]) new Object[10];
    private int size = 0;
    private final Comparator<E> comparator;

    private class NaturalOrderComparator implements Comparator<E> {
        @Override
        public int compare(E e1, E e2) {
            return ((Comparable<E>) e1).compareTo(e2);
        }
    }

    public MaxPriorityQueue() {
        this.comparator = new NaturalOrderComparator();
    }

    public MaxPriorityQueue(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    private static int indexOfParent(int i) {
        return (i - 1) / 2;
    }

    private static int indexOfLeftChild(int i) {
        return i * 2 + 1;
    }

    private static int indexOfRightChild(int i) {
        return i * 2 + 2;
    }

    // returns true if e1 > e2
    private boolean greater(E e1, E e2) {
        return comparator.compare(e1, e2) > 0;
    }

    private void swap(int i, int j) {
        E temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    // O(log n)
    public void add(E element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, 2 * elements.length + 1);
        }

        elements[size++] = element;
        int index = size - 1; // the index of the element that we added

        while (index > 0) {
            int parentIndex = indexOfParent(index);

            // Swap if the element is greater than its parent
            if (greater(elements[index], elements[parentIndex])) {
                swap(index, parentIndex);
            } else {
                break; // the tree is a max heap now
            }

            index = parentIndex;
        }
    }

    // removes and returns the max element
    // O(log n)
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        E max = elements[0];
        elements[0] = elements[size - 1];
        size--;

        int index = 0; // the index of the element that was moved to the top
        while (index < size) {
            int leftChildIndex = indexOfLeftChild(index);
            int rightChildIndex = indexOfRightChild(index);

            if (leftChildIndex >= size) { // left child doesn't exist, so also no right child
                break; // can't go any further down
            }

            // Find the maximum between two children
            int maxChildIndex = leftChildIndex; // guess that the left child is max
            if (rightChildIndex < size) { // if there is a right child
                if (greater(elements[rightChildIndex], elements[leftChildIndex])) {
                    // if the right child is greater than the left, then right is max
                    maxChildIndex = rightChildIndex;
                }
            }

            // If the max child is greater than the current element, swap them
            if (greater(elements[maxChildIndex], elements[index])) {
                swap(maxChildIndex, index);
                index = maxChildIndex;
            } else {
                break; // The tree is a max heap
            }
        }

        return max;
    }

    // returns the max element
    // O(1)
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return elements[0];
    }

    // O(1)
    public int size() {
        return size;
    }

    // O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);

            if (i < size - 1) {
                sb.append(", ");
            }
        }

        return sb.append("]").toString();
    }
}