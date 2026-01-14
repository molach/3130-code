void main() {
    List<String> list = new ArrayList<>(List.of("c", "d", "a", "b"));

    // List inherits from Iterable, which has a method named iterator(),
    // which returns an Iterator object. Iterator has the following methods:
    // next(), hasNext(), and remove().
    Iterator<String> iter = list.iterator();
    IO.println(iter.next()); // c
    IO.println(iter.next()); // d
    IO.println(iter.hasNext()); // true
    IO.println(iter.next()); // a
    IO.println(iter.next()); // b
    IO.println(iter.hasNext()); // false
    // IO.println(iter.next()); // NoSuchElementException

    // re-create the Iterator to start again from the beginning
    iter = list.iterator();
    IO.println(iter.next()); // c
    IO.println(iter.next()); // d
    iter.remove(); // removes from the list the most recent element obtained from next(), d
    // iter.remove(); // IllegalStateException
    IO.println(list); // [c, a, b]
}