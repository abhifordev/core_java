package dev.abhi.oops;
// Abstraction = Essential details dikhana, complex details chhupana
// Abstract class ya Interface use karte

// Abstract class - cannot create object directly
abstract class Vehicle {
    String name;

    public Vehicle(String name) {
        this.name = name;
    }

    // Abstract method - no body, child ko implement karna padega
    public abstract void start();
    public abstract void stop();

    // Concrete method - body hai, reuse ho sakta
    public void honk() {
        System.out.println(name + " is honking: Beep Beep!");
    }
}

// Car - Vehicle ko implement karta
class Car extends Vehicle {

    public Car(String name) {
        super(name);
    }

    // Abstract methods ko implement karna compulsory
    @Override
    public void start() {
        System.out.println(name + " car started with key ignition");
    }

    @Override
    public void stop() {
        System.out.println(name + " car stopped with brake pedal");
    }
}

// Bike - Vehicle ko implement karta
class Bike extends Vehicle {

    public Bike(String name) {
        super(name);
    }

    @Override
    public void start() {
        System.out.println(name + " bike started with kick/self start");
    }

    @Override
    public void stop() {
        System.out.println(name + " bike stopped with brake lever");
    }
}

// Interface - 100% abstraction (all methods abstract by default)
interface Payment {
    void processPayment(double amount);  // No body
    void refund(double amount);
}

// Implementation
class CreditCard implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing " + amount + " via Credit Card");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding " + amount + " to Credit Card");
    }
}

class UPI implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing " + amount + " via UPI");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding " + amount + " to UPI");
    }
}

public class AbstractionDemo {
    public static void main(String[] args) {

        System.out.println("--- Abstract Class Example ---\n");

        // Vehicle vehicle = new Vehicle("Generic");  // ERROR - abstract class ka object nahi ban sakta

        Vehicle car = new Car("Honda City");
        Vehicle bike = new Bike("Royal Enfield");

        // User ko sirf ye pata hai ki start() aur stop() hai
        // Internal implementation hidden hai - ABSTRACTION
        car.start();
        car.honk();
        car.stop();

        System.out.println();

        bike.start();
        bike.honk();
        bike.stop();

        System.out.println("\n--- Interface Example ---\n");

        Payment payment1 = new CreditCard();
        Payment payment2 = new UPI();

        // User ko implementation nahi pata, sirf methods pata hain
        payment1.processPayment(5000);
        payment2.processPayment(3000);

        System.out.println();

        payment1.refund(500);
        payment2.refund(300);

        // Abstraction benefits:
        // 1. Implementation details hide - user ko complexity nahi dikhti
        // 2. Security - internal logic hidden
        // 3. Flexibility - implementation change kar sakte without affecting user
        // 4. Focus on WHAT to do, not HOW to do

        // Abstract Class vs Interface:
        // Abstract Class: Can have both abstract & concrete methods, single inheritance
        // Interface: All methods abstract (Java 8+ default allowed), multiple inheritance
    }
}
//
//
//Honda City car started with key ignition
//Honda City is honking: Beep Beep!
//Honda City car stopped with brake pedal
//
//Royal Enfield bike started with kick/self start
//Royal Enfield is honking: Beep Beep!
//Royal Enfield bike stopped with brake lever
//
//--- Interface Example ---
//
//Processing 5000.0 via Credit Card
//Processing 3000.0 via UPI
//
//Refunding 500.0 to Credit Card
//Refunding 300.0 to UPI

//        4 Pillars of OOP:
//
//        1. ENCAPSULATION (Data Hiding):
//        - Private data + Public methods
//   - Getters/Setters
//   - Controlled access
//Example: BankAccount balance private hai
//
//2. INHERITANCE (Code Reuse):
//        - Parent-Child relationship
//   - extends keyword
//   - IS-A relationship
//Example: Dog IS-A Animal
//
//3. POLYMORPHISM (Many Forms):
//        - Method Overloading (compile-time)
//   - Method Overriding (runtime)
//   - Same method, different behavior
//Example: Shape.draw() - Circle/Rectangle different
//
//4. ABSTRACTION (Hide Complexity):
//        - Abstract class/Interface
//   - Hide implementation details
//   - Show only essential info
//Example: Vehicle.start() - implementation hidden
//
//Remember: "Encapsulation me DATA hide, Abstraction me IMPLEMENTATION hide"