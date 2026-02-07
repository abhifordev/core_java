package dev.abhi.arraylist;
import java.util.ArrayList;

public class AddingElements {
    public static void main(String[] args) {

        ArrayList<String> students = new ArrayList<>();

        // METHOD 1: add() - Element ko last mein add karta hai
        students.add("Rahul");
        students.add("Priya");
        students.add("Amit");
        System.out.println("Students list: " + students);

        // METHOD 2: add(index, element) - Specific position par add karna
        // Index 1 par "Sneha" add kar rahe hain
        students.add(1, "Sneha");
        System.out.println("Sneha ko index 1 par add karne ke baad: " + students);

        // METHOD 3: addAll() - Ek saath multiple elements add karna
        ArrayList<String> moreStudents = new ArrayList<>();
        moreStudents.add("Vikram");
        moreStudents.add("Neha");

        students.addAll(moreStudents);
        System.out.println("More students add karne ke baad: " + students);

        // METHOD 4: addAll(index, collection) - Specific index par multiple elements
        ArrayList<String> newBatch = new ArrayList<>();
        newBatch.add("Ravi");
        newBatch.add("Pooja");

        students.addAll(2, newBatch);  // Index 2 par add kar rahe hain
        System.out.println("Index 2 par new batch add karne ke baad: " + students);

        /*
         * PRO TIP:
         * - add() method hamesha true return karta hai
         * - Index bounds ke bahar add karne par IndexOutOfBoundsException aata hai
         * - addAll() empty list ke saath bhi kaam karta hai (kuch nahi hota)
         */

        // Example: Return value check karna
        boolean added = students.add("Karan");
        System.out.println("\nKya Karan add hua? " + added);
    }
}