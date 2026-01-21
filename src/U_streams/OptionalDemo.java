void main() {
    Optional<String> nonEmpty = Optional.of("a");
    Optional<String> empty = Optional.empty();

    IO.println(nonEmpty.orElse("b")); // a
    IO.println(empty.orElse("b")); // b

    IO.println(nonEmpty.orElseThrow()); // a
    // IO.println(empty.orElseThrow()); // throws a NoSuchElementException

    nonEmpty.ifPresent(IO::println); // a
    empty.ifPresent(IO::println); // nothing is printed here

    Comparator<String> byNaturalOrder = Comparator.naturalOrder();
    Comparator<String> byLength = Comparator.comparing(String::length);
    max(Set.of("aa", "b"), byNaturalOrder).ifPresent(IO::println); // b
    max(Set.of("aa", "b"), byLength).ifPresent(IO::println); // aa
    max(Set.of(), byNaturalOrder).ifPresent(IO::println); // nothing is printed here
}

public static <E> Optional<E> max(Collection<E> collection, Comparator<E> comparator) {
    if (collection.isEmpty()) {
        return Optional.empty();
    }

    Iterator<E> iterator = collection.iterator();
    E max = iterator.next();

    while (iterator.hasNext()) {
        E current = iterator.next();

        if (comparator.compare(current, max) > 0) {
            max = current;
        }
    }

    return Optional.of(max);
}