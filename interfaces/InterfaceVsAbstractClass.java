package dev.abhi.interfaces;
// Abstract class - partial implementation
abstract class Shape {
    String color;  // Can have instance variables

    // Constructor allowed
    public Shape(String color) {
        this.color = color;
    }

    // Abstract method
    abstract double area();
    abstract double perimeter();

    // Concrete method
    public void display() {
        System.out.println("Shape color: " + color);
    }
}

class Circle extends Shape {
    double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    double area() {
        return 3.14 * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * 3.14 * radius;
    }
}

// Interface - pure abstraction (contract)
interface Drawable {
    void draw();  // What to do
}

interface Resizable {
    void resize(double factor);
}

// Class can implement multiple interfaces but extend only one class
class Rectangle extends Shape implements Drawable, Resizable {
    double length, width;

    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }

    @Override
    double perimeter() {
        return 2 * (length + width);
    }

    @Override
    public void draw() {
        System.out.println("Drawing rectangle");
    }

    @Override
    public void resize(double factor) {
        length *= factor;
        width *= factor;
        System.out.println("Resized to " + length + " x " + width);
    }
}

// Real example: Payment system
interface Payment {
    void processPayment(double amount);
    boolean validatePayment();
}

interface Refundable {
    void refund(double amount);
}

abstract class PaymentMethod implements Payment {
    String accountNumber;

    public PaymentMethod(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Common implementation
    public void logTransaction(String message) {
        System.out.println("Log: " + message);
    }

    // Abstract - child will implement
    @Override
    public abstract void processPayment(double amount);

    @Override
    public boolean validatePayment() {
        return accountNumber != null && !accountNumber.isEmpty();
    }
}

class CreditCard extends PaymentMethod implements Refundable {

    public CreditCard(String cardNumber) {
        super(cardNumber);
    }

    @Override
    public void processPayment(double amount) {
        if(validatePayment()) {
            System.out.println("Processing ₹" + amount + " via Credit Card");
            logTransaction("Payment of ₹" + amount);
        }
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding ₹" + amount + " to Credit Card");
    }
}

class UPI extends PaymentMethod {

    public UPI(String upiId) {
        super(upiId);
    }

    @Override
    public void processPayment(double amount) {
        if(validatePayment()) {
            System.out.println("Processing ₹" + amount + " via UPI");
            logTransaction("UPI payment of ₹" + amount);
        }
    }
}

public class InterfaceVsAbstractClass {
    public static void main(String[] args) {

        System.out.println("--- Shape Examples ---");

        Shape circle = new Circle("Red", 5);
        circle.display();
        System.out.println("Area: " + circle.area());
        System.out.println("Perimeter: " + circle.perimeter());

        System.out.println();

        Rectangle rect = new Rectangle("Blue", 4, 6);
        rect.display();
        System.out.println("Area: " + rect.area());
        rect.draw();      // Interface method
        rect.resize(2);   // Interface method

        System.out.println("\n--- Payment Examples ---");

        PaymentMethod cc = new CreditCard("1234-5678-9012");
        cc.processPayment(5000);
        ((Refundable) cc).refund(500);

        System.out.println();

        PaymentMethod upi = new UPI("user@bank");
        upi.processPayment(3000);

        // Comparison
        System.out.println("\n--- Interface vs Abstract Class ---");
        System.out.println("\nAbstract Class:");
        System.out.println("  - Can have instance variables");
        System.out.println("  - Can have constructors");
        System.out.println("  - Can have concrete methods");
        System.out.println("  - Single inheritance only");
        System.out.println("  - Use: When classes share common code/state");

        System.out.println("\nInterface:");
        System.out.println("  - No instance variables (only constants)");
        System.out.println("  - No constructors");
        System.out.println("  - All methods abstract (before Java 8)");
        System.out.println("  - Multiple inheritance");
        System.out.println("  - Use: Define contract/capability");

        System.out.println("\nWhen to use what:");
        System.out.println("  Abstract Class: IS-A relationship, shared code");
        System.out.println("  Interface: CAN-DO capability, contract");
        System.out.println("\nExample:");
        System.out.println("  Dog IS-A Animal (abstract class)");
        System.out.println("  Dog CAN-DO Trainable, Playable (interfaces)");
    }
}
//```
//
//        **Output:**
//        ```
//        --- Shape Examples ---
//Shape color: Red
//Area: 78.5
//Perimeter: 31.400000000000002
//
//Shape color: Blue
//Area: 24.0
//Drawing rectangle
//Resized to 8.0 x 12.0
//
//        --- Payment Examples ---
//Processing ₹5000.0 via Credit Card
//Log: Payment of ₹5000.0
//Refunding ₹500.0 to Credit Card
//
//Processing ₹3000.0 via UPI
//Log: UPI payment of ₹3000.0
//
//        --- Interface vs Abstract Class ---
//
//Abstract Class:
//        - Can have instance variables
//  - Can have constructors
//  - Can have concrete methods
//  - Single inheritance only
//  - Use: When classes share common code/state
//
//Interface:
//        - No instance variables (only constants)
//  - No constructors
//  - All methods abstract (before Java 8)
//        - Multiple inheritance
//  - Use: Define contract/capability
//
//When to use what:
//Abstract Class: IS-A relationship, shared code
//Interface: CAN-DO capability, contract
//
//Example:
//Dog IS-A Animal (abstract class)
//Dog CAN-DO Trainable, Playable (interfaces)
//        ```
//
//        ---
//
//        **Quick Summary:**
//        ```
//Lambda Expressions:
//        - Syntax: (params) -> expression
//- Functional Interface needed (single abstract method)
//- Method References: ClassName::method
//- Built-in: Predicate, Function, Consumer, Supplier
//
//Interfaces:
//        - Contract/Blueprint
//- Abstract methods (must implement)
//- Default methods (Java 8+) - optional override
//- Static methods - utility
//- Multiple inheritance allowed
//- Functional Interface: exactly one abstract method
//
//Key Differences:
//Abstract Class vs Interface:
//        - Abstract: IS-A, shared code, single inheritance
//- Interface: CAN-DO, contract, multiple inheritance
//
//Use:
//        - Lambda: Short, inline implementations
//- Interface: Define capabilities/contracts
//- Abstract: Share common code among related classes