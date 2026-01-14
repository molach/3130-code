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
    IO.println(iter.next()); // a
    iter.remove();
    IO.println(list); // [c, b]

    // Iterator's remove() method is an "optional operation": implementations
    // of Iterator are not required to support this method. For the most part,
    // the Iterator implementations in the JCF do support this method; for
    // example, the Iterator we obtain from an ArrayList or a LinkedList
    // provides this method. If the remove() method is called on an implementation
    // that does not support remove(), an UnsupportedOperationException is thrown.

    List<Integer> list2 = new ArrayList<>(List.of(5, 10, 15, 20));
    Iterator<Integer> iter2 = list2.iterator();
    list2.add(25);
    IO.println(iter2.next()); // ConcurrentModificationException
    // This kind of exception occurs when you create an Iterator, then change the
    // size of the size of the underlying collection using one of the collection's
    // methods (like add(e) or remove(o)), and then try to use the Iterator.
}