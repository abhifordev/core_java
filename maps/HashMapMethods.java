package dev.abhi.maps;
import java.util.HashMap;

public class HashMapMethods {
    public static void main(String[] args) {

        // putIfAbsent - agar key nahi hai tabhi add karo
        System.out.println("1. putIfAbsent():");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);

        map.putIfAbsent("C", 3);  // Add hoga, C nahi hai
        map.putIfAbsent("A", 10); // Add nahi hoga, A already hai

        System.out.println("   Map: " + map);

        // replace - existing key ki value change karo
        System.out.println("\n2. replace():");
        map.replace("A", 100);    // A ki value 100 ho jayegi
        map.replace("D", 400);    // Kuch nahi hoga, D exist nahi karta
        System.out.println("   After replace: " + map);

        // replace with old value check
        boolean replaced = map.replace("A", 100, 500);  // If A=100, change to 500
        System.out.println("   Replaced? " + replaced + " | Map: " + map);

        // compute - key ki value ko update karo using function
        System.out.println("\n3. compute():");
        map.compute("B", (key, value) -> value * 2);  // B ki value double
        System.out.println("   After compute: " + map);

        // computeIfPresent - agar key hai tabhi compute
        System.out.println("\n4. computeIfPresent():");
        map.computeIfPresent("C", (k, v) -> v + 10);  // C present hai, +10
        map.computeIfPresent("X", (k, v) -> v + 10);  // X nahi hai, kuch nahi hoga
        System.out.println("   After computeIfPresent: " + map);

        // computeIfAbsent - agar key nahi hai toh compute karke add
        System.out.println("\n5. computeIfAbsent():");
        map.computeIfAbsent("D", k -> 100);  // D nahi hai, add with 100
        map.computeIfAbsent("A", k -> 999);  // A hai, kuch nahi hoga
        System.out.println("   After computeIfAbsent: " + map);

        // merge - values ko merge karo
        System.out.println("\n6. merge():");
        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("X", 10);
        map2.put("Y", 20);
        map2.put("A", 5);  // A already map mein hai

        System.out.println("   Map1: " + map);
        System.out.println("   Map2: " + map2);

        // Merge map2 into map
        map2.forEach((key, value) ->
                map.merge(key, value, (oldVal, newVal) -> oldVal + newVal)
        );
        System.out.println("   After merge: " + map);

        // Real example: Shopping cart
        System.out.println("\n7. Real Example - Shopping Cart:");
        HashMap<String, Integer> cart = new HashMap<>();

        // Adding items
        cart.merge("Apple", 2, Integer::sum);   // Add 2 apples
        cart.merge("Banana", 5, Integer::sum);  // Add 5 bananas
        cart.merge("Apple", 3, Integer::sum);   // Add 3 more apples (total 5)

        System.out.println("   Cart: " + cart);

        // Real example: Character frequency
        System.out.println("\n8. Character Frequency:");
        String str = "hello";
        HashMap<Character, Integer> freq = new HashMap<>();

        for(char c : str.toCharArray()) {
            freq.merge(c, 1, Integer::sum);  // Increment count
        }

        System.out.println("   String: " + str);
        System.out.println("   Frequency: " + freq);

        // Copying HashMap
        System.out.println("\n9. Copying HashMap:");
        HashMap<String, Integer> original = new HashMap<>();
        original.put("One", 1);
        original.put("Two", 2);

        // Method 1: Constructor
        HashMap<String, Integer> copy1 = new HashMap<>(original);

        // Method 2: putAll
        HashMap<String, Integer> copy2 = new HashMap<>();
        copy2.putAll(original);

        System.out.println("   Original: " + original);
        System.out.println("   Copy1: " + copy1);
        System.out.println("   Copy2: " + copy2);

        // Removing based on condition
        System.out.println("\n10. removeIf on entries:");
        HashMap<String, Integer> numbers = new HashMap<>();
        numbers.put("One", 1);
        numbers.put("Two", 2);
        numbers.put("Three", 3);
        numbers.put("Four", 4);

        System.out.println("    Before: " + numbers);
        numbers.entrySet().removeIf(e -> e.getValue() % 2 == 0);  // Remove even
        System.out.println("    After removing even: " + numbers);
    }
}