package F_generics.A_generic_types.B_old_style_generics;

class PairDemo {
    void main() {
        ObjectPair integerPair = new ObjectPair(45, 33); // works

        ObjectPair stringPair = new ObjectPair("a", "b"); // works

        // So far, so good. But there are issues with the
        // old-fashioned approach to writing generic classes:

        // 1. cast required
        String f = (String) stringPair.getFirst();

        // 2. compiler allows this, but we want to prevent it
        stringPair.setFirst(33);

        // 3. compiler allows this, but causes a ClassCastException when the program runs
        f = (String) stringPair.getFirst();
    }
}
