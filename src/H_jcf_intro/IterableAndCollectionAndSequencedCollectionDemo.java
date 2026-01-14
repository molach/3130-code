void main() {
    // Iterable: anything that can be iterated over with an enhanced for loop.
    // Primary method: iterator()
    Iterable<String> list1 = List.of("a", "f", "b");
    for (String s : list1) {
        IO.print(s + " ");
    }
    IO.println();
    // IO.println(list1.contains("b")); // compilation error

    Iterable<String> set = Set.of("a", "f", "b");
    for (String s : set) {
        IO.print(s + " ");
    }
    IO.println();

    Iterable<Integer> queue = new ArrayDeque<>(List.of(5, 10, 15));
    for (int element : queue) {
        IO.print(element + " ");
    }
    IO.println();

    // Collection: an Iterable group of elements.
    // Primary methods: see Iterable, plus: size(), add(e), remove(o), contains(o)
    Collection<Integer> list2 = List.of(10, 5, 15, 25, 20);
    for (int element : list2) {
        IO.print(element + " ");
    }
    IO.println();
    IO.println(list2.contains(18)); // false
    // IO.println(list2.get(1)); // compilation error
    IO.println(list2); // [10, 5, 15, 25, 20]
    IO.println(containsAnyOfRange(list2, 12, 22)); // true

    Collection<Integer> set2 = Set.of(5, 10, 7);
    IO.println(set2); // unpredictable order
    IO.println(containsAnyOfRange(set2, 12, 22)); // false

    // SequencedCollection: a Collection whose elements have a predicable order.
    // Primary methods: see Collection,
    // plus: addFirst(e), addLast(e), getFirst(), getLast(), removeFirst(),
    // removeLast(), reversed()
    List<Integer> list = new ArrayList<>(List.of(10, 20, 50, 40, 30));
    Deque<String> deque = new ArrayDeque<>(List.of("a", "b", "c"));

    // List: a SequencedCollection that offers access via indexes.
    // Primary methods: see SequencedCollection,
    // plus: add(index, e), remove(index), get(index), set(index, e),
    // indexOf(o), lastIndexOf(o), sort(comparator), subList(index1, index2)
}

<E> void printOneElementPerLine(Iterable<E> iterable) {
    for (E element : iterable) {
        IO.println(element);
    }
}

boolean containsAnyOfRange(Collection<Integer> collection, int low, int high) {
    for (int i = low; i <= high; i++) {
        if (collection.contains(i)) {
            return true;
        }
    }

    return false;
}

<E> void printFirstAndLast(SequencedCollection<E> sequencedCollection) {
    IO.println(sequencedCollection.getFirst());
    IO.println(sequencedCollection.getLast());
}