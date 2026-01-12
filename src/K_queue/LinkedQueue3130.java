package K_queue;

import java.util.NoSuchElementException;

/**
 * An implementation of the queue ADT using singly-linked nodes.
 * All methods, except toString(), run in constant time.
 */
public class LinkedQueue3130<E> implements Queue3130<E> {
    // Representation: singly-linked list with head and tail pointers.
    // The queue is empty when head and tail are both null.
    // The enqueue operation adds a new node at the tail.
    // The dequeue operation removes the node at the head.

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this(data, null);
        }

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head = null, tail = null;
    int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
        // or: return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (isEmpty()) {
            head = tail = new Node<>(e);
        } else {
            tail = tail.next = new Node<>(e);
        }

        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        E result = head.data;
        head = head.next;
        size--;

        if (head == null) {
            // queue is empty now
            tail = null;
        }

        return result;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return head.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;

        while (current != null) {
            sb.append(current.data);

            if (current.next != null) {
                sb.append(", ");
            }

            current = current.next;
        }

        return sb.append("]").toString();
    }
}