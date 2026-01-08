package G_comparing.B_comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
}

record Student(String name, int id) {}

class StudentIdComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.id(), s2.id());
    }
}

class ComparatorDemo {
    void main() {
        // using natural order
        IO.println("bird".compareTo("cat")); // negative int
        IO.println("dog".compareTo("cat")); // positive int

        Comparator<String> byLength = new StringLengthComparator();
        IO.println(byLength.compare("bird", "cat")); // positive int
        IO.println(byLength.compare("dog", "cat")); // 0

        String[] stringArray = {"rabbit", "cat", "bird"};
        // Arrays.sort(stringArray); // sorts the array using natural order
        Arrays.sort(stringArray, byLength); // sorts the array based on the provided Comparator
        IO.println(Arrays.toString(stringArray)); // [cat, bird, rabbit]

        Student[] students = {
                new Student("John", 56789),
                new Student("Jane", 12345),
                new Student("Jill", 11111)
        };

        // Arrays.sort(students);
        // ClassCastException at runtime because (this
        // version of) Student doesn't implement Comparable

        Comparator<Student> byId = new StudentIdComparator();
        Arrays.sort(students, byId);
        IO.println("sorted ascending by id: " + Arrays.toString(students));

        List<Student> studentList = new ArrayList<>(List.of(
                new Student("John", 56789),
                new Student("Jane", 12345),
                new Student("Jill", 11111)
        ));
        // Collections.sort(studentList); // doesn't compile
        // because Student doesn't implement Comparable

        // Collections.sort(studentList, byId);
        // better yet:
        studentList.sort(byId);
    }
}