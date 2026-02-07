package dev.abhi.streams;
import java.util.*;
import java.util.stream.*;

public class AdvancedStreams {
    public static void main(String[] args) {

        // 1. flatMap() - nested structure ko flat karna
        System.out.println("--- flatMap ---");

        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        // Without flatMap - Stream<List<Integer>>
        // With flatMap - Stream<Integer> (flat)
        List<Integer> flatList = nestedList.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        System.out.println("Flattened: " + flatList);

        // Real example: Students and their subjects
        class Student {
            String name;
            List<String> subjects;
            Student(String name, List<String> subjects) {
                this.name = name;
                this.subjects = subjects;
            }
        }

        List<Student> students = Arrays.asList(
                new Student("Rahul", Arrays.asList("Math", "Physics")),
                new Student("Priya", Arrays.asList("Chemistry", "Biology")),
                new Student("Amit", Arrays.asList("Math", "Chemistry"))
        );

        // All unique subjects
        List<String> allSubjects = students.stream()
                .flatMap(s -> s.subjects.stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("All subjects: " + allSubjects);

        // 2. peek() - intermediate debugging/logging
        System.out.println("\n--- peek (debugging) ---");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> result = numbers.stream()
                .peek(n -> System.out.println("Original: " + n))
                .map(n -> n * 2)
                .peek(n -> System.out.println("After map: " + n))
                .filter(n -> n > 5)
                .peek(n -> System.out.println("After filter: " + n))
                .collect(Collectors.toList());

        System.out.println("Final result: " + result);

        // 3. Parallel Streams - multiple threads mein process
        System.out.println("\n--- Parallel Streams ---");

        List<Integer> bigList = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());

        // Sequential stream
        long startSeq = System.currentTimeMillis();
        bigList.stream()
                .map(n -> n * n)
                .forEach(n -> {});
        long endSeq = System.currentTimeMillis();

        // Parallel stream
        long startPar = System.currentTimeMillis();
        bigList.parallelStream()
                .map(n -> n * n)
                .forEach(n -> {});
        long endPar = System.currentTimeMillis();

        System.out.println("Sequential: " + (endSeq - startSeq) + "ms");
        System.out.println("Parallel: " + (endPar - startPar) + "ms");

        // 4. IntStream, DoubleStream, LongStream - primitive streams
        System.out.println("\n--- Primitive Streams ---");

        // IntStream.range() - exclusive end
        IntStream.range(1, 6).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // IntStream.rangeClosed() - inclusive end
        IntStream.rangeClosed(1, 5).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Sum using IntStream
        int sum = IntStream.rangeClosed(1, 100).sum();
        System.out.println("\nSum 1-100: " + sum);

        // Average
        double avg = IntStream.rangeClosed(1, 10).average().orElse(0);
        System.out.println("Average 1-10: " + avg);

        // 5. Optional handling
        System.out.println("\n--- Optional handling ---");

        List<String> names = Arrays.asList("Rahul", "Priya", "Amit");

        Optional<String> first = names.stream()
                .filter(n -> n.startsWith("Z"))
                .findFirst();

        // Safe handling
        if(first.isPresent()) {
            System.out.println("Found: " + first.get());
        } else {
            System.out.println("Not found");
        }

        // orElse - default value agar nahi mila
        String name = names.stream()
                .filter(n -> n.startsWith("Z"))
                .findFirst()
                .orElse("Default Name");
        System.out.println("Result: " + name);

        // Real example: Finding max salary employee
        System.out.println("\n--- Real Example: Max Salary ---");

        class Employee {
            String name;
            double salary;
            Employee(String name, double salary) {
                this.name = name;
                this.salary = salary;
            }
            public String toString() {
                return name + ": " + salary;
            }
        }

        List<Employee> employees = Arrays.asList(
                new Employee("Rahul", 50000),
                new Employee("Priya", 75000),
                new Employee("Amit", 60000),
                new Employee("Neha", 90000)
        );

        Employee maxSalary = employees.stream()
                .max(Comparator.comparing(e -> e.salary))
                .orElse(null);
        System.out.println("Highest paid: " + maxSalary);

        // Salary greater than 60k
        List<String> highEarners = employees.stream()
                .filter(e -> e.salary > 60000)
                .map(e -> e.name)
                .collect(Collectors.toList());
        System.out.println("Salary > 60k: " + highEarners);

        // Important points:
        // - flatMap() for nested structures
        // - peek() for debugging only
        // - parallelStream() for CPU-intensive tasks
        // - Use primitive streams (IntStream) for better performance
        // - Always handle Optional properly
    }
}
//        --- flatMap ---
//Flattened: [1, 2, 3, 4, 5, 6, 7, 8, 9]
//All subjects: [Math, Physics, Chemistry, Biology]
//
//        --- peek (debugging) ---
//Original: 1
//After map: 2
//Original: 2
//After map: 4
//Original: 3
//After map: 6
//After filter: 6
//Original: 4
//After map: 8
//After filter: 8
//Original: 5
//After map: 10
//After filter: 10
//Final result: [6, 8, 10]
//
//        --- Parallel Streams ---
//Sequential: 1ms
//Parallel: 2ms
//
//--- Primitive Streams ---
//        1 2 3 4 5
//        1 2 3 4 5
//
//Sum 1-100: 5050
//Average 1-10: 5.5
//
//        --- Optional handling ---
//Not found
//Result: Default Name
//
//--- Real Example: Max Salary ---
//Highest paid: Neha: 90000.0
//Salary > 60k: [Priya, Neha]
//        ```
//
//        ---
//
//        **Quick Summary:**
//        ```
//Java Streams Key Concepts:
//
//        1. CREATION:
//        - list.stream()
//   - Arrays.stream(array)
//   - Stream.of(elements)
//   - IntStream.range()/rangeClosed()
//
//2. INTERMEDIATE (return Stream):
//        - filter() - condition
//   - map() - transform
//   - flatMap() - flatten nested
//   - sorted() - sort
//   - distinct() - unique
//   - limit() - first n
//   - skip() - skip n
//   - peek() - debug
//
//3. TERMINAL (return result):
//        - collect() - to collection
//   - forEach() - iterate
//   - count() - size
//   - reduce() - combine
//   - min()/max() - extreme values
//   - findFirst()/findAny()
//   - allMatch()/anyMatch()/noneMatch()
//
//4. COLLECTORS:
//        - toList()/toSet()/toMap()
//   - groupingBy() - group by property
//   - partitioningBy() - true/false split
//   - joining() - string concat
//   - counting()/summingInt()/averagingInt()
//
//Remember:
//        - Stream ek baar use, phir consumed
//- Lazy evaluation (jab tak terminal nahi tab tak execute nahi)
//- parallelStream() for performance