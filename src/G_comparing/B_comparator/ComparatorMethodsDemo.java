/*
The following are some important methods of the Comparator interface.

abstract method:
- if c is a Comparator, then c.compare(a, b) returns:
    - positive if a > b
    - negative if a < b
    - 0 if a = b

static methods:
- Comparator.naturalOrder(): returns a Comparator<T> that does the same
  thing as T's compareTo method.
    - that is, the Comparator's compare method returns positive wherever
      compareTo would return positive, etc.
- Comparator.reverseOrder(): returns a Comparator<T> that performs the
   opposite of T's compareTo method.
    - that is, the Comparator's compare method returns positive wherever
      compareTo would return negative, and vice versa

default methods:
- if c is a Comparator, then c.reversed() returns a Comparator that does
  the reverse of c.
    - that is, the compare method of the new Comparator returns positive
      wherever c's compare method would return negative, and vice versa
- if c1 and c2 are Comparators, then c1.thenComparing(c2) returns a
  Comparator that first compares objects using c1 and then (if there's a
  tie) compares them using c2.
 */

void main(String[] args) {
    String[] animals = {"dog", "bird", "cat"};
    List<String> animalsList = new ArrayList<>(List.of("dog", "bird", "cat"));

    Comparator<String> alphabetically = Comparator.naturalOrder();
    IO.println(alphabetically.compare("bird", "cat")); // negative int
    IO.println(alphabetically.compare("dog", "cat"));  // positive int
    Arrays.sort(animals, alphabetically);
    IO.println(Arrays.toString(animals)); // [bird, cat, dog]
    animalsList.sort(alphabetically);
    IO.println(animalsList); // [bird, cat, dog]

    Comparator<String> alphabeticallyReversed = Comparator.reverseOrder();
    IO.println(alphabeticallyReversed.compare("bird", "cat")); // positive int
    IO.println(alphabeticallyReversed.compare("dog", "cat"));  // negative int
    Arrays.sort(animals, alphabeticallyReversed);
    IO.println(Arrays.toString(animals)); // [dog, cat, bird]
    animalsList.sort(alphabeticallyReversed);
    IO.println(animalsList); // [dog, cat, bird]

    Comparator<String> byLength = new Comparator<>() {
        @Override
        public int compare(String s1, String s2) {
            return Integer.compare(s1.length(), s2.length());
        }
    };
    IO.println(byLength.compare("bird", "cat")); // positive int
    IO.println(byLength.compare("dog", "cat"));  // 0
    Arrays.sort(animals, byLength);
    IO.println(Arrays.toString(animals)); // [cat, dog, bird] or [dog, cat, bird]

    Comparator<String> byLengthReversed = byLength.reversed();
    IO.println(byLengthReversed.compare("bird", "cat")); // negative int
    IO.println(byLengthReversed.compare("dog", "cat"));  // 0
    Arrays.sort(animals, byLengthReversed);
    IO.println(Arrays.toString(animals)); // [bird, cat, dog] or [bird, dog, cat]

    Comparator<String> byLengthThenAlphabetically = byLength.thenComparing(alphabetically);
    IO.println(byLengthThenAlphabetically.compare("bird", "cat")); // positive int
    IO.println(byLengthThenAlphabetically.compare("dog", "cat"));  // positive int
    Arrays.sort(animals, byLengthThenAlphabetically);
    IO.println(Arrays.toString(animals)); // [cat, dog, bird]
}