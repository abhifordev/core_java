package dev.abhi.streams;
import java.util.*;
import java.util.stream.*;

public class CollectorsDemo {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Rahul", "Priya", "Amit", "Neha", "Rahul", "Amit");

        // 1. toList() - List mein collect
        System.out.println("--- toList ---");
        List<String> list = names.stream()
                .filter(n -> n.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(list);

        // 2. toSet() - Set mein collect (duplicates remove)
        System.out.println("\n--- toSet ---");
        Set<String> set = names.stream().collect(Collectors.toSet());
        System.out.println(set);

        // 3. toMap() - Map mein collect
        System.out.println("\n--- toMap ---");
        Map<String, Integer> nameLength = names.stream()
                .distinct()
                .collect(Collectors.toMap(
                        name -> name,           // key
                        name -> name.length()   // value
                ));
        System.out.println(nameLength);

        // 4. joining() - String concatenation
        System.out.println("\n--- joining ---");
        String joined = names.stream().collect(Collectors.joining(", "));
        System.out.println(joined);

        String withPrefix = names.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(withPrefix);

        // 5. groupingBy() - Group karna by property
        System.out.println("\n--- groupingBy ---");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Even/Odd grouping
        Map<String, List<Integer>> evenOdd = numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd"));
        System.out.println(evenOdd);

        // Group names by first letter
        Map<Character, List<String>> byFirstLetter = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println(byFirstLetter);

        // 6. partitioningBy() - True/False mein partition
        System.out.println("\n--- partitioningBy ---");
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n > 5));
        System.out.println("Greater than 5: " + partitioned.get(true));
        System.out.println("Less than or equal 5: " + partitioned.get(false));

        // 7. counting(), summingInt(), averagingInt()
        System.out.println("\n--- Aggregate operations ---");
        List<Integer> marks = Arrays.asList(85, 92, 78, 67, 88);

        long count = marks.stream().collect(Collectors.counting());
        int sum = marks.stream().collect(Collectors.summingInt(Integer::intValue));
        double avg = marks.stream().collect(Collectors.averagingInt(Integer::intValue));

        System.out.println("Count: " + count);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);

        // Real example: Student data grouping
        System.out.println("\n--- Real Example: Students by Grade ---");

        class Student {
            String name;
            int marks;
            Student(String name, int marks) {
                this.name = name;
                this.marks = marks;
            }
            String getGrade() {
                if(marks >= 90) return "A";
                if(marks >= 75) return "B";
                if(marks >= 60) return "C";
                return "D";
            }
            public String toString() {
                return name + "(" + marks + ")";
            }
        }

        List<Student> students = Arrays.asList(
                new Student("Rahul", 85),
                new Student("Priya", 92),
                new Student("Amit", 78),
                new Student("Neha", 95),
                new Student("Vikram", 55)
        );

        // Group by grade
        Map<String, List<Student>> byGrade = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade));

        byGrade.forEach((grade, stuList) -> {
            System.out.println(grade + " Grade: " + stuList);
        });

        // Count students in each grade
        Map<String, Long> gradeCount = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade, Collectors.counting()));
        System.out.println("\nGrade counts: " + gradeCount);
    }
}

//        --- toList ---
//        [Amit, Amit]
//
//        --- toSet ---
//        [Rahul, Neha, Priya, Amit]
//
//        --- toMap ---
//        {Rahul=5, Neha=4, Priya=5, Amit=4}
//
//        --- joining ---
//Rahul, Priya, Amit, Neha, Rahul, Amit
//
//--- groupingBy ---
//        {Even=[2, 4, 6, 8, 10], Odd=[1, 3, 5, 7, 9]}
//        {P=[Priya], R=[Rahul, Rahul], A=[Amit, Amit], N=[Neha]}
//
//        --- partitioningBy ---
//Greater than 5: [6, 7, 8, 9, 10]
//Less than or equal 5: [1, 2, 3, 4, 5]
//
//        --- Aggregate operations ---
//Count: 5
//Sum: 410
//Average: 82.0
//
//        --- Real Example: Students by Grade ---
//A Grade: [Priya(92), Neha(95)]
//B Grade: [Rahul(85), Amit(78)]
//D Grade: [Vikram(55)]
//
//Grade counts: {A=2, B=2, D=1}