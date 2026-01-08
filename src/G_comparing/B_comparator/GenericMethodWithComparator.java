package G_comparing.B_comparator;

import java.util.Comparator;
import java.util.List;

public class GenericMethodWithComparator {
    static void main() {
        List<String> strings = List.of("plane", "balloon", "bird");
        Comparator<String> byLength = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };
        IO.println(max(strings, byLength)); // balloon

        IO.println(max(strings, Comparator.naturalOrder())); // plane
    }

    public static <E> E max(List<E> list, Comparator<E> comparator) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }

        E max = list.getFirst();

        for (E e : list) {
            if (comparator.compare(e, max) > 0) {
                max = e;
            }
        }

        return max;
    }

    // Sorts the specified array using the specified Comparator.
    public static <E> void sort(E[] arr, Comparator<E> comparator) {
        // TODO (you can use selection sort or any other algorithm)
    }
}
