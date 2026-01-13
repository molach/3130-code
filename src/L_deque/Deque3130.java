package L_deque;

import J_stack.Stack3130;
import K_queue.Queue3130;

public interface Deque3130<E> extends Stack3130<E>, Queue3130<E> {
    void addFirst(E e);
    void addLast(E e);
    E getFirst();
    E getLast();
    E removeFirst();
    E removeLast();

    // Stack3130 methods

    @Override
    default void push(E e) {
        addFirst(e);
    }

    @Override
    default E pop() {
        return removeFirst();
    }

    // Queue3130 methods

    @Override
    default void enqueue(E e) {
        addLast(e);
    }

    @Override
    default E dequeue() {
        return removeFirst();
    }

    // Method of both Stack3130 and Queue3130

    @Override
    default E peek() {
        return getFirst();
    }
}