package dev.abhi.maps;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapIteration {
    public static void main(String[] args) {

        HashMap<String, Integer> scores = new HashMap<>();
        scores.put("Cricket", 150);
        scores.put("Football", 3);
        scores.put("Hockey", 5);
        scores.put("Tennis", 40);
        scores.put("Badminton", 21);

        System.out.println("Scores: " + scores);

        // Method 1: Iterate over keys using keySet()
        System.out.println("\n1. Using keySet():");
        Set<String> keys = scores.keySet();
        for(String sport : keys) {
            System.out.println("   " + sport + ": " + scores.get(sport));
        }

        // Method 2: Iterate over values using values()
        System.out.println("\n2. Using values():");
        for(Integer score : scores.values()) {
            System.out.println("   Score: " + score);
        }

        // Method 3: Iterate over entries using entrySet() - BEST
        System.out.println("\n3. Using entrySet() - RECOMMENDED:");
        Set<Map.Entry<String, Integer>> entries = scores.entrySet();
        for(Map.Entry<String, Integer> entry : entries) {
            System.out.println("   " + entry.getKey() + " -> " + entry.getValue());
        }

        // Method 4: forEach with lambda (Java 8+)
        System.out.println("\n4. Using forEach lambda:");
        scores.forEach((sport, score) -> {
            System.out.println("   " + sport + " = " + score);
        });

        // Modifying during iteration - using entrySet
        System.out.println("\n5. Updating values during iteration:");
        for(Map.Entry<String, Integer> entry : scores.entrySet()) {
            if(entry.getValue() < 10) {
                entry.setValue(entry.getValue() * 2);  // Double small scores
            }
        }
        System.out.println("   After doubling: " + scores);

        // Filtering with streams
        System.out.println("\n6. Filtering with streams:");
        System.out.println("   Sports with score > 20:");
        scores.entrySet().stream()
                .filter(e -> e.getValue() > 20)
                .forEach(e -> System.out.println("     " + e.getKey() + ": " + e.getValue()));

        // Real example: Word count
        String text = "java is great java is powerful java is fun";
        String[] words = text.split(" ");

        HashMap<String, Integer> wordCount = new HashMap<>();
        for(String word : words) {
            // getOrDefault se current count mil jayega (0 if not present)
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("\n7. Word count example:");
        System.out.println("   Text: " + text);
        System.out.println("   Counts:");
        wordCount.forEach((word, count) ->
                System.out.println("     " + word + ": " + count + " times")
        );

        // Performance tip
        System.out.println("\n--- Performance Tip ---");
        System.out.println("Use entrySet() instead of keySet()");
        System.out.println("  keySet(): O(n) for keys + O(n) for get() = O(2n)");
        System.out.println("  entrySet(): O(n) - direct key+value access");
    }
}