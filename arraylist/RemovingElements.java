package dev.abhi.arraylist;
import java.util.ArrayList;

public class RemovingElements {
    public static void main(String[] args) {

        ArrayList<String> subjects = new ArrayList<>();
        subjects.add("Math");
        subjects.add("Science");
        subjects.add("English");
        subjects.add("Hindi");
        subjects.add("Science");  // Duplicate entry
        subjects.add("Social Studies");

        System.out.println("Original list: " + subjects);

        // METHOD 1: remove(index) - Index ke basis par remove karna
        String removed = subjects.remove(1);  // Index 1 remove kar rahe hain
        System.out.println("\nRemoved element: " + removed);
        System.out.println("Remove ke baad: " + subjects);

        // METHOD 2: remove(Object) - Value ke basis par remove karna
        // DHYAN: Ye sirf PEHLI matching value remove karega
        boolean removed2 = subjects.remove("Science");
        System.out.println("\nKya Science remove hua? " + removed2);
        System.out.println("Science remove karne ke baad: " + subjects);

        // METHOD 3: removeAll() - Multiple elements ek saath remove karna
        ArrayList<String> toRemove = new ArrayList<>();
        toRemove.add("Hindi");
        toRemove.add("Math");

        subjects.removeAll(toRemove);
        System.out.println("\nHindi aur Math remove karne ke baad: " + subjects);

        // METHOD 4: clear() - Saare elements remove karna
        ArrayList<String> temp = new ArrayList<>(subjects);
        temp.clear();
        System.out.println("Clear() ke baad: " + temp);
        System.out.println("Kya khaali hai? " + temp.isEmpty());

        // METHOD 5: removeIf() - Condition ke basis par remove karna (Java 8+)
        subjects.add("Computer");
        subjects.add("Art");

        // Jinki length 5 se zyada hai unhe remove karo
        subjects.removeIf(subject -> subject.length() > 5);
        System.out.println("\nLength > 5 wale remove karne ke baad: " + subjects);

        /*
         * IMPORTANT POINTS:
         * - remove(int index) - index se remove karta hai, element return karta hai
         * - remove(Object o) - value se remove karta hai, boolean return karta hai
         * - removeAll() saare matching elements remove kar deta hai
         * - clear() ke baad size() = 0 ho jata hai
         */
    }
}