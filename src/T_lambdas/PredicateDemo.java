void main() {
    // Predicate<String> emptinessTester = s -> s.isEmpty();
    Predicate<String> emptinessTester = String::isEmpty;
    IO.println(emptinessTester.test("a")); // false
    IO.println(emptinessTester.test("")); // true

    Predicate<Integer> isPositive = x -> x > 0;

    IO.println(isPositive.test(-4)); // false
    IO.println(isPositive.test(4)); // true

    Predicate<Integer> isEven = x -> x % 2 == 0;

    // Predicate<Integer> isPositiveOrEven = x -> x > 0 || x % 2 == 0;
    Predicate<Integer> isPositiveOrEven = isPositive.or(isEven);

    Predicate<Integer> isPositiveAndEven = isPositive.and(isEven);

    Predicate<Integer> alwaysTrue = x -> true;

    // Predicate<Integer> alwaysFalse = x -> false;
    Predicate<Integer> alwaysFalse = alwaysTrue.negate();

    Predicate<Integer> isOdd = Predicate.not(isEven);
    // alternatively: Predicate<Integer> isOdd = isEven.negate();
    // alternatively: Predicate<Integer> isOdd = x -> x % 2 == 1;

    int[] arr = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};

    IO.print("positive: ");
    printIf(arr, isPositive); // 1 2 3 4 5

    IO.print("even: ");
    printIf(arr, isEven); // -4 -2 0 2 4

    IO.print("positive or even: ");
    printIf(arr, isPositiveOrEven); // -4 -2 0 1 2 3 4 5

    IO.print("positive and even: ");
    printIf(arr, isPositiveAndEven); // 2 4

    IO.print("all: ");
    printIf(arr, alwaysTrue); // -5 -4 -3 -2 -1 0 1 2 3 4 5

    IO.print("none: ");
    printIf(arr, alwaysFalse); //

    IO.print("odd: ");
    printIf(arr, isOdd); // -5 -3 -1 1 3 5

    printIf(arr, x -> x == 0); // 0
}

void printIf(int[] arr, Predicate<Integer> condition) {
    for (int element : arr) {
        if (condition.test(element)) {
            IO.print(element + " ");
        }
    }

    IO.println();
}