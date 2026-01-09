package J_stack;

/**
 * An unbounded collection of elements to be processed using LIFO order.
 */
public interface Stack3130<E> {
    /**
     * Determines whether the stack is empty.
     */
    boolean isEmpty();

    /**
     * Pushes the specified element onto the top of the stack.
     */
    void push(E e);

    /**
     * Removes top element of the stack and returns it.
     * Throws a NoSuchElementException if the stack is empty.
     */
    E pop();

    /**
     * Returns top element of the stack without removing it.
     * Throws a NoSuchElementException if the stack is empty.
     */
    E peek();

    /**
     * Returns a String containing the elements listed from top to bottom.
     */
    @Override String toString();
}