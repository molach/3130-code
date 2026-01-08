package F_generics.A_generic_types.D_variations;

// In this version, we use a generic array (instead of two variables) to store the two items.
public class PairUsingArray<T> {
    private final T[] items; // we can have a variable of type T[]

    @SuppressWarnings("unchecked") // optional annotation
    public PairUsingArray(T first, T second) {
        // we cannot do this:
        // items = new T[2]; // we cannot create a T[] object

        items = (T[]) new Object[2]; // create Object[], and cast to T[]
        // causes compiler warning (not error), which can be suppressed with above annotation

        items[0] = first;
        items[1] = second;
    }

    public T getFirst() {
        return items[0];
    }

    public T getSecond() {
        return items[1];
    }

    @Override
    public String toString() {
        return "(" + items[0] + ", " + items[1] + ")";
    }

    static void main() {
        PairUsingArray<String> pair = new PairUsingArray<>("a", "b");
        IO.println(pair);
    }
}