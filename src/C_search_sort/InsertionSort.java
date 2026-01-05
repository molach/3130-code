package C_search_sort;

/*
insertion sort: insert each element into a
sorted sub-array at the front of the array.

original:     {1, | 9, 4, 6, 5, -4}
after pass 1: {1, 9, | 4, 6, 5, -4}
after pass 2: {1, 4, 9, | 6, 5, -4}
after pass 3: {1, 4, 6, 9, | 5, -4}
after pass 4: {1, 4, 5, 6, 9, | -4}
after pass 5: {-4, 1, 4, 5, 6, 9 |}

(The elements to the left of the bar constitute the sorted subarray.)

In insertion sort, we always make n - 1 passes.
 */

import java.util.Arrays;

public class InsertionSort {
    static void main() {
        int[] arr = {1, 9, 4, 6, 5, -4};
        insertionSort(arr);
    }

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                swap(a, j, j - 1);
            }

            // for debugging:
            // IO.println("After pass " + i + ": " + Arrays.toString(a));
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
