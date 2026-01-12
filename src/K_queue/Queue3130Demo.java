import K_queue.ArrayQueue3130;
import K_queue.LinkedQueue3130;
import K_queue.Queue3130;

void main() {
    Queue3130<Integer> queue1 = new ArrayQueue3130<>(); // or LinkedQueue3130
    queue1.enqueue(5);
    queue1.enqueue(10);
    queue1.enqueue(4);
    int result = sum(queue1);
    IO.println(result); // 19
    IO.println(queue1); // [5, 10, 4]

    int[] data = {18, 4, 7, 42, 9, 33, -8, 0, 14, 42, 7, 42, 42, 19};
    Queue3130<Integer> queue2 = new LinkedQueue3130<>(); // or ArrayQueue3130

    for (int datum : data) {
        queue2.enqueue(datum);
    }

    removeAllOccurrences(queue2, 42);
    IO.println("queue2 = " + queue2); // [18, 4, 7, 9, 33, -8, 0, 14, 7, 19]
}

/*
 Write a method that returns the sum of the elements in the given queue.
 When the method terminates, the queue must be in the same state that it was originally in.
 Constraint: Do not use any auxiliary collections (arrays, ArrayLists, etc.).
*/
int sum(Queue3130<Integer> queue) {
    int sum = 0;

    for (int i = 0; i < queue.size(); i++) {
        int element = queue.dequeue();
        sum += element;
        queue.enqueue(element);
    }

    return sum;
}

/*
Write a method that removes all occurrences of the given value in the given queue.
When the method terminates, all other elements should be in the same order that
they were before.
Constraint: Do not use any auxiliary collections (arrays, ArrayLists, etc.).
 */
void removeAllOccurrences(Queue3130<Integer> queue, int value) {
    int originalSize = queue.size();

    for (int i = 0; i < originalSize; i++) {
        int element = queue.dequeue();

        if (element != value) {
            queue.enqueue(element);
        }
    }
}
