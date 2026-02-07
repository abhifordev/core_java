package dev.abhi.sets;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

public class HashSetBasics {
    public static void main(String[] args) {

        System.out.println("HashSet kya hai?\n");

        // SET ka matlab: Unique elements ka collection
        // Agar duplicate add karoge, wo ignore ho jayega
        // Order maintain nahi hota (random order mein store)
        // Null value allowed hai (sirf ek baar)

        // HashSet internally HashMap use karta hai
        // Fast operations: add, remove, contains - sab O(1)

        // Tarika 1: Khaali HashSet banana
        HashSet<String> fruits = new HashSet<>();
        System.out.println("Khaali HashSet: " + fruits);
        System.out.println("Empty? " + fruits.isEmpty());

        // Tarika 2: Initial capacity ke saath
        // Agar aapko pata hai kitne elements honge, ye better performance deta hai
        HashSet<Integer> numbers = new HashSet<>(20);
        System.out.println("\nCapacity 20 wala HashSet: " + numbers);

        // Tarika 3: Capacity aur Load Factor dono ke saath
        // Load Factor = kitna full hone par resize ho (default 0.75)
        HashSet<String> cities = new HashSet<>(16, 0.75f);
        System.out.println("Custom capacity aur load factor: " + cities);

        // Tarika 4: Existing collection se initialize
        ArrayList<String> colorList = new ArrayList<>(Arrays.asList("Red", "Green", "Blue", "Red"));
        HashSet<String> colors = new HashSet<>(colorList);
        System.out.println("\nArrayList se HashSet: " + colors);
        System.out.println("Notice: Duplicate 'Red' remove ho gaya!");

        // HashSet ka main feature dekho - DUPLICATES ALLOWED NAHI

        System.out.println("\n--- Duplicate Handling Demo ---\n");

        HashSet<String> students = new HashSet<>();

        boolean added1 = students.add("Rahul");
        System.out.println("Add 'Rahul': " + added1 + " | Set: " + students);

        boolean added2 = students.add("Priya");
        System.out.println("Add 'Priya': " + added2 + " | Set: " + students);

        boolean added3 = students.add("Amit");
        System.out.println("Add 'Amit': " + added3 + " | Set: " + students);

        // Ab dubara Rahul add karne ki koshish
        boolean added4 = students.add("Rahul");
        System.out.println("Add 'Rahul' again: " + added4 + " | Set: " + students);
        System.out.println("Size still: " + students.size() + " (duplicate nahi add hua)");

        // ORDER ka demo - HashSet order guarantee nahi karta

        System.out.println("\n--- Order Demo ---\n");

        HashSet<Integer> nums = new HashSet<>();
        nums.add(5);
        nums.add(1);
        nums.add(3);
        nums.add(2);
        nums.add(4);

        System.out.println("Added in order: 5,1,3,2,4");
        System.out.println("HashSet order: " + nums);
        System.out.println("Dekho - order preserved nahi hai!");

        // NULL handling

        System.out.println("\n--- Null Handling ---\n");

        HashSet<String> languages = new HashSet<>();
        languages.add("Java");
        languages.add("Python");
        languages.add(null);  // Ek null allowed hai
        languages.add("C++");
        languages.add(null);  // Duplicate null ignore hoga

        System.out.println("Languages: " + languages);
        System.out.println("Contains null? " + languages.contains(null));

        // Basic Operations

        System.out.println("\n--- Basic Operations ---\n");

        HashSet<String> cars = new HashSet<>();

        // 1. add() - element add karna
        cars.add("BMW");
        cars.add("Audi");
        cars.add("Mercedes");
        System.out.println("1. After adding: " + cars);

        // 2. size() - kitne elements
        System.out.println("2. Size: " + cars.size());

        // 3. contains() - element hai ya nahi
        boolean hasBMW = cars.contains("BMW");
        boolean hasToyota = cars.contains("Toyota");
        System.out.println("3. Contains BMW? " + hasBMW);
        System.out.println("   Contains Toyota? " + hasToyota);

        // 4. remove() - element remove karna
        boolean removed = cars.remove("Audi");
        System.out.println("4. Remove Audi: " + removed + " | Cars: " + cars);

        // 5. isEmpty() - khaali hai ya nahi
        System.out.println("5. Is empty? " + cars.isEmpty());

        // 6. clear() - saare elements remove
        HashSet<String> temp = new HashSet<>(cars);
        temp.clear();
        System.out.println("6. After clear: " + temp + " (empty? " + temp.isEmpty() + ")");

        // addAll() - multiple elements ek saath

        System.out.println("\n--- Adding Multiple Elements ---\n");

        HashSet<String> fruits1 = new HashSet<>();
        fruits1.add("Apple");
        fruits1.add("Banana");

        HashSet<String> fruits2 = new HashSet<>();
        fruits2.add("Mango");
        fruits2.add("Orange");
        fruits2.add("Apple");  // Duplicate

        System.out.println("Fruits1: " + fruits1);
        System.out.println("Fruits2: " + fruits2);

        fruits1.addAll(fruits2);
        System.out.println("After addAll: " + fruits1);
        System.out.println("Notice: Duplicate Apple add nahi hua");

        // HashSet vs ArrayList comparison

        System.out.println("\n--- HashSet vs ArrayList ---\n");

        System.out.println("HashSet:");
        System.out.println("  - Duplicates: NOT allowed");
        System.out.println("  - Order: NOT maintained");
        System.out.println("  - Null: ONE allowed");
        System.out.println("  - Access: No index-based access");
        System.out.println("  - Performance: Fast O(1) for add/remove/contains");
        System.out.println("  - Use: Jab duplicates nahi chahiye");

        System.out.println("\nArrayList:");
        System.out.println("  - Duplicates: Allowed");
        System.out.println("  - Order: Maintained (insertion order)");
        System.out.println("  - Null: Multiple allowed");
        System.out.println("  - Access: Index-based get(i)");
        System.out.println("  - Performance: Fast O(1) for get, slow for contains");
        System.out.println("  - Use: Jab order aur duplicates chahiye");

        // Real-world example: Unique usernames

        System.out.println("\n--- Real World Example: Unique Usernames ---\n");

        HashSet<String> usernames = new HashSet<>();

        System.out.println("User registration:");

        String user1 = "rahul123";
        if(usernames.add(user1)) {
            System.out.println("  '" + user1 + "' registered successfully");
        } else {
            System.out.println("  '" + user1 + "' already taken!");
        }

        String user2 = "priya456";
        if(usernames.add(user2)) {
            System.out.println("  '" + user2 + "' registered successfully");
        } else {
            System.out.println("  '" + user2 + "' already taken!");
        }

        String user3 = "rahul123";  // Duplicate
        if(usernames.add(user3)) {
            System.out.println("  '" + user3 + "' registered successfully");
        } else {
            System.out.println("  '" + user3 + "' already taken!");
        }

        System.out.println("\nTotal registered users: " + usernames.size());
        System.out.println("Usernames: " + usernames);

        // Important points

        System.out.println("\n--- Important Points ---\n");
        System.out.println("1. HashSet internally HashMap use karta hai");
        System.out.println("2. Duplicate elements automatically ignore ho jate");
        System.out.println("3. Insertion order maintain nahi hota");
        System.out.println("4. Fast operations - O(1) average case");
        System.out.println("5. Not thread-safe (synchronization chahiye toh Collections.synchronizedSet)");
        System.out.println("6. Best use: Jab uniqueness chahiye aur order matter nahi karta");

        // Performance demo

        System.out.println("\n--- Performance Comparison ---\n");

        int testSize = 10000;

        // ArrayList contains() - slow O(n)
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < testSize; i++) {
            arrayList.add(i);
        }

