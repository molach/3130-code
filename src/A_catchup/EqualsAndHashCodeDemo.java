package A_catchup;

import java.util.Objects;

/*
Every class in Java inherits from the class named Object either
directly or indirectly. (The only exception is the Object class
itself -- it does not inherit from anything.) If a class does not
explicitly extend another class, then it implicitly extends Object.
For example, the PersonWithNoEquals class, below, directly inherits
from Object. If PersonWithNoEquals had a subclass C, then C would
directly extend PersonWithNoEquals and indirectly extend Object.

Here's the documentation of the Object class: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/Object.html
You are not expected to understand most of this documentation.
We will focus on the toString(), equals(), and hashCode() methods of the Object class.
*/

class PersonWithNoEquals { // class PersonWithNoEquals extends Object
    private String name;
    private int age;

    public PersonWithNoEquals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}

class PersonWithOverloadedEquals {
    private String name;
    private int age;

    public PersonWithOverloadedEquals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*
    The following shows the naive 3115 style of writing an equals method.
    This method does not override the equals method of the Object class,
    since the equals method of the Object class has a parameter of type Object,
    not of type Person.
    In fact, we are overLOADING the equals method -- we're writing another
    method with the same name but different parameter type.
    Important: you should generally NOT write an equals method in this style.
    */
    public boolean equals(PersonWithOverloadedEquals other) {
        return this.name.equals(other.name) && this.age == other.age;
    }
}

class PersonWithOverriddenEquals {
    private String name;
    private int age;

    public PersonWithOverriddenEquals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        // return this.name.equals(o.name) && this.age == o.age;
        // doesn't compile, since Object doesn't have fields name and age

        // PersonWithOverriddenEquals other = (PersonWithOverriddenEquals) o;
        // return this.name.equals(other.name) && this.age == other.age;
        // with the cast, it compiles, and it runs well in many cases, but
        // will cause a ClassCastException if o refers to some other kind
        // of object, which is very possible

        // the following works
        // if (o instanceof PersonWithOverriddenEquals) {
        //     PersonWithOverriddenEquals other = (PersonWithOverriddenEquals) o;
        //     return this.name.equals(other.name) && this.age == other.age;
        // } else {
        //     return false;
        // }

        // nowadays, we can combine the test and the cast:
        return o instanceof PersonWithOverriddenEquals other // a "pattern variable"
                && this.name.equals(other.name) && this.age == other.age;
    }
}

// All the kinds of questions on quizzes and the final exam:
// - write code
// - given code, determine the output
// - "trace" something
// - given code, determine the running time efficiency

/*
When we extend a class, we must make sure that our class does not violate
requirements of the superclass.
The Object class has, in addition to toString and equals, a method named
hashCode(). This method returns an integer that is associated with the
object it was called on.
The version of this method in Object returns (with high probability)
distinct integers for distinct objects. So if we have two separate
objects that are equal according to the equals method, the hashCode()
method will very likely return the same value for both objects.
The specification of the hashCode() method states: if o1.equals(o2),
then we must make sure that o1.hashCode() == o2.hashCode().
If we override equals, making distinct objects considered equal, we are
in violation hashCode()'s requirement, unless we also override hashCode().
Bottom line: if you override equals, you almost certainly have to
override hashCode() as well.

How to override hashCode()? We could just have it always return the same int,
say 42. That is legal, as there is no requirement that unequal object have
unequal hash codes.
But this approach leads to slow performance of HashSet and HashMap (covered
later in this course).
The best approach to writing a hashCode() method is to create an int based
on the fields of the object. Doing this yourself is not easy, but there's a
shortcut: Objects.hash(...)
We can pass as many fields as we want to Objects.hash(...), and it will
return an integer based on those fields.
The fields that we send to this method should be the same as those that are
used in the equals method.
When we use Objects.hash(...) correctly, we are guaranteed to have equal
hash codes for equal objects. Additionally, it is very, very likely that
unequal objects will have unequal hash codes, though this cannot be guaranteed.
(The is because there are more possible objects than there are legal Java ints.)
 */

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Person other
                && this.name.equals(other.name) && this.age == other.age;
    }

    @Override
    public int hashCode() {
        // return 42; // legal approach, but not useful

        // good approach:
        return Objects.hash(name, age);
    }
}

class EqualsAndHashCodeDemo {
    void main() {
        PersonWithNoEquals p1 = new PersonWithNoEquals("John", 25);
        IO.println(p1.toString());
        IO.println(p1);
        // The default toString() method, inherited from Object,
        // returns a String containing the name of the class along
        // with its package, followed by the '@' sign, followed by
        // the hexadecimal representation of the object's hash code.
        // We override the default toString() method in most classes.

        PersonWithNoEquals p2 = new PersonWithNoEquals("John", 25);
        IO.println(p1 == p2); // false
        IO.println(p1.equals(p2)); // false
        // PersonWithNoEquals inherits Object's equals method.
        // That method does not compare the contents of two objects.
        // It's just like asking whether p1 == p2, which is false.

        PersonWithOverloadedEquals p3 = new PersonWithOverloadedEquals("John", 25);
        PersonWithOverloadedEquals p4 = new PersonWithOverloadedEquals("John", 25);
        IO.println(p3.equals(p4)); // true, calls our equals method
        Object p5 = new PersonWithOverloadedEquals("John", 25);
        IO.println(p3.equals(p5)); // false, calls Object's equals method

        PersonWithOverriddenEquals p6 = new PersonWithOverriddenEquals("John", 25);
        IO.println(p6.equals("hello")); // false
        Object p7 = new PersonWithOverriddenEquals("John", 25);
        IO.println(p6.equals(p7)); // true, calls our equals method
        PersonWithOverriddenEquals p8 = new PersonWithOverriddenEquals("John", 25);
        IO.println(p6.equals(p8)); // true, calls our method

        IO.println(p6.hashCode()); // some integer
        IO.println(p7.hashCode()); // some other integer (almost certainly)
        IO.println(p8.hashCode()); // yet another integer (almost certainly)

        Person p9 = new Person("John", 25);
        Object p10 = new Person("John", 25);
        IO.println(p9.hashCode());
        IO.println(p10.hashCode());
        // p9 and p10 definitely have the same hash code
        Person p11 = new Person("Jane", 25);
        IO.println(p11.hashCode());
        // p11 will almost certainly have a different hash code than p9 and p10
    }
}