package M_list;

import java.util.Arrays;
import java.util.Objects;

// most of this was largely done in earlier homework assignments
// running times:
// O(n): add, remove, indexOf, lastIndexOf, toString
// O(1): size, get, set, iterator, the Iterator's next and hsaNext
public class ArrayList3130<E> implements List3130<E> {
    private E[] elements;
    private int size = 0;

    private static final int DEFAULT_INITIAL_CAPACITY = 10;

    public ArrayList3130() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayList3130(int initialCapacity) {
        elements = (E[]) new Object[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, E element) {
        // if (index < 0 || index > size) {
        //     throw new IndexOutOfBoundsException();
        // }
        // the following line is equivalent to the above lines:
        Objects.checkIndex(index, size + 1);

        if (size == elements.length)  {
            grow();
        }

        // shift the elements that are after the index one unit to the right
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = element;
        size++;
    }

    private void grow() {
        elements = Arrays.copyOf(elements, 2 * elements.length + 1);
    }

    @Override
    public E remove(int index) {
        Objects.checkIndex(index, size);
        E element = elements[index];

        // shift the elements that are after the index one unit to the left
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[size - 1] = null; // optional
        size--;
        return element;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        Objects.checkIndex(index, size);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(elements[i], o)) {
                return i;
            }
        }

        return -1;
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