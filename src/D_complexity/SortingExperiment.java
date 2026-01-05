import C_search_sort.BubbleSort;
import C_search_sort.MergeSort;
import C_search_sort.SelectionSort;

void main() {
    final int START = 1_000, STOP = 2_000_000;

    IO.println("using merge sort:");
    for (int n = START; n <= STOP; n *= 2) {
        int[] arr = getRandomArray(n);
        long startTime = System.currentTimeMillis();
        MergeSort.mergeSort(arr);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        IO.println("n: %,12d took %,12d milliseconds".formatted(n, elapsed));
    }

    IO.println("using selection sort:");
    for (int n = START; n <= STOP; n *= 2) {
        int[] arr = getRandomArray(n);
        long startTime = System.currentTimeMillis();
        SelectionSort.selectionSort(arr);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        IO.println("n: %,12d took %,12d milliseconds".formatted(n, elapsed));
    }

    IO.println("using bubble sort:");
    for (int n = START; n <= STOP; n *= 2) {
        int[] arr = getRandomArray(n);
        long startTime = System.currentTimeMillis();
        BubbleSort.bubbleSortWithOptimization(arr);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        IO.println("n: %,12d took %,12d milliseconds".formatted(n, elapsed));
    }
}

int[] getRandomArray(int length) {
    Random randomGenerator = new Random();
    int[] arr = new int[length];

    for (int i = 0; i < arr.length; i++) {
        arr[i] = randomGenerator.nextInt();
    }

    return arr;
}
