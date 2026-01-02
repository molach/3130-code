void main() {
    IO.println(average()); // 0
    IO.println(average(5, 10));
    IO.println(average(5, 10, 15));

    int[] a = {6, 7};
    IO.println(average(a));
}

// System.out.printf(String formatString, Object... args)
// Objects.hash(...)
// List.of(...)

// a method with a vararg parameter
int average(int... nums) {
    int sum = 0;

    for (int num : nums) {
        sum += num;
    }

    return sum / nums.length;
}