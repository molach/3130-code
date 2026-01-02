void main() {
    IO.println(fib(4)); // 3
    // total number of frames used by fib(4): 9
    // max frames used at same time for fib(4): 4
}

// n       0  1  2  3  4  5  6   7 ...
// fib(n)  0  1  1  2  3  5  8  13 ...
int fib(int n) {
    if (n < 0) {
        throw new IllegalArgumentException();
    }

    if (n == 0 || n == 1) {
        return n;
    } else {
        return fib(n - 2) + fib(n - 1);
    }
}