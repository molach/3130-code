package K_queue;

/**
 * An unbounded collection of elements to be processed using FIFO order.
 */
public interface Queue3130<E> {
    int size();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E peek();
    @Override String toString();
}