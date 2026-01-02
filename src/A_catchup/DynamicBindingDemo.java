package A_catchup;

/*
Dynamic binding: When an overridden method is called, the determination of which
version should be executed is performed at runtime, and the decision is made
automatically based on the type of object (not the type of variable).
 */

class Animal {
    void makeSound() {
        IO.print("Animal... ");
        sound();
    }

    void sound() {
        IO.println("makes a sound");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        IO.println("Cat... ");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        IO.println("barks");
    }

    void chewBone() {
        IO.println("Chewing bone");
    }
}

class DynamicBindingDemo {
    void main() {
        Animal a1 = new Animal();
        Animal a2 = new Cat();
        Animal a3 = new Dog();

        a1.makeSound(); // Animal... makes a sound
        a2.makeSound(); // Cat...
        a3.makeSound(); // Animal... barks

        // cannot do:
        // a3.chewBone();

        IO.println();

        Animal[] animals = {
                new Animal(),
                new Cat(),
                new Dog()
        };

        for (Animal a : animals) {
            a.makeSound();
        }
        // same output as above
    }
}