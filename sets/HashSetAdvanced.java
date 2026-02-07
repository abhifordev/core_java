package dev.abhi.sets;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Arrays;

public class HashSetAdvanced {
    static class Student {
    String name;
    int marks;

    Student(int i, String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " - " + marks + " marks";
    }
}
    static class Book {
        String title;
        String author;
        int pages;
        int price;

        // Constructor - Object banane ke liye
        Book(String title, String author, int pages, int price) {
            this.title = title;
            this.author = author;
            this.pages = pages;
            this.price = price;
        }

        public Book(String java, String author1) {
        }

        // toString() - Object ko print karne ke liye
        @Override
        public String toString() {
            return String.format("'%s' by %s (%d pages) - ₹%d",
                    title, author, pages, price);
        }
    }
    public static void main(String[] args) {

        System.out.println("HashSet with Custom Objects\n");

        // Custom objects ke saath HashSet use karne ke liye
        // equals() aur hashCode() methods override karne zaroori hain

        System.out.println("--- Custom Object Example ---\n");

        HashSet<Student> students = new HashSet<>();

        Student s1 = new Student(101, "Rahul", 85);
        Student s2 = new Student(102, "Priya", 92);
        Student s3 = new Student(103, "Amit", 78);
        Student s4 = new Student(101, "Rahul", 85);  // Duplicate of s1

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);  // Ye add nahi hoga kyunki duplicate hai

        System.out.println("Added 4 students (1 duplicate)");
        System.out.println("Actual size: " + students.size());
        System.out.println("\nStudents:");
        for (Student s : students) {
            System.out.println("  " + s);
        }

        // Testing contains with custom object
        Student test = new Student(102, "Priya", 92);
        boolean found = students.contains(test);
        System.out.println("\nContains Priya (102)? " + found);

        // Why hashCode and equals are important

        System.out.println("\n--- Why hashCode() and equals() matter? ---\n");

        System.out.println("Without proper hashCode/equals:");
        System.out.println("  - Same students treated as different");
        System.out.println("  - Duplicates allowed ho jayenge");
        System.out.println("  - contains() properly work nahi karega");

        System.out.println("\nWith proper hashCode/equals:");
        System.out.println("  - Same students recognized properly");
        System.out.println("  - Duplicates automatically prevented");
        System.out.println("  - contains() correctly works");

        // HashSet with different data types

        System.out.println("\n--- HashSet with Different Types ---\n");

        // Strings - works perfectly
        HashSet<String> names = new HashSet<>(
                Arrays.asList("Rahul", "Priya", "Amit", "Rahul")
        );
        System.out.println("Strings: " + names + " (size: " + names.size() + ")");

        // Integers - works perfectly
        HashSet<Integer> nums = new HashSet<>(
                Arrays.asList(1, 2, 3, 2, 4, 3, 5)
        );
        System.out.println("Integers: " + nums + " (size: " + nums.size() + ")");

        // Custom objects - need proper equals/hashCode
        HashSet<Book> books = new HashSet<>();
        books.add(new Book("Java", "Author1"));
        books.add(new Book("Python", "Author2"));
        books.add(new Book("Java", "Author1"));  // Duplicate
        System.out.println("Books: size = " + books.size());

        // Comparison: HashSet vs LinkedHashSet vs TreeSet

        System.out.println("\n--- HashSet vs LinkedHashSet vs TreeSet ---\n");

        String[] items = {"Zebra", "Apple", "Mango", "Banana", "Dog", "Cat"};

        // 1. HashSet - no order
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(items));
        System.out.println("1. HashSet (random order):");
        System.out.println("   " + hashSet);

        // 2. LinkedHashSet - insertion order maintained
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(items));
        System.out.println("\n2. LinkedHashSet (insertion order):");
        System.out.println("   " + linkedHashSet);

        // 3. TreeSet - sorted order
        TreeSet<String> treeSet = new TreeSet<>(Arrays.asList(items));
        System.out.println("\n3. TreeSet (sorted order):");
        System.out.println("   " + treeSet);

        // Performance comparison

        System.out.println("\n--- Performance Comparison ---\n");

        int size = 100000;

        // HashSet performance
        HashSet<Integer> hs = new HashSet<>();
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            hs.add(i);
        }
        long hsTime = System.nanoTime() - start;

        // LinkedHashSet performance
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            lhs.add(i);
        }
        long lhsTime = System.nanoTime() - start;

        // TreeSet performance
        TreeSet<Integer> ts = new TreeSet<>();
        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            ts.add(i);
        }
        long tsTime = System.nanoTime() - start;

        System.out.println("Adding 100k elements:");
        System.out.println("  HashSet: " + hsTime / 1_000_000 + " ms (fastest)");
        System.out.println("  LinkedHashSet: " + lhsTime / 1_000_000 + " ms");
        System.out.println("  TreeSet: " + tsTime / 1_000_000 + " ms (slowest)");

        // Contains operation comparison
        start = System.nanoTime();
        hs.contains(99999);
        long hsContains = System.nanoTime() - start;

        start = System.nanoTime();
        lhs.contains(99999);
        long lhsContains = System.nanoTime() - start;

        start = System.nanoTime();
        ts.contains(99999);
        long tsContains = System.nanoTime() - start;

        System.out.println("\nContains operation:");
        System.out.println("  HashSet: " + hsContains + " ns");
        System.out.println("  LinkedHashSet: " + lhsContains + " ns");
        System.out.println("  TreeSet: " + tsContains + " ns");

        // Real world example: Email addresses

        System.out.println("\n--- Real World: Email Newsletter ---\n");

        HashSet<String> subscribers = new HashSet<>();

        String[] signups = {
                "user1@gmail.com", "user2@yahoo.com", "user3@gmail.com",
                "user1@gmail.com", "user4@outlook.com", "user2@yahoo.com"
        };

        System.out.println("Processing " + signups.length + " signups:");
        int added = 0;
        int duplicates = 0;

        for (String email : signups) {
            if (subscribers.add(email)) {
                added++;
                System.out.println("  Added: " + email);
            } else {
                duplicates++;
                System.out.println("  Duplicate: " + email);
            }
        }

        System.out.println("\nSummary:");
        System.out.println("  New subscribers: " + added);
        System.out.println("  Duplicate attempts: " + duplicates);
        System.out.println("  Total unique: " + subscribers.size());

        // Real world example: Word frequency (unique words)

        System.out.println("\n--- Unique Words in Text ---\n");

        String text = "Java is great Java is powerful Java is everywhere";
        String[] words = text.toLowerCase().split(" ");

        HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        System.out.println("Text: " + text);
        System.out.println("Total words: " + words.length);
        System.out.println("Unique words: " + uniqueWords.size());
        System.out.println("Words: " + uniqueWords);

        // Bulk operations demo

        System.out.println("\n--- Bulk Operations ---\n");

        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        HashSet<Integer> set3 = new HashSet<>(Arrays.asList(1, 2, 3));

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Set3: " + set3);

        // containsAll - subset check
        boolean hasAll = set1.containsAll(set3);
        System.out.println("\nSet1 contains all of Set3? " + hasAll);

        // removeAll - difference
        HashSet<Integer> diff = new HashSet<>(set1);
        diff.removeAll(set2);
        System.out.println("Set1 - Set2: " + diff);

        // retainAll - intersection
        HashSet<Integer> inter = new HashSet<>(set1);
        inter.retainAll(set2);
        System.out.println("Set1 ∩ Set2: " + inter);
    }}
