package dev.abhi.streams;
import java.util.*;

public class TerminalOperations {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 9, 2, 7, 4, 6);

        // 1. forEach() - har element par action perform
        System.out.println("--- forEach ---");
        numbers.stream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 2. count() - kitne elements hain
        System.out.println("\n--- count ---");
        long count = numbers.stream().filter(n -> n > 5).count();
        System.out.println("Numbers > 5: " + count);

        // 3. min() & max() - sabse chhota aur bada
        System.out.println("\n--- min & max ---");
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        System.out.println("Min: " + min.get());
        System.out.println("Max: " + max.get());

        // 4. reduce() - sabko combine karke ek result
        System.out.println("\n--- reduce (sum) ---");
        // reduce(identity, accumulator)
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum);

        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product);

        // 5. findFirst() & findAny() - pehla ya koi bhi element
        System.out.println("\n--- findFirst & findAny ---");
        Optional<Integer> first = numbers.stream()
                .filter(n -> n > 5)
                .findFirst();
        System.out.println("First number > 5: " + first.get());

        Optional<Integer> any = numbers.stream()
                .filter(n -> n > 5)
                .findAny();
        System.out.println("Any number > 5: " + any.get());

        // 6. allMatch(), anyMatch(), noneMatch() - boolean conditions
        System.out.println("\n--- Match operations ---");
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        System.out.println("All positive? " + allPositive);

        boolean anyGreater8 = numbers.stream().anyMatch(n -> n > 8);
        System.out.println("Any > 8? " + anyGreater8);

        boolean noneNegative = numbers.stream().noneMatch(n -> n < 0);
        System.out.println("None negative? " + noneNegative);

        // 7. toArray() - stream ko array mein convert
        System.out.println("\n--- toArray ---");
        Integer[] arr = numbers.stream().toArray(Integer[]::new);
        System.out.println("Array: " + Arrays.toString(arr));

        // Real example: Student marks analysis
        System.out.println("\n--- Real Example: Student Marks ---");
        List<Integer> marks = Arrays.asList(85, 92, 78, 45, 67, 88, 95, 55, 72);

        long passCount = marks.stream().filter(m -> m >= 40).count();
        long failCount = marks.stream().filter(m -> m < 40).count();
        double average = marks.stream().mapToInt(Integer::intValue).average().orElse(0);
        int highest = marks.stream().max(Integer::compareTo).get();
        int lowest = marks.stream().min(Integer::compareTo).get();

        System.out.println("Pass: " + passCount);
        System.out.println("Fail: " + failCount);
        System.out.println("Average: " + average);
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);

        // Terminal vs Intermediate:
        // Intermediate: filter, map, sorted, distinct (return Stream)
        // Terminal: forEach, collect, count, reduce (return result/void)
    }
}