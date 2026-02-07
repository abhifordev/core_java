package dev.abhi.java8;
import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {

        // Java provides built-in functional interfaces in java.util.function package

        // 1. Predicate<T> - boolean test(T t) - returns boolean
        System.out.println("--- Predicate (condition check) ---");

        Predicate<Integer> isEven = num -> num % 2 == 0;
        Predicate<Integer> isPositive = num -> num > 0;
        Predicate<String> startsWithA = str -> str.startsWith("A");

        System.out.println("Is 4 even? " + isEven.test(4));
        System.out.println("Is 5 even? " + isEven.test(5));
        System.out.println("Is 10 positive? " + isPositive.test(10));
        System.out.println("'Amit' starts with A? " + startsWithA.test("Amit"));

        // Predicate chaining - and, or, negate
        Predicate<Integer> isEvenAndPositive = isEven.and(isPositive);
        System.out.println("Is 4 even AND positive? " + isEvenAndPositive.test(4));
        System.out.println("Is -4 even AND positive? " + isEvenAndPositive.test(-4));

        // 2. Function<T, R> - R apply(T t) - transform input to output
        System.out.println("\n--- Function (transformation) ---");

        Function<String, Integer> stringLength = str -> str.length();
        Function<Integer, Integer> square = num -> num * num;
        Function<Integer, String> numToString = num -> "Number: " + num;

        System.out.println("Length of 'Hello': " + stringLength.apply("Hello"));
        System.out.println("Square of 5: " + square.apply(5));
        System.out.println(numToString.apply(42));

        // Function chaining - andThen, compose
        Function<Integer, Integer> doubleAndSquare = square.compose(num -> num * 2);
        System.out.println("Double then square of 3: " + doubleAndSquare.apply(3)); // (3*2)^2 = 36

        // 3. Consumer<T> - void accept(T t) - consumes input, no return
        System.out.println("\n--- Consumer (action/side-effect) ---");

        Consumer<String> printUpper = str -> System.out.println(str.toUpperCase());
        Consumer<Integer> printSquare = num -> System.out.println(num * num);

        printUpper.accept("hello");
        printSquare.accept(5);

        // Consumer chaining - andThen
        Consumer<String> print = System.out::println;
        Consumer<String> printLength = str -> System.out.println("Length: " + str.length());
        Consumer<String> combined = print.andThen(printLength);

        System.out.println("\nChained consumer:");
        combined.accept("Lambda");

        // 4. Supplier<T> - T get() - supplies/provides value, no input
        System.out.println("\n--- Supplier (provides value) ---");

        Supplier<Double> randomValue = () -> Math.random();
        Supplier<String> greeting = () -> "Hello, World!";
        Supplier<List<Integer>> listSupplier = () -> Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("Random: " + randomValue.get());
        System.out.println("Greeting: " + greeting.get());
        System.out.println("List: " + listSupplier.get());

        // 5. BiFunction<T, U, R> - R apply(T t, U u) - two inputs
        System.out.println("\n--- BiFunction (two inputs) ---");

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        BiFunction<String, String, String> concat = (s1, s2) -> s1 + " " + s2;

        System.out.println("5 + 3 = " + add.apply(5, 3));
        System.out.println("Concat: " + concat.apply("Hello", "World"));

        // Real example: Filter and process students
        System.out.println("\n--- Real Example: Student Processing ---");

        class Student {
            String name;
            int marks;
            Student(String name, int marks) {
                this.name = name;
                this.marks = marks;
            }
        }

        List<Student> students = Arrays.asList(
                new Student("Rahul", 85),
                new Student("Priya", 92),
                new Student("Amit", 65),
                new Student("Neha", 95),
                new Student("Vikram", 55)
        );

        // Predicate - filter pass students
        Predicate<Student> isPassed = s -> s.marks >= 40;
        Predicate<Student> isDistinction = s -> s.marks >= 75;

        // Function - get grade
        Function<Student, String> getGrade = s -> {
            if(s.marks >= 90) return "A";
            if(s.marks >= 75) return "B";
            if(s.marks >= 60) return "C";
            return "D";
        };

        // Consumer - print student
        Consumer<Student> printStudent = s ->
                System.out.println(s.name + ": " + s.marks + " (Grade: " + getGrade.apply(s) + ")");

        System.out.println("Distinction students:");
        students.stream()
                .filter(isDistinction)
                .forEach(printStudent);

        // Summary of functional interfaces:
        // Predicate<T>: T -> boolean (test)
        // Function<T,R>: T -> R (transform)
        // Consumer<T>: T -> void (action)
        // Supplier<T>: () -> T (provide)
        // BiFunction<T,U,R>: (T,U) -> R (two inputs)
        // UnaryOperator<T>: T -> T (Function<T,T>)
        // BinaryOperator<T>: (T,T) -> T (BiFunction<T,T,T>)
    }
}
//        --- Predicate (condition check) ---
//Is 4 even? true
//Is 5 even? false
//Is 10 positive? true
//        'Amit' starts with A? true
//Is 4 even AND positive? true
//Is -4 even AND positive? false
//
//        --- Function (transformation) ---
//Length of 'Hello': 5
//Square of 5: 25
//Number: 42
//Double then square of 3: 36
//
//        --- Consumer (action/side-effect) ---
//HELLO
//25
//
//Chained consumer:
//Lambda
//Length: 6
//
//        --- Supplier (provides value) ---
//Random: 0.7234567891234567
//Greeting: Hello, World!
//List: [1, 2, 3, 4, 5]
//
//        --- BiFunction (two inputs) ---
//        5 + 3 = 8
//Concat: Hello World
//
//--- Real Example: Student Processing ---
//Distinction students:
//Rahul: 85 (Grade: B)
//Priya: 92 (Grade: A)
//Neha: 95 (Grade: A)