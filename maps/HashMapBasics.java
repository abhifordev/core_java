package dev.abhi.maps;
import java.util.HashMap;

public class HashMapBasics {
    public static void main(String[] args) {

        // HashMap stores data in Key-Value pairs
        // Key unique honi chahiye, Value duplicate ho sakti hai
        // Order maintain nahi hota
        // One null key allowed, multiple null values allowed

        // Creating HashMap
        HashMap<String, Integer> studentMarks = new HashMap<>();

        // Adding elements - put(key, value)
        studentMarks.put("Rahul", 85);
        studentMarks.put("Priya", 92);
        studentMarks.put("Amit", 78);
        studentMarks.put("Neha", 95);

        System.out.println("Student Marks: " + studentMarks);
        System.out.println("Size: " + studentMarks.size());

        // Getting value by key - get(key)
        int rahulMarks = studentMarks.get("Rahul");
        System.out.println("\nRahul's marks: " + rahulMarks);

        // Check if key exists - containsKey()
        boolean hasPriya = studentMarks.containsKey("Priya");
        boolean hasVikram = studentMarks.containsKey("Vikram");
        System.out.println("\nHas Priya? " + hasPriya);
        System.out.println("Has Vikram? " + hasVikram);

        // Check if value exists - containsValue()
        boolean has95 = studentMarks.containsValue(95);
        System.out.println("Has 95 marks? " + has95);

        // Update value - put() with existing key
        studentMarks.put("Rahul", 90);  // Updates Rahul's marks
        System.out.println("\nAfter updating Rahul: " + studentMarks);

        // Remove entry - remove(key)
        studentMarks.remove("Amit");
        System.out.println("After removing Amit: " + studentMarks);

        // Clear all - clear()
        HashMap<String, Integer> temp = new HashMap<>(studentMarks);
        temp.clear();
        System.out.println("\nAfter clear: " + temp);
        System.out.println("Is empty? " + temp.isEmpty());

        // Null handling
        HashMap<String, String> map = new HashMap<>();
        map.put(null, "NullKey");  // One null key allowed
        map.put("Key1", null);     // Multiple null values allowed
        map.put("Key2", null);
        System.out.println("\nNull demo: " + map);

        // Real example: Phone directory
        HashMap<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Rahul", "9876543210");
        phoneBook.put("Priya", "9123456780");
        phoneBook.put("Amit", "9988776655");

        System.out.println("\nPhone Book: " + phoneBook);
        String priyaNumber = phoneBook.get("Priya");
        System.out.println("Priya's number: " + priyaNumber);

        // getOrDefault - agar key nahi hai toh default value return
        String vikramNumber = phoneBook.getOrDefault("Vikram", "Not Found");
        System.out.println("Vikram's number: " + vikramNumber);

        // Important points
        System.out.println("\n--- Key Points ---");
        System.out.println("1. Stores Key-Value pairs");
        System.out.println("2. Keys must be unique");
        System.out.println("3. No order maintained");
        System.out.println("4. O(1) for get/put operations");
        System.out.println("5. One null key, multiple null values");
    }
}