package dev.abhi.maps;
import java.util.*;

public class MapComparison {
    public static void main(String[] args) {

        System.out.println("HashMap vs LinkedHashMap vs TreeMap\n");

        String[] keys = {"Zebra", "Apple", "Mango", "Banana"};

        // 1. HashMap - no order, fastest
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], i + 1);
        }
        System.out.println("1. HashMap (random order):");
        System.out.println("   " + hashMap);
        System.out.println("   Null key? YES | Order? NO | Speed? FASTEST");

        // 2. LinkedHashMap - insertion order maintained
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for(int i = 0; i < keys.length; i++) {
            linkedHashMap.put(keys[i], i + 1);
        }
        System.out.println("\n2. LinkedHashMap (insertion order):");
        System.out.println("   " + linkedHashMap);
        System.out.println("   Null key? YES | Order? INSERTION | Speed? FAST");

        // 3. TreeMap - sorted order
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for(int i = 0; i < keys.length; i++) {
            treeMap.put(keys[i], i + 1);
        }
        System.out.println("\n3. TreeMap (sorted order):");
        System.out.println("   " + treeMap);
        System.out.println("   Null key? NO | Order? SORTED | Speed? SLOWER");

        // 4. Hashtable - legacy, synchronized
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        for(int i = 0; i < keys.length; i++) {
            hashtable.put(keys[i], i + 1);
        }
        System.out.println("\n4. Hashtable (thread-safe, legacy):");
        System.out.println("   " + hashtable);
        System.out.println("   Null key? NO | Null value? NO | Thread-safe? YES");

        // Performance comparison
        System.out.println("\n--- Performance Test ---\n");

        int size = 100000;

        // HashMap
        long start = System.nanoTime();
        HashMap<Integer, String> hm = new HashMap<>();
        for(int i = 0; i < size; i++) hm.put(i, "Value" + i);
        long hmTime = System.nanoTime() - start;

        // LinkedHashMap
        start = System.nanoTime();
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();
        for(int i = 0; i < size; i++) lhm.put(i, "Value" + i);
        long lhmTime = System.nanoTime() - start;

        // TreeMap
        start = System.nanoTime();
        TreeMap<Integer, String> tm = new TreeMap<>();
        for(int i = 0; i < size; i++) tm.put(i, "Value" + i);
        long tmTime = System.nanoTime() - start;

        System.out.println("Adding 100k elements:");
        System.out.println("  HashMap: " + hmTime/1_000_000 + " ms (fastest)");
        System.out.println("  LinkedHashMap: " + lhmTime/1_000_000 + " ms");
        System.out.println("  TreeMap: " + tmTime/1_000_000 + " ms (slowest)");

        // Feature comparison table
        System.out.println("\n--- Feature Comparison ---\n");
        System.out.println("Feature       | HashMap | LinkedHashMap | TreeMap | Hashtable");
        System.out.println("Order         | No      | Insertion     | Sorted  | No");
        System.out.println("Null key      | Yes(1)  | Yes(1)        | No      | No");
        System.out.println("Null value    | Yes     | Yes           | Yes     | No");
        System.out.println("Thread-safe   | No      | No            | No      | Yes");
        System.out.println("Performance   | O(1)    | O(1)          | O(logn) | O(1)");
        System.out.println("Use case      | General | Order needed  | Sorted  | Legacy");

        // When to use what
        System.out.println("\n--- When to use? ---\n");
        System.out.println("HashMap:");
        System.out.println("  - Default choice for most cases");
        System.out.println("  - When order doesn't matter");
        System.out.println("  - Need fast operations");

        System.out.println("\nLinkedHashMap:");
        System.out.println("  - Need to maintain insertion order");
        System.out.println("  - Predictable iteration order");
        System.out.println("  - LRU cache implementation");

        System.out.println("\nTreeMap:");
        System.out.println("  - Need sorted keys");
        System.out.println("  - Range operations needed");
        System.out.println("  - Natural ordering important");

        System.out.println("\nHashtable:");
        System.out.println("  - Legacy code only");
        System.out.println("  - Use ConcurrentHashMap instead");

        // Real example: LRU Cache using LinkedHashMap
        System.out.println("\n--- Real Example: LRU Cache ---\n");

        // LinkedHashMap with access order (most recently used last)
        LinkedHashMap<String, String> cache = new LinkedHashMap<>(3, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > 3;  // Max 3 entries
            }
        };

        cache.put("Page1", "Data1");
        cache.put("Page2", "Data2");
        cache.put("Page3", "Data3");
        System.out.println("Cache after 3 adds: " + cache);

        cache.get("Page1");  // Access Page1
        System.out.println("After accessing Page1: " + cache);

        cache.put("Page4", "Data4");  // Page2 will be removed (eldest)
        System.out.println("After adding Page4: " + cache);

        // Key points
        System.out.println("\n--- Key Points ---");
        System.out.println("1. HashMap = Fast, no order");
        System.out.println("2. LinkedHashMap = Fast, maintains order");
        System.out.println("3. TreeMap = Slower, sorted order");
        System.out.println("4. Hashtable = Don't use, legacy");
        System.out.println("5. For thread-safe: Use ConcurrentHashMap");
    }
}
//
//HashMap Basics:
//
//        1. Key-Value pairs store hota hai
//2. Keys unique, values duplicate ho sakti
//3. No order guarantee
//4. O(1) operations - super fast
//5. One null key, multiple null values allowed
//
//Common Methods:
//        - put(k,v) - add/update
//- get(k) - retrieve value
//- remove(k) - delete entry
//- containsKey(k) - check key
//- containsValue(v) - check value
//- keySet() - all keys
//- values() - all values
//- entrySet() - all entries (best for iteration)
//
//Use Cases:
//        - Database/cache
//- Counting frequency
//- Phone directory
//- Configuration data
//- Fast lookup needed
//
//Comparison:
//        - HashMap: Fast, no order
//- LinkedHashMap: Fast, insertion order
//- TreeMap: Slower, sorted order
//- Hashtable: Old, don't use