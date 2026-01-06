void main() {
}

// time complexity: O(n)
// space complexity: O(n) [due to the n + 1 stack frames]
int factorial(int n) {
    if (n < 0) {
        throw new IllegalArgumentException();
    }

    if (n == 0) {
        return 1;
    } else {
        return n * factorial(n - 1);
    }
}