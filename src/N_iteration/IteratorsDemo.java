/*
The enhanced for loop, which you should already be familiar with,
can be used with two kinds of objects:
1. arrays
2. any type that implements the Iterable interface.

Example with an array:
Suppose arr is a String[]. Then the following enhanced for loop:
    for (String s : arr) {
        // do something with s
    }
gets translated into something like the following "under the hood":
    for (int i = 0; i < arr.length; i++) {
        String s = arr[i];
        // do something with s
    }

Example with a type that implements the Iterable interface:
Suppose c is a variable of some type that implements the
Iterable<String> interface. For example, suppose c is a
List<String>. Then the following enhanced for loop:
    for (String s : c) {
        // do something with s
    }
gets translated into something like the following "under the hood":
    Iterator<String> it = c.iterator();
    while (it.hasNext()) {
        String s = it.next();
        // do something with s
    }
This works because the Iterable interface guarantees the existence
of a method named iterator() that returns an Iterator, and the
Iterator interface guarantees that every iterator has methods
hasNext() and next().
 */

void main() {
    List<String> strings = List.of("hello", "world", "good", "evening");
    printElements(strings);

    List<Integer> integers = new ArrayList<>(List.of(2, 8, 1, 2, 9, 3, 4));
    removeEvenElements(integers);
    IO.println(integers); // [1, 9, 3]
}

<E> void printElements(List<E> list) {
    // one way:
    for (int i = 0; i < list.size(); i++) {
        IO.print(list.get(i) + " ");
    }
    IO.println();

    // using an enhanced for loop (uses an Iterator behind the scenes)
    for (E element : list) {
        IO.print(element + " ");
    }
    IO.println();

    // using an iterator: one style - using a for loop
    for (Iterator<E> it = list.iterator(); it.hasNext(); ) {
        IO.print(it.next() + " ");
    }
    IO.println();

    // using an explicit iterator: another style - using a while loop
    Iterator<E> it = list.iterator();
    while (it.hasNext()) {
        IO.print(it.next() + " ");
    }
    IO.println();
}

void removeEvenElements(List<Integer> list) {
    // for (Integer element : list) {
    //     if (element % 2 == 0) {
    //         list.remove(element);
    //     }
    // }
    // Does not work - we get a ConcurrentModificationException,
    // which occurs when we use a method of a list to modify the size of
    // the list while we are iterating over the list.

    for (Iterator<Integer> iter = list.iterator(); iter.hasNext(); ) {
        int element = iter.next();

        if (element % 2 == 0) {
            iter.remove(); // calling Iterator's remove method, not List's, so no ConcurrentModificationException.
            // Iterator's remove method removes from the list the most recent element returned by next()
        }
    }
}