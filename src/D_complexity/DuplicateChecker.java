package D_complexity;

import java.util.Arrays;

public class DuplicateChecker {
    static void main() {
        int[] arr = {4, 3, 9, 2, 5, 6, 9, 1};
        IO.println(containDuplicateSlow(arr)); // true
    }

    // Given an array, determines whether it contains any duplicate elements.
    public static boolean containDuplicateSlow(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true; // found duplicate
                }
            }
        }

        return false; // if we reach this, no duplicate was found
    }
    // running time of containDuplicateSlow: O(n^2)
    // space complexity: O(1)

    public static boolean containsDuplicateFaster(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length); // make a copy of arr: O(n)
        Arrays.sort(copy); // sort the copy (client does not expect their array to be modified)

        for (int i = 0; i < copy.length - 1; i++) {
            if (copy[i] == copy[i + 1]) { // check neighboring entries
                return true;              // found duplicate
            }
        }

        return false; // if we reach this, no duplicate was found
    }
    // n + (n log n) + n = 2n + n log n
    // running time of containsDuplicateFaster: O(n log n)
    // space complexity: O(n)

    // In a few weeks, we will see how to do this in O(n) time.
}