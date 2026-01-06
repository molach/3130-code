void main() {
}

// time complexity: O(n)
// space complexity: O(1)
double max(double[] arr) {
    double maxSoFar = arr[0];

    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > maxSoFar) {
            maxSoFar = arr[i];
        }
    }

    return maxSoFar;
}

// time complexity: O(n)
// space complexity: O(n)
void m1(int n) {
    int[] arr = new int[n];
}