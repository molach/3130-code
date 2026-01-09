package J_stack;

import java.util.NoSuchElementException;

/**
 * An implementation of the stack ADT using singly-linked nodes.
 * Methods isEmpty, push, and pop run in constant time.
 */
public class LinkedStack3130<E> implements Stack3130<E> {
    // Representation: the elements are stored in a singly-linked list
    // (that is, a chain of singly-linked nodes). We have a reference
    // to the head node; the reference is null when the stack is empty.
    // Pushing and popping take place at the head of the list.

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head = null;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void push(E e) {
        head = new Node<>(e, head);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        E result = head.data;
        head = head.next;
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
