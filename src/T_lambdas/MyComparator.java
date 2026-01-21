package T_lambdas;

import java.util.function.Function;

// mimics java.util.Comparator
@FunctionalInterface
public interface MyComparator<T> {
    int compare(T o1, T o2);

    static <T extends Comparable<T>> MyComparator<T> naturalOrder() {
        return (o1, o2) -> o1.compareTo(o2);
        // or: return Comparable::compareTo;
    }

    static <T extends Comparable<T>> MyComparator<T> reverseOrder() {
        return (o1, o2) -> -o1.compareTo(o2);
    }

    static <T, U extends Comparable<U>> MyComparator<T> comparing(Function<T, U> keyExtractor) {
        return (o1, o2) -> keyExtractor.apply(o1).compareTo(keyExtractor.apply(o2));
    }

    default MyComparator<T> reversed() {
        return (o1, o2) -> -this.compare(o1, o2);
    }

    default MyComparator<T> thenComparing(MyComparator<T> other) {
        return (o1, o2) -> {
            int firstComparisonResult = this.compare(o1, o2);

            if (firstComparisonResult != 0) {
                return firstComparisonResult;
            }

            int secondComparisonResult = other.compare(o1, o2);
            return secondComparisonResult;
        };
    }

    default <U extends Comparable<U>> MyComparator<T> thenComparing(Function<T, U> keyExtractor) {
        return (o1, o2) -> {
            int firstComparisonResult = this.compare(o1, o2);

            if (firstComparisonResult != 0) {
                return firstComparisonResult;
            }

            int secondComparisonResult = keyExtractor.apply(o1).compareTo(keyExtractor.apply(o2));
            return secondComparisonResult;
        };
    }
}