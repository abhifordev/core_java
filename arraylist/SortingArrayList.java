package dev.abhi.arraylist;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortingArrayList {
    public static void main(String[] args) {

        // INTEGER SORTING
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(45);
        numbers.add(12);
        numbers.add(89);
        numbers.add(23);
        numbers.add(67);

        System.out.println("Original numbers: " + numbers);

        // TARIKA 1: Collections.sort() - Ascending order (chhote se bade)
        Collections.sort(numbers);
        System.out.println("Ascending order: " + numbers);

        // TARIKA 2: Collections.sort() with Comparator - Descending order (bade se chhote)
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Descending order: " + numbers);

        // STRING SORTING
        System.out.println("\n=== String Sorting ===");
        ArrayList<String> names = new ArrayList<>();
        names.add("Rahul");
        names.add("Amit");
        names.add("Zoya");
        names.add("Priya");
        names.add("Neha");

        System.out.println("Original names: " + names);

        // Alphabetical order (A to Z)
        Collections.sort(names);
        System.out.println("Alphabetical order: " + names);

        // Reverse alphabetical (Z to A)
        Collections.sort(names, Collections.reverseOrder());
        System.out.println("Reverse alphabetical: " + names);

        // CUSTOM SORTING WITH LAMBDA (Java 8+)
        System.out.println("\n=== Custom Sorting ===");

        // Length ke basis par sort karo (chhoti se badi string)
        Collections.sort(names, (s1, s2) -> s1.length() - s2.length());
        System.out.println("Length ke basis par: " + names);

        // TARIKA 3: list.sort() method (Java 8+)
        names.sort(Comparator.naturalOrder());  // Natural order
        System.out.println("Natural order (list.sort): " + names);

        // CUSTOM OBJECT SORTING
        System.out.println("\n=== Custom Object Sorting ===");
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Rahul", 85));
        students.add(new Student("Priya", 92));
        students.add(new Student("Amit", 78));
        students.add(new Student("Neha", 95));

        System.out.println("Original students:");
        students.forEach(s -> System.out.println("  " + s));

        // Marks ke basis par sort karo
        students.sort((s1, s2) -> s1.marks - s2.marks);
        System.out.println("\nMarks ke basis par (ascending):");
        students.forEach(s -> System.out.println("  " + s));

        // Name ke basis par sort karo
        students.sort(Comparator.comparing(s -> s.name));
        System.out.println("\nName ke basis par:");
        students.forEach(s -> System.out.println("  " + s));

        /*
         * SORTING TIPS:
         * - Collections.sort() = collection ko modify karta hai
         * - Wrapper classes (Integer, Double) automatic sort ho jate hain
         * - Custom objects ke liye Comparator chahiye
         * - Lambda expressions se sorting bahut easy ho gaya hai
         */
    }
}

// Helper class for custom object sorting
class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " - " + marks + " marks";
    }
}