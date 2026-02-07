package dev.abhi.intro;
class Counter {
    // Instance variable - har object ki apni copy
    int instanceCount;

    // Static variable - sabhi objects ke liye ek hi copy
    static int staticCount;

    // Static block - class load hone par ek baar execute
    static {
        System.out.println("Static block executed");
        staticCount = 100;
    }

    // Constructor
    Counter() {
        instanceCount++;
        staticCount++;
    }

    // Instance method - object se call
    void displayInstance() {
        System.out.println("Instance count: " + instanceCount);
    }

    // Static method - class se call
    static void displayStatic() {
        System.out.println("Static count: " + staticCount);
        // Note: static method mein instance variables access nahi kar sakte
        // System.out.println(instanceCount);  // ERROR
    }

    void displayBoth() {
        System.out.println("Instance: " + instanceCount + ", Static: " + staticCount);
    }
}

class MathUtils {
    // Static constants
    static final double PI = 3.14159;
    static final int MAX_VALUE = 100;

    // Static utility methods - object banane ki zaroorat nahi
    static int add(int a, int b) {
        return a + b;
    }

    static int multiply(int a, int b) {
        return a * b;
    }

    static double circleArea(double radius) {
        return PI * radius * radius;
    }
}

class Student1 {
    String name;              // Instance - har student ka apna
    static String school;     // Static - sabhi students ka same
    static int totalStudents; // Static counter

    Student1(String name) {
        this.name = name;
        totalStudents++;  // Static variable increment
    }

    void display() {
        System.out.println(name + " studies at " + school);
    }

    static void displayTotal() {
        System.out.println("Total students: " + totalStudents);
    }
}

public class StaticDemo {
    public static void main(String[] args) {

        System.out.println("--- Static vs Instance Variables ---\n");

        Counter c1 = new Counter();
        c1.displayBoth();

        Counter c2 = new Counter();
        c2.displayBoth();

        Counter c3 = new Counter();
        c3.displayBoth();

        System.out.println("\nNotice:");
        System.out.println("- Instance count is always 1 (each object's own)");
        System.out.println("- Static count increases (shared across all objects)");

        // Static method - called using class name
        System.out.println("\n--- Static Methods ---");
        Counter.displayStatic();

        // Can also call via object (not recommended)
        c1.displayStatic();

        // Static utility methods
        System.out.println("\n--- Static Utility Methods ---");
        System.out.println("5 + 3 = " + MathUtils.add(5, 3));
        System.out.println("5 * 3 = " + MathUtils.multiply(5, 3));
        System.out.println("Circle area (r=5): " + MathUtils.circleArea(5));
        System.out.println("PI constant: " + MathUtils.PI);

        // Real example: School students
        System.out.println("\n--- Real Example: Students ---");

        Student1.school = "ABC School";  // Static - set kiya ek baar

        Student1 s1 = new Student1("Rahul");
        Student1 s2 = new Student1("Priya");
        Student1 s3 = new Student1("Amit");

        s1.display();  // Same school for all
        s2.display();
        s3.display();

        Student1.displayTotal();  // Static method

        // Changing static variable affects all
        System.out.println("\nChanging school name:");
        Student1.school = "XYZ School";
        s1.display();  // All students ka school change ho gaya
        s2.display();
        s3.display();

        // Key points:
        // Static:
        //   - Shared across all objects
        //   - Called using class name
        //   - Loaded once when class loads
        //   - Can't access instance members
        //   - Use: Constants, utility methods, counters
        //
        // Instance:
        //   - Each object's own copy
        //   - Called using object
        //   - Created when object created
        //   - Can access static members
        //   - Use: Object-specific data
    }
}

//
//        **Output:**
//        ```
//Static block executed
//--- Static vs Instance Variables ---
//
//Instance: 1, Static: 101
//Instance: 1, Static: 102
//Instance: 1, Static: 103
//
//Notice:
//        - Instance count is always 1 (each object's own)
//        - Static count increases (shared across all objects)
//
//--- Static Methods ---
//Static count: 103
//Static count: 103
//
//        --- Static Utility Methods ---
//        5 + 3 = 8
//        5 * 3 = 15
//Circle area (r=5): 78.53975
//PI constant: 3.14159
//
//        --- Real Example: Students ---
//Rahul studies at ABC School
//Priya studies at ABC School
//Amit studies at ABC School
//Total students: 3
//
//Changing school name:
//Rahul studies at XYZ School
//Priya studies at XYZ School
//Amit studies at XYZ School