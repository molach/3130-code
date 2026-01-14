package L_deque;

/*
                        Singly-linked                       Doubly-linked
                Only head       Head and tail       Only head       Head and tail
getFirst          O(1)              O(1)              O(1)              O(1)
getLast           O(n)              O(1)              O(n)              O(1)
addFirst          O(1)              O(1)              O(1)              O(1)
addLast           O(n)              O(1)              O(n)              O(1)
removeFirst       O(1)              O(1)              O(1)              O(1)
removeLast        O(n)              O(n)              O(n)              O(1)
 */

import java.util.NoSuchElementException;

public class LinkedDeque3130<E> implements Deque3130<E> {
    // Representation: doubly-linked list.
    // Doubly-linked means that each node (except the first and last)
    // points to two other nodes: the previous one in the chain, and the
    // next one in the chain. The first node has no previous, and the
    // last node has no next.
    // The head field points to the first node in the chain; the tail field
    // points to the last node in the chain.

    private static class Node<E> {
        Node<E> previous;
        E data;
        Node<E> next;

        Node(E data) {
            this(null, data, null);
        }

        Node(Node<E> previous, E data, Node<E> next) {
            this.previous = previous;
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head = null, tail = null;
    private int size = 0;

    @Override
    public void addFirst(E e) {
        if (isEmpty()) {
            tail = head = new Node<>(e);
        } else {
            Node<E> node = new Node<>(e);
            node.next = head;
            head.previous = node;
            head = node;
        }

        size++;
    }

    @Override
    public void addLast(E e) {
        if (isEmpty()) {
            head = tail = new Node<>(e);
        } else {
            Node<E> node = new Node<>(e);
            node.previous = tail;
            tail.next = node;
            tail = node;
        }

        size++;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return head.data;
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return tail.data;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        E result = head.data;

        if (head == tail) {
            tail = head = null;
        } else {
            head = head.next;
            head.previous = null;
        }

        size--;
        return result;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        E result = tail.data;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }

        size--;
        return result;
    }

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
