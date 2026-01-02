package B_recursion;

public class Sum {
    static void main() {
        double[] arr = {4, 2, 5, 1, 3};
        IO.println(sum(arr));
    }

    // a public "wrapper" method; this is the method the client calls
    public static double sum(double[] arr) {
        return sum(arr, 0);
    }

    // returns the sum of the elements of arr from startIndex and onwards
    private static double sum(double[] arr, int startIndex) {
        if (startIndex >= arr.length) { // no further elements to look at
            return 0;
        } else {
            return arr[startIndex] + sum(arr, startIndex + 1);
        }
    }
}