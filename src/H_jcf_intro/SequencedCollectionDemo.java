void main() {
    // Iterable: anything that can be iterated over with an enhanced for loop.
    // Primary method: iterator()

    // Collection: an Iterable group of elements.
    // Primary methods: see Iterable, plus: size(), add(e), remove(o), contains(o)

    // SequencedCollection: a Collection with a predicable iteration order.
    // Primary methods: see Collection,
    // plus: addFirst(e), addLast(e), getFirst(), getLast(), removeFirst(), removeLast(), reversed()

    Deque<String> deque = new ArrayDeque<>(List.of("a", "b", "c", "d"));

    // List: a SequencedCollection that offers access via indexes.
    // Primary methods: see SequencedCollection,
    // plus: add(index, e), remove(index), get(index), set(index, e),
    // indexOf(o), subList(index1, index2), sort(comparator)
    List<Integer> list = new ArrayList<>(List.of(10, 20, 50, 40, 30));
}

<E> void printFirstAndLast(SequencedCollection<E> sequencedCollection) {
    IO.println(sequencedCollection.getFirst());
    IO.println(sequencedCollection.getLast());
}

<E> void printEveryOtherElement(SequencedCollection<E> sequencedCollection) {
    for (Iterator<E> it = sequencedCollection.iterator(); it.hasNext(); ) {
        IO.println(it.next());

        if (it.hasNext()) {
            it.next(); // obtain the next element, thus advancing the iterator, but don't print
        }
    }
}