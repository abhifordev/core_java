package dev.abhi.interfaces;
// Interface - contract/blueprint
// All methods abstract by default (until Java 8)
interface Animal {
    // Public abstract by default
    void eat();
    void sleep();
}

// Multiple interfaces implement kar sakte
interface Pet {
    void play();
}

// Class implements interface
class Dog implements Animal, Pet {
    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping");
    }

    @Override
    public void play() {
        System.out.println("Dog is playing fetch");
    }
}

class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Cat is sleeping");
    }
}

// Interface can extend another interface
interface WildAnimal extends Animal {
    void hunt();
}

class Lion implements WildAnimal {
    @Override
    public void eat() {
        System.out.println("Lion is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Lion is sleeping");
    }

    @Override
    public void hunt() {
        System.out.println("Lion is hunting");
    }
}

public class InterfaceBasics {
    public static void main(String[] args) {

        System.out.println("--- Interface Implementation ---");

        // Interface reference, implementation object
        Animal dog = new Dog();
        dog.eat();
        dog.sleep();

        System.out.println();

        Animal cat = new Cat();
        cat.eat();
        cat.sleep();

        // Multiple interface implementation
        System.out.println("\n--- Multiple Interfaces ---");
        Dog myDog = new Dog();
        myDog.eat();    // Animal interface
        myDog.play();   // Pet interface

        // Interface inheritance
        System.out.println("\n--- Interface Inheritance ---");
        WildAnimal lion = new Lion();
        lion.eat();
        lion.sleep();
        lion.hunt();

        // Polymorphism with interfaces
        System.out.println("\n--- Polymorphism ---");
        Animal[] animals = {new Dog(), new Cat(), new Lion()};

        for(Animal animal : animals) {
            animal.eat();
        }

        // Interface key points:
        // 1. Cannot create object of interface
        // 2. All methods public abstract by default
        // 3. Variables are public static final (constants)
        // 4. Class can implement multiple interfaces
        // 5. Interface can extend multiple interfaces
    }
}
//        --- Interface Implementation ---
//Dog is eating
//Dog is sleeping
//
//Cat is eating
//Cat is sleeping
//
//--- Multiple Interfaces ---
//Dog is eating
//Dog is playing fetch
//
//--- Interface Inheritance ---
//Lion is eating
//Lion is sleeping
//Lion is hunting
//
//--- Polymorphism ---
//Dog is eating
//Cat is eating
//Lion is eating