package C_search_sort;

import java.util.Random;

public class BogoSort {
    // A bogus sorting algorithm.
    // It's bogus because it might never terminate.
    // But if it terminates, the array is now sorted.
    public static void bogoSort(int[] arr) {
        while (!isSorted(arr)) {
            shuffle(arr);
        }
    }

    // determines whether the elements of the array are sorted
    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }

    // puts the elements of the array into some random order
    private static void shuffle(int[] arr) {
        Random randomGenerator = new Random();

        for (int i = 0; i < arr.length; i++) {
            int randomIndex = randomGenerator.nextInt(arr.length);
            swap(arr, i, randomIndex);
        }
    }

    // swaps arr[i] with arr[j]
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}