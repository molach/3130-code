void main() {
}

// We'll call arr.length n.
// Approximately how many steps does this method perform?
//   2             at the beginning
// + 1             loop initialization
// + 2n            loop test
// + n - 1         loop update
// + 4 * (n - 1)   loop body
// + 1             at end
// = 2 + 1 + 2n + n - 1 + 4 * (n - 1) + 1
// = 2n + n + 4n + 2 + 1 - 1 - 4 + 1
// = 7n - 1
// We say that this method has a running time of O(n).
double max(double[] arr) {
    double maxSoFar = arr[0];

    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > maxSoFar) {
            maxSoFar = arr[i];
        }
    }

    return maxSoFar;
}

// O(1)
double middle(double[] arr) {
    return arr[arr.length / 2];
}

// O(1)
void m1(int n) {
    int sum = 0;
    for (int i = 0; i < 100_000; i++) { // 100,000 times
        sum++;
    }
    IO.println(sum);
}

// O(n)
void m2(int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) { // n times
        sum++;
    }
    IO.println(sum);
}

//   1 + 5n^2 + 100n + 1
// = 5n^2 + 100n + 2
// which is O(n^2)
void m3(int n) {
    int sum = 0;

    for (int i = 0; i < 5 * n * n; i++) { // 5n^2 times
        sum++;
    }

    for (int i = 0; i < 100 * n; i++) { // 100n
        sum++;
    }

    IO.println(sum);
}

//   1 + (5n^2)*(100n) + 1
// = 100n^3 + 2
// which is O(n^3)
void m4(int n) {
    int sum = 0;

    for (int i = 0; i < 5 * n * n; i++) { // 5n^2 times
        for (int j = 0; j < 100 * n; j++) { // 100n times
            sum++;
        }
    }

    IO.println(sum);
}

// n * n^2
// O(n^3)
void m5(int n) {
    int sum = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n * n; j++) {
            sum++;
        }
    }

    IO.println(sum);
}

// n * n^2 * n = n^4
// O(n^4)
void m6(int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n * n; j++) {
            for (int k = 0; k < n; k++) {
                sum++;
            }
        }
    }
    IO.println(sum);
}

/*
How many times does sum++ run in method m7?
i:             0   1   2   3         n-1
sum++ runs:    1 + 2 + 3 + 4 + .... + n

Formula:
1 + 2 + 3 + 4 + .... + n
= (n*(n + 1)) / 2
= (n^2 + n) / 2
= (1/2)n^2 + (1/2)n
which is O(n^2)
*/
void m7(int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j <= i; j++) {
            sum++;
        }
    }
    IO.println(sum);
}

//   (2n - 2)(n + 4)
// = 2n^2 + 8n - 2n - 8
// = 2n^2 + 6n - 8
// O(n^2)
void m8(int n) {
    int sum = 0;
    for (int i = 1; i <= 2 * n - 2; i++) { // 2n-2 times
        for (int j = 1; j <= n + 4; j++) { // n+4 times
            sum++;
        }
    }
    IO.println(sum);
}

/*
Formula:
  1 + 2 + 3 + 4 + 5 + .... + n
= (1/2)n^2 + (1/2)n

How many times does sum++ run in method m9?
i: 1   2   3           n-3       n-2
   5 + 6 + 7 + ... + (n-3)+4 + (n-2)+4
=  5 + 6 + 7 + ... + (n+1) + (n+2)
= (1 + 2 + 3 + 4 + 5 + .... + n) - (1 + 2 + 3 + 4) + (n+1) + (n+2)
= (1/2)n^2 + (1/2)n - 10 + (n+1) + (n+2)
which is O(n^2)
*/
void m9(int n) {
    int sum = 0;
    for (int i = 1; i <= n - 2; i++) { // n - 2 times
        for (int j = 1; j <= i + 4; j++) {
            sum++;
        }
    }
    IO.println(sum);
}

/*
approximately log base 3 of n
which is O(log n)
*/
void m10(int n) {
    while (n > 1) {
        IO.println(n);
        n /= 3;
    }
}

/*
approximately log base 5 of n
which is O(log n)
*/
void m11(int n) {
    int a = 1;

    while (a <= n) {
        a *= 5;
    }
}

// O(n log n)
void m12(int n) {
    for (int i = 0; i < n; i++) {
        int a = 1;

        while (a <= n) {
            a *= 5;
        }
    }
}

// O(n)
void m13(int n) {
    for (int i = 0; i < n; i++) {

    }

    int a = 1;

    while (a <= n) {
        a *= 5;
    }
}

// O(1)
void swap(int[] list, int i, int j) {
    int temp = list[i];
    list[i] = list[j];
    list[j] = temp;
}

void selectionSort(int[] a) {
    for (int i = 0; i < a.length - 1; i++) {
        int indexOfMin = i;

        for (int j = i + 1; j < a.length; j++) {
            if (a[j] < a[indexOfMin]) {
                indexOfMin = j;
            }
        }

        swap(a, i, indexOfMin);
    }
}

/*
Approximately how many steps does selection sort require for an
array of length n?
- We need to make n - 1 iterations (passes) of the outer loop.
- In the first pass, we need to search through all n elements of
  the array to find the min, which takes about n steps.
- In the second pass, we need to search through n - 1 elements of
  the array to find the min, which takes about n - 1 steps.
- In the third pass, we need to search through n - 2 elements of
  the array to find the min, which takes about n - 2 steps.
- And so on.
- In total, we must perform approximately
    n + (n - 1) + (n - 2) + ... + 2 + 1
  steps.
- Formula:
    1 + 2 + 3 + ... + n = (1/2)n(n + 1) = (1/2)n^2 + (1/2)n.
- Focusing on the term with the highest degree and ignoring the
  multiplicative constant, we are left with n^2.
- Thus we say that the running time of selection sort is O(n^2)
  ["big-O of n squared"].
*/