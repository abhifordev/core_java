package dev.abhi.streams;
import java.util.*;
import java.util.stream.*;

public class StreamBasics {
    public static void main(String[] args) {

        // STREAM CREATION - Different ways

        // 1. Stream from List
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream1 = numbers.stream();

        // 2. Stream from Array
        String[] names = {"Rahul", "Priya", "Amit", "Neha"};
        Stream<String> stream2 = Arrays.stream(names);

        // 3. Stream.of()
        Stream<String> stream3 = Stream.of("Apple", "Banana", "Mango");

        // 4. Stream.generate() - infinite stream
        Stream<Double> randomStream = Stream.generate(Math::random).limit(5);

        // BASIC OPERATIONS

        System.out.println("--- Filter (even numbers) ---");
        // filter() - condition match karne wale elements
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);

        System.out.println("\n--- Map (square of numbers) ---");
        // map() - har element ko transform karna
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(squares);

        System.out.println("\n--- Filter + Map (square of even numbers) ---");
        List<Integer> evenSquares = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(evenSquares);

        System.out.println("\n--- Sorted (descending) ---");
        // sorted() - elements ko sort karna
        List<Integer> sortedDesc = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sortedDesc);

        System.out.println("\n--- Distinct (remove duplicates) ---");
        List<Integer> withDuplicates = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5, 5);
        List<Integer> unique = withDuplicates.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(unique);

        System.out.println("\n--- Limit & Skip ---");
        // limit() - pehle n elements
        // skip() - pehle n elements skip
        List<Integer> limited = numbers.stream()
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("First 5: " + limited);

        List<Integer> skipped = numbers.stream()
                .skip(5)
                .collect(Collectors.toList());
        System.out.println("After skipping 5: " + skipped);

        // Real example: Filter names starting with 'A' and convert to uppercase
        System.out.println("\n--- Real Example: Name processing ---");
        List<String> nameList = Arrays.asList("Amit", "Rahul", "Aarav", "Priya", "Ananya");
        List<String> filtered = nameList.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(filtered);

        // Important points:
        // - Stream ek baar hi use ho sakta (consumed after terminal operation)
        // - Intermediate operations lazy hote (execute nahi hote jab tak terminal nahi)
        // - Terminal operations result produce karte (collect, forEach, count, etc.)
    }
}