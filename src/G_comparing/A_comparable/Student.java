package G_comparing.A_comparable;

public record Student(String name, int id) implements Comparable<Student> {
    /**
     * Compares two students based on their IDs.
     * A student with a lower ID number is considered to be
     * less than a student with a higher ID number.
     *
     * @param other The Student to compare with this Student
     * @return a positive integer if this student has a greater id than the other student,
     * a negative integer if this student has a lower id than the other student,
     * 0 if they have equal IDs
     */
    @Override
    public int compareTo(Student other) {
        // works, but verbose:
        // if (this.id > other.id) {
        //   return 55;
        // } else if (this.id < other.id) {
        //   return -190;
        // } else {
        //   return 0;
        // }

        // hackish way: return this.id - other.id;
        // Why "hackish"?
        // Consider this case: this.id = -2_000_000_000 and other.id = 1_000_000_000
        // We want the method to return a negative int, but it will incorrectly return a positive int.

        // best way:
        return Integer.compare(this.id, other.id);
    }
}