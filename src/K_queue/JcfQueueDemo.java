// Demonstrates the java.util.Queue interface and its
// concrete implementations ArrayDeque and LinkedList.
void main() {
    Queue<Integer> queue1 = new ArrayDeque<>();
    queue1.add(10);
    queue1.add(15);
    queue1.add(5);
    IO.println(queue1.isEmpty()); // false
    IO.println(queue1.size()); // 3
    IO.println(queue1); // [10, 15, 5]
    IO.println(queue1.peek()); // 10
    IO.println(queue1.peek());
    IO.println(queue1.remove());
    IO.println(queue1.peek());
    IO.println(queue1.remove());
    IO.println(queue1.remove());
    IO.println(queue1.isEmpty());

    Queue<Integer> queue2 = new LinkedList<>();
    // same methods available as above
}