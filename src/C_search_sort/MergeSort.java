package C_search_sort;

/*
Merge sort: Repeatedly divides the array in half, sorts each half,
and combines the sorted halves into a sorted whole. We will
implement it recursively.

To sort an array:
- If the array's length is 0 or 1, we're done.
- Divide the array into two roughly equal halves.
    Exactly equal halves if the length is even.
    If length is odd, then left side will be one element shorter than right side.
- Recursively sort the left half.
- Recursively sort the right half.
- Merge the two sorted arrays into one sorted array.

An example of a "divide and conquer" algorithm.

{32,  14,  27,  76,  23,  41,  85,  58,  17}
             /               \
{32,  14,  27,  76} {23,  41,  85,  58,  17}
   /         \          /           \
{32,  14} {27,  76} {23,  41} {85,  58,  17}
 /    \     /   \     /    \
{32} {14} {27} {76} {23} {41} {85} {58,  17}
 \    /    \    /    \    /     |   /    \
{14,  32} {27,  76} {23,  41}   |  {58} {17}
    \         /       \         |   \     /
{14,  27,  32,  76}    \        |  {17,  58}
       \                \        \     /
        \                \    {17,  58,  85}
         \                \          /
          \         {17,  23,  41,  58,  85}
           \                   /
{14,  17,  23,  27,  32,  41,  58,  76,  85}


{32,  14,  27,  76,  23,  41,  85,  58}
{32,  14,  27,  76} {23,  41,  85,  58}
{32,  14} {27,  76} {23,  41} {85,  58}
{32} {14} {27} {76} {23} {41} {85} {58}
{14,  32} {27,  76} {23,  41} {58,  85}
{14,  27,  32,  76} {23,  41,  58,  85}
{14,  23,  27,  32,  41,  58,  76,  85}
 */

import java.util.Arrays;

public class MergeSort {
    static void main() {
        int[] arr = {32, 14, 27, 76, 23, 41, 85, 58};
        mergeSort(arr);
    }

    public static void mergeSort(int[] a) {
        // for debugging:
        // IO.println("sorting " + Arrays.toString(a));

        // implicit base case:
        // if a.length <= 1, do nothing (already sorted)

        if (a.length > 1) { // if we are not in the base case
            // split array into roughly two halves
            int[] left = Arrays.copyOfRange(a, 0, a.length / 2);
            int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);

            // recursively sort the two halves
            mergeSort(left);
            mergeSort(right);

            // merge the sorted halves into a
            merge(left, right, a);
        }
    }

    //              *                       *
    // {5, 7, 7, 10} {2, 3, 5, 6, 8, 11, 12}
    //
    //                                    *
    // {2, 3, 5, 5, 6, 7, 7, 8, 10, 11, 12}

    // merge sorted arrays arr1 and arr2 together,
    // putting the elements in the result array in sorted order
    private static void merge(int[] arr1, int[] arr2, int[] result) {
        // for debugging:
        // IO.println("merging " + Arrays.toString(arr1) + " and " + Arrays.toString(arr2));

        int index1 = 0;      // current index in arr1
        int index2 = 0;      // current index in arr2
        int resultIndex = 0; // current index in result

        // loop until we reach the end of arr1 or arr2
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] < arr2[index2]) {
                result[resultIndex++] = arr1[index1++];
            } else {
                result[resultIndex++] = arr2[index2++];
            }
        }

        // at this point, we've reached the end of either arr1 or arr2,
        // but we don't know which array has the remaining elements

        // get any remaining elements from arr1
        while (index1 < arr1.length) {
            result[resultIndex++] = arr1[index1++];
        }

        // get any remaining elements from arr2
        while (index2 < arr2.length) {
            result[resultIndex++] = arr2[index2++];
        }
    }
}