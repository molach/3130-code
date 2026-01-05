// Demonstrates some useful methods of the java.util.Arrays class:
// toString(arr), sort(arr), binarySearch(arr, val)
void main() {
    int[] a = {5, 2, 12, 45, 17};
    IO.println(Arrays.toString(a)); // [5, 2, 12, 45, 17]

    Arrays.sort(a);
    IO.println(Arrays.toString(a)); // [2, 5, 12, 17, 45]

    IO.println(Arrays.binarySearch(a, 17)); // 3
}