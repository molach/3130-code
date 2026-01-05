package C_search_sort;

/*
  0   1   2   3   4   5   6   7   8   9  10  11  12  13  14
[11, 18, 29, 37, 42, 49, 51, 63, 69, 72, 77, 82, 88, 91, 98]

Searching for 77:
low    mid   high
 0      7     14
 8     11     14
 8      9     10
10     10     10
We return 10, since 77 is at index 10
Note that we examine only four elements, namely those at indexes 7, 11, 9, and 10.
Linear search would've examined eleven elements!

Notice that we keep dividing the problem size in half: 15 --> 7 --> 3 --> 1
This corresponds to log_2(n), where n = arr.length.
If n = 1,000,000, log_2(n) is approximately 20, which is amazing.

Searching for 82:
low    mid   high
 0      7     14
 8     11     14
Returns 11.

Searching for 76:
low    mid   high
 0      7     14
 8     11     14
 8      9     10
10     10     10
10             9
Returns -1.

Searching for 5:
low mid high
  0   7  14
  0   3   6
  0   1   2
  0   0   0
  0      -1
Returns -1.

The algorithm stops when:
- we find the desired value, or
- when low > high
 */
 
public class BinarySearch {
    static void main() {
        int[] arr = {11, 18, 29, 37, 42, 49, 51, 63, 69, 72, 77, 82, 88, 91, 98};
        IO.println(binarySearchIterative(arr, 82));
        IO.println(binarySearchIterative(arr, 5));
    }

    // Given a *sorted* array and a value to search for, very efficiently
    // returns an index where the value appears in the array, or -1 if it
    // doesn't appear.
    public static int binarySearchIterative(int[] arr, int value) {
        // for debugging
        // IO.println("low mid high");

        int lowIndex = 0, highIndex = arr.length - 1;
 
        while (lowIndex <= highIndex) {
            // int middleIndex = (lowIndex + highIndex) / 2;
            // The above works for typical arrays, but not for really large ones, due to integer overflow.
            // The following is a correct approach:
            int distance = highIndex - lowIndex;
            int halfDistance = distance / 2;
            int middleIndex = lowIndex + halfDistance;

            // for debugging:
            // IO.println("%3d %3d %3d".formatted(lowIndex, middleIndex, highIndex));
 
            if (value == arr[middleIndex]) {
                return middleIndex;
            } else if (value < arr[middleIndex]) {
                highIndex = middleIndex - 1;
            } else { // value > arr[middleIndex]
                lowIndex = middleIndex + 1;
            }
        }

        // for debugging:
        // IO.println("%3d     %3d".formatted(lowIndex, highIndex));
 
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int value) {
        return binarySearchRecursive(arr, value, 0, arr.length - 1);
    }
 
    private static int binarySearchRecursive(int[] arr, int value, int lowIndex, int highIndex) {
        if (lowIndex > highIndex) {
            return -1;
        }
 
        int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
 
        if (value == arr[middleIndex]) {
            return middleIndex;
        } else if (value < arr[middleIndex]) {
            return binarySearchRecursive(arr, value, lowIndex, middleIndex - 1);
        } else { // value > arr[middleIndex]
            return binarySearchRecursive(arr, value, middleIndex + 1, highIndex);
        }
    }
}