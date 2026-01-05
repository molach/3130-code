package C_search_sort;

/*
Bubble sort: make repeated passes, swapping adjacent values
when necessary. The larger values bubble up to the end of
the array.

Tracing bubble sort:
original:     {2, 3, 2, 14, 5, -2, 3, 12}
after pass 0: {2, 2, 3, 5, -2, 3, 12, | 14}
after pass 1: {2, 2, 3, -2, 3, 5, | 12, 14}
after pass 2: {2, 2, -2, 3, 3, | 5, 12, 14}
after pass 3: {2, -2, 2, 3, | 3, 5, 12, 14}
after pass 4: {-2, 2, 2, | 3, 3, 5, 12, 14}
after pass 5: {-2, 2, | 2, 3, 3, 5, 12, 14} (the optimized version stops here)
after pass 6: {-2, | 2, 2, 3, 3, 5, 12, 14}

(After each pass, everything to the right of the bar is in
its final location.)

In the basic version, we always have to perform n - 1 passes
for an array of length n.

We make an optimization: if, on any given pass, we don't perform
any swaps, then the array must already be sorted, and we can stop.

What is the best-case scenario for the input, the case where the
amount of work that has to be performed is as small as possible?
Answer: the array is sorted.

What is the worst-case scenario? Answer: sorted in reverse order.
 */

import java.util.Arrays;

public class BubbleSort {
    static void main() {
        int[] arr = {2, 3, 2, 14, 5, -2, 3, 12};
        bubbleSortWithOptimization(arr);
        IO.println();

        int[] alreadySorted = {5, 10, 15, 20, 25};
        bubbleSortWithOptimization(alreadySorted);
    }

    public static void bubbleSort(int[] arr) {
        // perform (arr.length - 1) passes
        for (int i = 0; i < arr.length - 1; i++) {
            // go through all elements except the final i elements
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }

            // for debugging:
            // IO.println("After pass " + i + ": " + Arrays.toString(arr));
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void bubbleSortWithOptimization(int[] arr) {
        boolean swapped = true;

        // makes at most (arr.length - 1) passes,
        // stopping early if no swaps were made in the previous pass
        for (int i = 0; i < arr.length - 1 && swapped; i++) {
            swapped = false; // no swaps yet in the current pass

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }

            // for debugging:
            // IO.println("After pass " + i + ": " + Arrays.toString(arr));
        }
    }
}