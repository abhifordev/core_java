package dev.abhi.arraylist;
import java.util.ArrayList;

public class SearchingArrayList {
    public static void main(String[] args) {

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add("Banana");  // Duplicate
        fruits.add("Grapes");

        System.out.println("Fruits list: " + fruits + "\n");

        // METHOD 1: contains() - Kya element present hai?
        boolean hasApple = fruits.contains("Apple");
        System.out.println("Kya Apple hai list mein? " + hasApple);

        boolean hasWatermelon = fruits.contains("Watermelon");
        System.out.println("Kya Watermelon hai? " + hasWatermelon);

        // METHOD 2: indexOf() - Pehli occurrence ka index milta hai
        int bananaIndex = fruits.indexOf("Banana");
        System.out.println("\nPehle Banana ka index: " + bananaIndex);

        int notFound = fruits.indexOf("Pineapple");
        System.out.println("Pineapple ka index (nahi mila): " + notFound);  // -1 return hoga

        // METHOD 3: lastIndexOf() - Aakhri occurrence ka index
        int lastBanana = fruits.lastIndexOf("Banana");
        System.out.println("\nAakhri Banana ka index: " + lastBanana);

        // METHOD 4: containsAll() - Kya saare elements present hain?
        ArrayList<String> checkList = new ArrayList<>();
        checkList.add("Apple");
        checkList.add("Mango");

        boolean hasAll = fruits.containsAll(checkList);
        System.out.println("\nKya Apple aur Mango dono hain? " + hasAll);

        checkList.add("Watermelon");
        boolean hasAll2 = fruits.containsAll(checkList);
        System.out.println("Kya Apple, Mango aur Watermelon teeno hain? " + hasAll2);

        // BONUS: Custom search with stream (Java 8+)
        System.out.println("\n=== Custom Search ===");

        // 'a' letter wale fruits find karo
        System.out.println("Fruits with 'a':");
        fruits.stream()
                .filter(fruit -> fruit.toLowerCase().contains("a"))
                .forEach(fruit -> System.out.println("  - " + fruit));

        // Count how many fruits start with 'B'
        long countB = fruits.stream()
                .filter(fruit -> fruit.startsWith("B"))
                .count();
        System.out.println("\n'B' se start hone wale fruits: " + countB);

        /*
         * YAAD RAKHNE WALI BAATEIN:
         * - indexOf() = pehli occurrence, lastIndexOf() = aakhri occurrence
         * - Dono -1 return karte hain agar element nahi mila
         * - contains() case-sensitive hai
         * - Stream operations Java 8+ mein available hain
         */
    }
}