void main() {
    List<String> list = new ArrayList<>(List.of("bus", "train", "bus", "ferry", "car", "car", "ferry"));
    // badDeduplicate(list);
    deduplicate(list);
    IO.println(list);
}

// Removes the duplicate elements in the given list, but does not guarantee
// that the remaining elements will be in the same order that they were originally in.
<E> void badDeduplicate(List<E> list) {
    Set<E> set = new HashSet<>();

    for (E element : list) {
        set.add(element);
    }

    list.clear();

    for (E element : set) {
        list.add(element);
    }
}

// Removes the duplicate elements in the given list, guaranteeing that the
// remaining elements will be in the same order that they were originally in.
<E> void deduplicate(List<E> list) {
    SequencedSet<E> sequencedSet = new LinkedHashSet<>();

    for (E element : list) {
        sequencedSet.add(element);
    }

    list.clear();

    for (E element : sequencedSet) {
        list.add(element);
    }
}