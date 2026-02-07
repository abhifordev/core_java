package dev.abhi.java8;
import java.util.*;
import java.util.stream.*;

public class LambdaWithCollections {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 1. forEach - iterate karna
        System.out.println("--- forEach ---");
        numbers.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 2. removeIf - condition se remove
        System.out.println("\n--- removeIf ---");
        List<Integer> nums = new ArrayList<>(numbers);
        nums.removeIf(n -> n % 2 == 0);  // Remove even
        System.out.println("After removing even: " + nums);

        // 3. replaceAll - transform each element
        System.out.println("\n--- replaceAll ---");
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        list.replaceAll(n -> n * n);  // Square each
        System.out.println("Squared: " + list);

        // 4. sort - custom sorting
        System.out.println("\n--- sort with Lambda ---");
        List<String> names = Arrays.asList("Rahul", "Priya", "Amit", "Neha");

        names.sort((s1, s2) -> s1.length() - s2.length());
        System.out.println("By length: " + names);

        names.sort((s1, s2) -> s2.compareTo(s1));  // Reverse
        System.out.println("Reverse: " + names);

        // 5. Map operations
        System.out.println("\n--- Map with Lambda ---");
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Rahul", 85);
        scores.put("Priya", 92);
        scores.put("Amit", 78);

        // forEach on map
        scores.forEach((name, score) ->
                System.out.println(name + ": " + score)
        );

        // computeIfAbsent
        scores.computeIfAbsent("Neha", k -> 95);
        System.out.println("\nAfter computeIfAbsent: " + scores);

        // merge
        scores.merge("Rahul", 10, (old, inc) -> old + inc);
        System.out.println("After merge: " + scores);

        // 6. Stream operations with lambda
        System.out.println("\n--- Stream Operations ---");

        // filter + map + collect
        List<Integer> evenSquares = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Even squares: " + evenSquares);

        // reduce - combine all
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum);

        // sorted
        List<Integer> sorted = numbers.stream()
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList());
        System.out.println("Sorted desc: " + sorted);

        // Real example: Employee processing
        System.out.println("\n--- Real Example: Employee Data ---");

        class Employee {
            String name;
            String dept;
            double salary;

            Employee(String name, String dept, double salary) {
                this.name = name;
                this.dept = dept;
                this.salary = salary;
            }

            public String toString() {
                return name + "(" + dept + "): " + salary;
            }
        }

        List<Employee> employees = Arrays.asList(
                new Employee("Rahul", "IT", 50000),
                new Employee("Priya", "HR", 45000),
                new Employee("Amit", "IT", 60000),
                new Employee("Neha", "Finance", 55000),
                new Employee("Vikram", "IT", 48000)
        );

        // Filter IT dept with salary > 50000
        System.out.println("IT employees with salary > 50k:");
        employees.stream()
                .filter(e -> e.dept.equals("IT"))
                .filter(e -> e.salary > 50000)
                .forEach(e -> System.out.println("  " + e));

        // Group by department
        Map<String, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(e -> e.dept));

        System.out.println("\nGrouped by department:");
        byDept.forEach((dept, empList) -> {
            System.out.println(dept + ": " + empList.size() + " employees");
        });

        // Average salary
        double avgSalary = employees.stream()
                .mapToDouble(e -> e.salary)
                .average()
                .orElse(0);
        System.out.println("\nAverage salary: " + avgSalary);

        // Highest paid
        Employee highest = employees.stream()
                .max((e1, e2) -> Double.compare(e1.salary, e2.salary))
                .orElse(null);
        System.out.println("Highest paid: " + highest);

        // Name list of IT employees
        List<String> itNames = employees.stream()
                .filter(e -> e.dept.equals("IT"))
                .map(e -> e.name)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("IT employees: " + itNames);
    }
}