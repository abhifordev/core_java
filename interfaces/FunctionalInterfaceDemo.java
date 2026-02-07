package dev.abhi.interfaces;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

// Built-in functional interfaces already exist
// java.util.function package mein


// Functional Interface - sirf ek abstract method
// Can have multiple default/static methods
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);  // Single abstract method (SAM)

    // Default methods allowed
    default void displayResult(int result) {
        System.out.println("Result: " + result);
    }

    // Static methods allowed
    static void info() {
        System.out.println("This is a calculator");
    }
}

@FunctionalInterface
interface StringProcessor {
    String process(String str);
}

@FunctionalInterface
interface Validator {
    boolean validate(String input);
}



public class FunctionalInterfaceDemo {
    public static void main(String[] args) {

        System.out.println("--- Custom Functional Interface ---");

        // Lambda implementation
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> {
            if(b == 0) return 0;
            return a / b;
        };

        int result1 = add.calculate(10, 5);
        add.displayResult(result1);

        int result2 = multiply.calculate(10, 5);
        multiply.displayResult(result2);

        // Static method call
        Calculator.info();

        System.out.println("\n--- String Processing ---");

        StringProcessor toUpper = str -> str.toUpperCase();
        StringProcessor reverse = str -> new StringBuilder(str).reverse().toString();
        StringProcessor addPrefix = str -> "Hello, " + str;

        System.out.println(toUpper.process("java"));
        System.out.println(reverse.process("lambda"));
        System.out.println(addPrefix.process("World"));

        System.out.println("\n--- Validation ---");

        Validator emailValidator = email -> email.contains("@") && email.contains(".");
        Validator lengthValidator = str -> str.length() >= 6;

        System.out.println("Valid email? " + emailValidator.validate("test@gmail.com"));
        System.out.println("Valid email? " + emailValidator.validate("invalid"));
        System.out.println("Valid length? " + lengthValidator.validate("password123"));

        // Built-in functional interfaces
        System.out.println("\n--- Built-in Functional Interfaces ---");

        // Predicate<T> - boolean test(T t)
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));

        // Function<T, R> - R apply(T t)
        Function<String, Integer> length = str -> str.length();
        System.out.println("Length: " + length.apply("Lambda"));

        // Consumer<T> - void accept(T t)
        Consumer<String> printer = str -> System.out.println("Printing: " + str);
        printer.accept("Hello");

        // Supplier<T> - T get()
        Supplier<Double> random = () -> Math.random();
        System.out.println("Random: " + random.get());

        // Real example: Custom operation
        System.out.println("\n--- Real Example: Apply Operation ---");

        int num1 = 10, num2 = 5;

        System.out.println("Add: " + applyOperation(num1, num2, (a, b) -> a + b));
        System.out.println("Subtract: " + applyOperation(num1, num2, (a, b) -> a - b));
        System.out.println("Multiply: " + applyOperation(num1, num2, (a, b) -> a * b));
        System.out.println("Max: " + applyOperation(num1, num2, (a, b) -> Math.max(a, b)));

        // Functional Interface rules:
        // 1. Only ONE abstract method
        // 2. Can have multiple default methods
        // 3. Can have multiple static methods
        // 4. Can be used with lambda expressions
        // 5. @FunctionalInterface annotation optional but recommended
    }

    // Helper method accepting functional interface
    static int applyOperation(int a, int b, Calculator operation) {
        return operation.calculate(a, b);
    }
}
//```
//
//        **Output:**
//        ```
//        --- Custom Functional Interface ---
//Result: 15
//Result: 50
//This is a calculator
//
//--- String Processing ---
//JAVA
//        adbmal
//Hello, World
//
//--- Validation ---
//Valid email? true
//Valid email? false
//Valid length? true
//
//        --- Built-in Functional Interfaces ---
//Is 4 even? true
//Length: 6
//Printing: Hello
//Random: 0.7234567891234567
//
//        --- Real Example: Apply Operation ---
//Add: 15
//Subtract: 5
//Multiply: 50
//Max: 10