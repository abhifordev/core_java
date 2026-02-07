package dev.abhi.interfaces;
interface Vehicle {
    // Abstract method - must implement
    void start();
    void stop();

    // Default method - implementation provided, optional to override
    default void honk() {
        System.out.println("Vehicle is honking: Beep Beep!");
    }

    default void displayInfo() {
        System.out.println("This is a vehicle");
    }

    // Static method - called using interface name
    static void service() {
        System.out.println("Vehicle service completed");
    }

    static int getWheels() {
        return 4;  // Default wheels
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started with key");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped with brake");
    }

    // Optional - can override default method
    @Override
    public void displayInfo() {
        System.out.println("This is a Car");
    }
}

class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike started with kick");
    }

    @Override
    public void stop() {
        System.out.println("Bike stopped with brake lever");
    }

    // Not overriding honk() - will use default
    // Not overriding displayInfo() - will use default
}

// Multiple inheritance problem solved by default methods
interface Printable {
    default void print() {
        System.out.println("Printing from Printable");
    }
}

interface Showable {
    default void print() {
        System.out.println("Printing from Showable");
    }
}

class Document implements Printable, Showable {
    // Must override if multiple interfaces have same default method
    @Override
    public void print() {
        System.out.println("Printing from Document");
        // Can call specific interface method if needed
        Printable.super.print();
        Showable.super.print();
    }
}

public class DefaultStaticMethods {
    public static void main(String[] args) {

        System.out.println("--- Default Methods ---");

        Vehicle car = new Car();
        car.start();
        car.honk();          // Using default method
        car.displayInfo();   // Using overridden method
        car.stop();

        System.out.println();

        Vehicle bike = new Bike();
        bike.start();
        bike.honk();         // Using default method
        bike.displayInfo();  // Using default method (not overridden)
        bike.stop();

        // Static method - call using interface name
        System.out.println("\n--- Static Methods ---");
        Vehicle.service();
        System.out.println("Default wheels: " + Vehicle.getWheels());

        // Cannot call static method on object
        // car.service();  // ERROR

        // Multiple inheritance with default methods
        System.out.println("\n--- Multiple Inheritance Conflict ---");
        Document doc = new Document();
        doc.print();

        // Key points:
        // Default methods:
        //   - Provide implementation in interface
        //   - Optional to override
        //   - Accessed via object
        //   - Added in Java 8 for backward compatibility
        //
        // Static methods:
        //   - Called using Interface name
        //   - Cannot be overridden
        //   - Utility methods
    }
}
//```
//
//        **Output:**
//        ```
//        --- Default Methods ---
//Car started with key
//Vehicle is honking: Beep Beep!
//This is a Car
//Car stopped with brake
//
//Bike started with kick
//Vehicle is honking: Beep Beep!
//This is a vehicle
//Bike stopped with brake lever
//
//--- Static Methods ---
//Vehicle service completed
//Default wheels: 4
//
//        --- Multiple Inheritance Conflict ---
//Printing from Document
//Printing from Printable
//Printing from Showable