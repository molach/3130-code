void main() {
    IO.println("demoing HashSet");
    Set<Integer> set1 = new HashSet<>(6, 0.75f);
    demo(set1);

    IO.println("demoing LinkedHashSet");
    SequencedSet<Integer> set2 = new LinkedHashSet<>(6, 0.75f);
    demo(set2);
}

private static void demo(Set<Integer> set) {
    set.add(5);
    set.add(19);
    set.add(7);
    IO.println("set = " + set);

    IO.println(set.add(19)); // false

    set.add(10);
    set.add(12);
    set.add(25);
    set.add(4);
    IO.println("set = " + set);
}