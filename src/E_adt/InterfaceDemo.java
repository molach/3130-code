package E_adt;

interface Shape {
    double area();
    double perimeter();

    // A default method, that is, a non-abstract instance method in an interface.
    default void printInfo() {
        IO.println("area = " + area() + ", perimeter = " + perimeter());
        // Notice that a non-abstract method can call an abstract method!
        // This works because implementing classes are required to
        // override all abstract methods.
    }
}

record Circle(double radius) implements Shape {
    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public double diameter() {
        return 2 * radius;
    }
}

record Rectangle(double length, double width) implements Shape {
    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

public class InterfaceDemo {
    static void main() {
        Shape c = new Circle(5);
        c.printInfo(); // area = 78.53981633974483, perimeter = 31.41592653589793

        Shape r = new Rectangle(10, 15);
        r.printInfo(); // area = 150.0, perimeter = 50.0
    }
}