        long start = System.nanoTime();
        arrayList.contains(9999);
        long alTime = System.nanoTime() - start;

        // HashSet contains() - fast O(1)
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0; i < testSize; i++) {
            hashSet.add(i);
        }

        start = System.nanoTime();
        hashSet.contains(9999);
        long hsTime = System.nanoTime() - start;

        System.out.println("Contains 9999 in 10k elements:");
        System.out.println("  ArrayList: " + alTime + " ns");
        System.out.println("  HashSet: " + hsTime + " ns");
        System.out.println("  HashSet is " + (alTime/hsTime) + "x faster!");

        // When to use HashSet

        System.out.println("\n--- When to use HashSet? ---\n");
        System.out.println("Use HashSet jab:");
        System.out.println("  - Duplicate elements nahi chahiye");
        System.out.println("  - Fast lookup chahiye (contains operation)");
        System.out.println("  - Order matter nahi karta");
        System.out.println("  - Unique items store karne hain");

        System.out.println("\nDon't use HashSet jab:");
        System.out.println("  - Insertion order preserve karni ho (use LinkedHashSet)");
        System.out.println("  - Sorted order chahiye (use TreeSet)");
        System.out.println("  - Duplicate elements allowed chahiye (use ArrayList)");
        System.out.println("  - Index-based access chahiye (use ArrayList)");
    }
}