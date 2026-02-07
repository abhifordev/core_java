package dev.abhi.java8;
import java.util.*;
import java.util.function.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public void display() {
        System.out.println(name + ": " + marks);
    }

    public static void staticDisplay(Student s) {
        System.out.println("Static: " + s.name);
    }

    @Override
    public String toString() {
        return name + "(" + marks + ")";
    }
}

public class MethodReferences {
    public static void main(String[] args) {

        // Method Reference = Lambda ka short form
        // Jab lambda sirf ek method call karta ho

        List<String> names = Arrays.asList("rahul", "priya", "amit", "neha");

        // 1. Static Method Reference - ClassName::methodName
        System.out.println("--- Static Method Reference ---");

        // Lambda way
        names.forEach(name -> System.out.println(name));

        // Method reference way
        System.out.println("\nWith method reference:");
        names.forEach(System.out::println);

        // Another example - String to Integer
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5");
        List<Integer> integers = new ArrayList<>();

        // Lambda: str -> Integer.parseInt(str)
        // Method reference: Integer::parseInt
        numbers.forEach(num -> integers.add(Integer.parseInt(num)));
        System.out.println("\nParsed: " + integers);

        // 2. Instance Method Reference - object::methodName
        System.out.println("\n--- Instance Method Reference ---");

        String prefix = "Hello, ";

        // Lambda: name -> prefix.concat(name)
        // Method reference: prefix::concat
        names.stream()
                .map(prefix::concat)
                .forEach(System.out::println);

        // 3. Instance Method Reference on Class - ClassName::instanceMethod
        System.out.println("\n--- Instance Method on Class Type ---");

        List<String> words = Arrays.asList("Apple", "Banana", "Mango");

        // Lambda: str -> str.toUpperCase()
        // Method reference: String::toUpperCase
        words.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // Comparison - lambda vs method reference
        Comparator<String> lambda = (s1, s2) -> s1.compareToIgnoreCase(s2);
        Comparator<String> methodRef = String::compareToIgnoreCase;

        // 4. Constructor Reference - ClassName::new
        System.out.println("\n--- Constructor Reference ---");

        // Lambda: str -> new String(str)
        // Constructor reference: String::new
        Function<String, String> stringCreator = String::new;
        String created = stringCreator.apply("Created using constructor reference");
        System.out.println(created);

        // Custom object creation
        BiFunction<String, Integer, Student> studentCreator = Student::new;
        Student s1 = studentCreator.apply("Rahul", 85);
        Student s2 = studentCreator.apply("Priya", 92);

        System.out.println(s1);
        System.out.println(s2);

        // Real example: Processing students
        System.out.println("\n--- Real Example: Student Processing ---");

        List<Student> students = Arrays.asList(
                new Student("Rahul", 85),
                new Student("Priya", 92),
                new Student("Amit", 78)
        );

        // Instance method reference
        students.forEach(Student::display);

        // Static method reference
        System.out.println("\nUsing static method:");
        students.forEach(Student::staticDisplay);

        // Method reference summary:
        // Static: ClassName::staticMethod
        // Instance: object::instanceMethod
        // Instance on type: ClassName::instanceMethod
        // Constructor: ClassName::new
    }
}