package dev.abhi.java8;
// Functional Interface - sirf ek abstract method

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

@FunctionalInterface
interface StringOperation {
    String operate(String str);
}

public class LambdaBasics {
    public static void main(String[] args) {

        // Traditional way - Anonymous class
        System.out.println("--- Traditional Anonymous Class ---");
        Calculator oldWay = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };
        System.out.println("5 + 3 = " + oldWay.calculate(5, 3));

        // Lambda way - bahut short aur clean
        System.out.println("\n--- Lambda Expression ---");

        // Syntax 1: With parameter types
        Calculator add = (int a, int b) -> a + b;
        System.out.println("5 + 3 = " + add.calculate(5, 3));

        // Syntax 2: Without parameter types (type inference)
        Calculator multiply = (a, b) -> a * b;
        System.out.println("5 * 3 = " + multiply.calculate(5, 3));

        // Syntax 3: Multiple statements - use {}
        Calculator divide = (a, b) -> {
            if(b == 0) {
                System.out.println("Cannot divide by zero");
                return 0;
            }
            return a / b;
        };
        System.out.println("10 / 2 = " + divide.calculate(10, 2));

        // Lambda with single parameter
        System.out.println("\n--- Single Parameter ---");

        // Parentheses optional for single parameter
        StringOperation toUpper = str -> str.toUpperCase();
        StringOperation toLower = str -> str.toLowerCase();

        System.out.println(toUpper.operate("hello"));
        System.out.println(toLower.operate("WORLD"));

        // Lambda with no return value (void)
        System.out.println("\n--- Void Return Type ---");

        Greeting greet = name -> System.out.println("Hello, " + name + "!");
        greet.sayHello("Rahul");
        greet.sayHello("Priya");

        // Lambda with no parameters
        System.out.println("\n--- No Parameters ---");

        Runnable task = () -> System.out.println("Task executed!");
        task.run();

        // Real example: Custom sorting
        System.out.println("\n--- Real Example: Sorting ---");

        java.util.List<String> names = java.util.Arrays.asList("Rahul", "Amit", "Priya", "Neha");

        // Sort by length using lambda
        names.sort((s1, s2) -> s1.length() - s2.length());
        System.out.println("By length: " + names);

        // Sort alphabetically
        names.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println("Alphabetical: " + names);

        // Lambda syntax summary:
        // () -> expression              // no parameter
        // (x) -> expression             // one parameter
        // x -> expression               // one parameter (parentheses optional)
        // (x, y) -> expression          // multiple parameters
        // (x, y) -> { statements; }     // multiple statements
    }
}