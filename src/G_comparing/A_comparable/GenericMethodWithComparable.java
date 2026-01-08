package G_comparing.A_comparable;

import java.time.LocalDate;
import java.util.List;

public class GenericMethodWithComparable {
    static void main() {
        List<String> strings = List.of("car", "train", "motorcycle");
        IO.println(max(strings)); // train

        List<Integer> integers = List.of(5, 1, 7, 3, 6);
        IO.println(max(integers)); // 7

        List<Student> studentList = List.of(new Student("Joe", 111), new Student("Jane", 222));
        IO.println(max(studentList)); // Student[name=Jane, id=222]
    }

    // Returns the maximum element in the list according to the elements' natural order.
    // Examples of things we can pass to this method: List<Integer>, ArrayList<String>
    // Examples of things we cannot pass to this method: List<Scanner>
    public static <E extends Comparable<E>> E max(List<E> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }

        E max = list.getFirst(); // equivalent to: list.get(0);

        for (E e : list) {
            if (e.compareTo(max) > 0) {
                max = e;
            }
        }

        return max;
    }

    // Sorts the specified array using the natural order of the elements.
    public static <E extends Comparable<E>> void sort(E[] arr) {
        // TODO (you can use selection sort or any other algorithm)
    }
}
