void main() {
    Random rand = new Random();

    // rand.ints(0, 100) // infinite IntStream of random ints between 0 and 100
    //         .forEach(IO::println); // runs forever

    rand.ints(); // nothing happens here, no terminal operation

    // array of ten random even ints between 0 and 100
    // with no duplicates
    int[] arr = rand.ints(0, 100)
            .distinct()
            .filter(i -> i % 2 == 0)
            .limit(10)
            .toArray();
    IO.println(Arrays.toString(arr));

    List<Integer> list =
            Stream.iterate(1, i -> i + 1)
                    .limit(5)
                    .toList();
    IO.println(list);

    IO.println("5! = " + factorial(5));
    IO.println("21! = " + factorial(21));
}

// returns n! = 1 * 2 * 3 * 4 * ... * (n - 1) * n
public static BigInteger factorial(int n) {
    return Stream.iterate(BigInteger.ONE, bi -> bi.add(BigInteger.ONE))
            .limit(n)
            .reduce(BigInteger.ONE, BigInteger::multiply);
}





