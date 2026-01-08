package F_generics.A_generic_types.A_without_generics;

class PairDemo {
    void main() {
        IntegerPair integerPair = new IntegerPair(45, 33); // autoboxing
        IO.println(integerPair); // (45, 33)
        integerPair.setFirst(76);
        IO.println(integerPair.getFirst()); // 76

        // doesn't work
        // IntegerPair pair2 = new IntegerPair("a", "b");

        StringPair stringPair = new StringPair("a", "b");
        IO.println(stringPair); // (a, b)
        stringPair.setFirst("c");
        IO.println(stringPair.getFirst()); // c
    }
}
