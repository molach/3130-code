import G_comparing.A_comparable.Product;
import G_comparing.A_comparable.Student;

void main() {
    IO.println("a".compareTo("r")); // negative int
    IO.println("r".compareTo("a")); // positive int
    IO.println("a".compareTo("a")); // 0
    IO.println();

    String[] stringArray = {"car", "train", "bus"};
    Arrays.sort(stringArray); // uses String's compareTo method to compare the elements with each other
    IO.println(Arrays.toString(stringArray));
    IO.println();

    // Arrays.sort(arr) works only if the elements of arr
    // come from a class that implements Comparable.
    // It's not enough for the class to simply have a compareTo method;
    // the class must explicitly state that it implements Comparable.

    // For a List, we can use Collections.sort
    List<String> stringList = new ArrayList<>();
    stringList.add("car");
    stringList.add("train");
    stringList.add("bus");
    IO.println(stringList);
    Collections.sort(stringList); // uses String's compareTo
    IO.println(stringList);

    // we can make our own classes implement the Comparable interface

    IO.println(new Student("John", 1111).compareTo(new Student("Jane", 2222))); // a negative int

    Student[] students = {
            new Student("Jane", 56789),
            new Student("John", 12345),
            new Student("Joe", 11111)
    };
    IO.println(Arrays.toString(students));
    Arrays.sort(students);
    // Arrays.sort calls Student's compareTo on the elements of
    // the array, after making sure that they implement Comparable
    IO.println(Arrays.toString(students));


    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student("John", 222));
    studentList.add(new Student("Joe", 333));
    studentList.add(new Student("Jane", 111));
    Collections.sort(studentList);

    Product[] products = {
            new Product(666, "apple", 1.25),
            new Product(555, "apple", 1.05),
            new Product(444, "bread", 2.25),
            new Product(333, "bread", 2.25),
            new Product(222, "milk", 1.75),
            new Product(111, "almonds", 1.25)
    };

    Arrays.sort(products); // uses Product's compareTo method

    for (Product product : products) {
        IO.println(product);
    }
}