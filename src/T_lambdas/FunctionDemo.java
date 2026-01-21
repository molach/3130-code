void main() {
    Function<String, String> secondHalf = s -> s.substring(s.length() / 2);
    IO.println(secondHalf.apply("goodbye!"));

    Function<String, Integer> lengthGetter = String::length;
    IO.println(lengthGetter.apply("bye!")); // 4

    Function<Integer, Double> squareRooter = Math::sqrt;
    IO.println(squareRooter.apply(4)); // 2.0

    Function<String, Double> sqrtHalfLength = secondHalf.andThen(lengthGetter).andThen(squareRooter);
    IO.println(sqrtHalfLength.apply("goodbye!")); // 2.0

    Integer[] integers = {4, 16, 9};
    mapAndPrint(integers, i -> Math.sqrt(i));
    mapAndPrint(integers, i -> i * i);

    String[] strings = {"a", "few", "strings"};
    mapAndPrint(strings, String::length);
    mapAndPrint(strings, s -> s.charAt(0));
    mapAndPrint(strings, String::toUpperCase);
    mapAndPrint(strings, s -> s + "!");
}

public static <T, R> void mapAndPrint(T[] arr, Function<T, R> mapper) {
    for (T element : arr) {
        R mapped = mapper.apply(element);
        IO.print(mapped + " ");
    }

    IO.println();
}
