package F_generics.A_generic_types.C_current_style;

import java.math.BigInteger;

class PairDemo {
    void main() {
        // String is the type argument here. For this Pair object, T means String.
        Pair<String> stringPair = new Pair<>("a", "b");
        IO.println(stringPair);

        // this will not compile, which is good:
        // stringPair.setFirst(34);

        // No cast needed now, since the compiler knows that, for this Pair,
        // getFirst returns a String.
        String firstString = stringPair.getFirst();

        // Integer is the type argument here. For this Pair object, T means Integer.
        Pair<Integer> integerPair = new Pair<>(89, -90); // autoboxing
        IO.println(integerPair); // (89, -90)
        int first = integerPair.getFirst();  // auto-unboxing
        integerPair.setFirst(34);

        // This won't compile, as a primitive type cannot be used as a type argument:
        // Pair<int> intPair = new Pair<>(56, 78);

        // A Pair<C> can contain objects of all classes that inherit from C.
        // For example, a Pair<Number> can contain objects of all classes that
        // inherit from Number: Integer, Double, BigInteger, etc.
        Pair<Number> numberPair = new Pair<>(34.5, new BigInteger("1234567890"));
        IO.println(numberPair);

        // Similarly, a Pair<Object> can contain objects of any class:
        Pair<Object> objectPair = new Pair<>("hello", new BigInteger("1234567890"));
        IO.println(objectPair);

        // The following is an example of using a generic class as a "raw type."
        // Although it is legal, it is a bad idea, since we lose the type safety
        // normally provided by generics.
        Pair pair = new Pair(4, 34);
    }
}
