void main() {
    forEachDemoIterable();
    forEachDemoMap();
    removeIfDemo();
    replaceAllDemo();
}

// demonstrates Iterable's forEach(Consumer action) method
void forEachDemoIterable() {
    List<String> list = List.of("a", "b", "c");
    list.forEach(IO::println);
}

// demonstrates Map's forEach(BiConsumer action) method
void forEachDemoMap() {
    Map<Integer, String> map = Map.of(4, "a", 6, "b", 2, "c");
    map.forEach((i, s) -> IO.println(i + " ---- " + s));
}

// demonstrates Collection's removeIf(Predicate filter) method
void removeIfDemo() {
    Set<String> set = new HashSet<>(Set.of("alpha", "bravo", "charlie"));
    set.removeIf(s -> s.length() == 5);
    IO.println(set); // [charlie]

    List<Integer> list = new ArrayList<>(List.of(-3, -2, -1, 0, 1, 2, 3));
    Predicate<Integer> isPositive = x -> x > 0;
    Predicate<Integer> isEven = x -> x % 2 == 0;
    Predicate<Integer> isPositiveOrEven = isPositive.or(isEven);
    list.removeIf(isPositiveOrEven);
    IO.println(list); // [-3, -1]
}

// demonstrates List's replaceAll(UnaryOperator operator)
void replaceAllDemo() {
    List<String> list = new ArrayList<>(List.of("one", "two"));
    list.replaceAll(s -> s + " more");
    IO.println(list); // [one more, two more]

    list.replaceAll(String::toUpperCase);
    IO.println(list); // [ONE MORE, TWO MORE]

    list.replaceAll(s -> "a");
    IO.println(list); // [a, a]
}