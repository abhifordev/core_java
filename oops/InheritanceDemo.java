package dev.abhi.oops;
// Inheritance = Parent class ki properties aur methods ko child inherit karta hai
// IS-A relationship

// Parent class (Superclass)
class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating");
    }

    public void sleep() {
        System.out.println(name + " is sleeping");
    }
}

// Child class 1 - Dog IS-A Animal
class Dog extends Animal {

    public Dog(String name) {
        super(name);  // Parent constructor call
    }

    // Dog ki apni special method
    public void bark() {
        System.out.println(name + " is barking: Woof Woof!");
    }
}

// Child class 2 - Cat IS-A Animal
class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    // Cat ki apni special method
    public void meow() {
        System.out.println(name + " is meowing: Meow Meow!");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {

        Dog dog = new Dog("Tommy");
        Cat cat = new Cat("Kitty");

        // Dog parent ki methods use kar sakta - INHERITED
        dog.eat();    // Animal class se
        dog.sleep();  // Animal class se
        dog.bark();   // Dog ki apni method

        System.out.println();

        // Cat bhi parent ki methods use kar sakta
        cat.eat();
        cat.sleep();
        cat.meow();

        // Inheritance benefits:
        // 1. Code reuse - eat(), sleep() dubara likhne ki zaroorat nahi
        // 2. Hierarchical organization
        // 3. Easy to maintain aur extend

        // Types of inheritance:
        // Single: Dog -> Animal
        // Multilevel: Puppy -> Dog -> Animal
        // Hierarchical: Dog -> Animal <- Cat
        // Multiple: NOT supported in Java (use interfaces)
    }
}