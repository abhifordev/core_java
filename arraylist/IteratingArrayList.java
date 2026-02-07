package dev.abhi.arraylist;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratingArrayList {
    public static void main(String[] args) {

        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(85);
        marks.add(92);
        marks.add(78);
        marks.add(95);
        marks.add(88);

        System.out.println("Marks list: " + marks + "\n");

        // TARIKA 1: Simple for loop (Traditional way)
        System.out.println("=== Simple For Loop ===");
        for(int i = 0; i < marks.size(); i++) {
            System.out.println("Index " + i + ": " + marks.get(i) + " marks");
        }

        // TARIKA 2: Enhanced for loop (For-each loop) - Sabse zyada use hota hai
        System.out.println("\n=== Enhanced For Loop ===");
        for(Integer mark : marks) {
            System.out.println("Marks: " + mark);
        }

        // TARIKA 3: forEach() with Lambda (Java 8+) - Modern way
        System.out.println("\n=== forEach with Lambda ===");
        marks.forEach(mark -> System.out.println("Score: " + mark));

        // TARIKA 4: Iterator use karna - When you need to remove during iteration
        System.out.println("\n=== Iterator ===");
        Iterator<Integer> iterator = marks.iterator();
        while(iterator.hasNext()) {
            Integer mark = iterator.next();
            System.out.println("Mark: " + mark);

            // Example: 80 se kam marks remove karna
            if(mark < 80) {
                iterator.remove();  // Safely remove during iteration
            }
        }
        System.out.println("80 se kam marks remove karne ke baad: " + marks);

        // TARIKA 5: ListIterator - Bidirectional iteration (aage-peeche dono)
        System.out.println("\n=== ListIterator (Forward and Backward) ===");
        ListIterator<Integer> listIterator = marks.listIterator();

        System.out.println("Forward direction:");
        while(listIterator.hasNext()) {
            System.out.println("Position " + listIterator.nextIndex() + ": " + listIterator.next());
        }

        System.out.println("\nBackward direction:");
        while(listIterator.hasPrevious()) {
            System.out.println("Position " + listIterator.previousIndex() + ": " + listIterator.previous());
        }

        /*
         * BEST PRACTICES:
         * - Simple reading ke liye: Enhanced for loop use karo
         * - Removal chahiye iteration ke time: Iterator use karo
         * - Index chahiye: Traditional for loop use karo
         * - Modern code: forEach() with lambda use karo
         */
    }
}