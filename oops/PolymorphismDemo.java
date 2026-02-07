package dev.abhi.oops;
// Polymorphism = Ek hi cheez ke alag alag forms
// Method Overloading (Compile-time) + Method Overriding (Runtime)

// Parent class
class Shape {
    public void draw() {
        System.out.println("Drawing a shape");
    }

    public double area() {
        return 0;
    }
}

// Child 1 - Circle
class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // METHOD OVERRIDING - parent method ko change karna
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }

    @Override
    public double area() {
        return 3.14 * radius * radius;
    }
}

// Child 2 - Rectangle
class Rectangle extends Shape {
    double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }

    @Override
    public double area() {
        return length * width;
    }
}

// Method Overloading demo
class Calculator {
    // Same method name, different parameters - OVERLOADING

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b) {
        return a + b;
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {

        System.out.println("--- Runtime Polymorphism (Method Overriding) ---\n");

        // Parent reference, child objects - POLYMORPHISM
        Shape shape1 = new Circle(5);
        Shape shape2 = new Rectangle(4, 6);

        // Same method call, different behavior - RUNTIME POLYMORPHISM
        shape1.draw();  // Circle ka draw()
        System.out.println("Area: " + shape1.area());

        System.out.println();

        shape2.draw();  // Rectangle ka draw()
        System.out.println("Area: " + shape2.area());

        System.out.println("\n--- Compile-time Polymorphism (Method Overloading) ---\n");

        Calculator calc = new Calculator();

        // Same method name, different parameters
        System.out.println("add(5, 3) = " + calc.add(5, 3));
        System.out.println("add(5, 3, 2) = " + calc.add(5, 3, 2));
        System.out.println("add(5.5, 3.2) = " + calc.add(5.5, 3.2));

        // Polymorphism benefits:
        // 1. Flexibility - ek interface, multiple implementations
        // 2. Code cleaner aur readable
        // 3. Easy to extend - naye shapes add kar sakte

        // Types:
        // 1. Compile-time (Static) - Method Overloading, Operator Overloading
        // 2. Runtime (Dynamic) - Method Overriding
    }
}

