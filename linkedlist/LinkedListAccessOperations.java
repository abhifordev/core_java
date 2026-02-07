package dev.abhi.linkedlist;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Collections;

public class LinkedListAccessOperations {
    public static void main(String[] args) {

        System.out.println("LinkedList - Access aur Search Operations\n");

        LinkedList<String> browsers = new LinkedList<>();
        Collections.addAll(browsers, "Chrome", "Firefox", "Edge", "Safari", "Opera", "Brave");
        System.out.println("Browsers: " + browsers);

        // ACCESS OPERATIONS
        // Dhyan do: LinkedList mein index-based access SLOW hai
        // Kyunki har baar puri list traverse karni padti hai

        System.out.println("\n--- Access Operations ---\n");

        // 1. get(index) - index se element nikalna (slow - O(n))
        String browser = browsers.get(2);
        System.out.println("1. get(2): " + browser);

        // 2. getFirst() - pehla element (fast - O(1))
        String first = browsers.getFirst();
        System.out.println("2. getFirst: " + first);

        // 3. getLast() - last element (fast - O(1))
        String last = browsers.getLast();
        System.out.println("3. getLast: " + last);

        // 4. set() - value change karna
        String oldValue = browsers.set(1, "Firefox Dev Edition");
        System.out.println("4. set(1): purani value = " + oldValue);
        System.out.println("   Updated: " + browsers);

        // PEEK OPERATIONS - Dekhna but remove mat karo
        // Ye Queue/Deque operations hain

        System.out.println("\n--- Peek Operations (Look but don't remove) ---\n");

        // 1. peek() - first element dekho
        String peeked1 = browsers.peek();
        System.out.println("1. peek: " + peeked1);
        System.out.println("   List unchanged: " + browsers);

        // 2. peekFirst() - same as peek
        String peeked2 = browsers.peekFirst();
        System.out.println("2. peekFirst: " + peeked2);

        // 3. peekLast() - last element dekho
        String peeked3 = browsers.peekLast();
        System.out.println("3. peekLast: " + peeked3);

        // 4. element() - peek jaisa but exception throw karta if empty
        String elem = browsers.element();
        System.out.println("4. element: " + elem);

        // Empty list par difference
        LinkedList<String> empty = new LinkedList<>();
        String peekEmpty = empty.peek();  // null return - safe
        System.out.println("\n5. peek on empty: " + peekEmpty + " (safe)");
        // String elemEmpty = empty.element();  // exception throw - unsafe!

        // SEARCH OPERATIONS

        System.out.println("\n--- Search Operations ---\n");

        LinkedList<Integer> numbers = new LinkedList<>();
        Collections.addAll(numbers, 10, 20, 30, 20, 40, 50, 20);
        System.out.println("Numbers: " + numbers);

        // 1. contains() - element hai ya nahi
        boolean has30 = numbers.contains(30);
        boolean has70 = numbers.contains(70);
        System.out.println("\n1. contains(30): " + has30);
        System.out.println("   contains(70): " + has70);

        // 2. indexOf() - pehli occurrence ka index
        int idx1 = numbers.indexOf(20);
        int idx2 = numbers.indexOf(100);
        System.out.println("\n2. indexOf(20): " + idx1 + " (first occurrence)");
        System.out.println("   indexOf(100): " + idx2 + " (-1 = not found)");

        // 3. lastIndexOf() - aakhri occurrence
        int lastIdx = numbers.lastIndexOf(20);
        System.out.println("\n3. lastIndexOf(20): " + lastIdx + " (last occurrence)");

        // 4. size() aur isEmpty()
        System.out.println("\n4. size: " + numbers.size());
        System.out.println("   isEmpty: " + numbers.isEmpty());

        // ITERATION METHODS
        // LinkedList ko iterate karne ke different ways

        System.out.println("\n--- Iteration Methods ---\n");

        LinkedList<String> fruits = new LinkedList<>();
        Collections.addAll(fruits, "Apple", "Banana", "Mango", "Orange", "Grapes");

        // 1. Simple for loop - NOT RECOMMENDED for LinkedList
        // Kyunki har get(i) call slow hai, total O(n²) ho jata
        System.out.println("1. Simple for loop (AVOID for LinkedList):");
        for(int i = 0; i < fruits.size(); i++) {
            System.out.println("   " + i + ": " + fruits.get(i));
        }

        // 2. Enhanced for loop - BEST for reading
        System.out.println("\n2. Enhanced for loop (BEST):");
        for(String fruit : fruits) {
            System.out.println("   - " + fruit);
        }

        // 3. forEach with lambda
        System.out.println("\n3. forEach lambda:");
        fruits.forEach(fruit -> System.out.println("   * " + fruit));

        // 4. Iterator - good for safe removal
        System.out.println("\n4. Iterator:");
        Iterator<String> iter = fruits.iterator();
        while(iter.hasNext()) {
            String fruit = iter.next();
            System.out.println("   > " + fruit);
            // iter.remove() kar sakte ho safely
        }

        // 5. ListIterator - aage peeche dono
        System.out.println("\n5. ListIterator (forward):");
        ListIterator<String> listIter = fruits.listIterator();
        while(listIter.hasNext()) {
            System.out.println("   [" + listIter.nextIndex() + "] " + listIter.next());
        }

        System.out.println("\n6. ListIterator (backward):");
        while(listIter.hasPrevious()) {
            System.out.println("   [" + listIter.previousIndex() + "] " + listIter.previous());
        }

        // 7. descendingIterator - reverse order
        System.out.println("\n7. descendingIterator (reverse):");
        Iterator<String> descIter = fruits.descendingIterator();
        while(descIter.hasNext()) {
            System.out.println("   < " + descIter.next());
        }

        // 8. Stream operations
        System.out.println("\n8. Stream operations:");
        System.out.println("   Fruits with 'a':");
        fruits.stream()
                .filter(f -> f.toLowerCase().contains("a"))
                .forEach(f -> System.out.println("     - " + f));

        long count = fruits.stream()
                .filter(f -> f.length() > 5)
                .count();
        System.out.println("\n   Length > 5: " + count);

        // Performance tips
        System.out.println("\n--- Performance Tips ---");
        System.out.println("DO:");
        System.out.println("  - Enhanced for loop use karo");
        System.out.println("  - getFirst/getLast use karo instead of get(0)/get(size-1)");
        System.out.println("  - Iterator use karo for removal");

        System.out.println("\nDON'T:");
        System.out.println("  - Index-based loop mat use karo (O(n²) ban jata!)");
        System.out.println("  - Random access avoid karo");
        System.out.println("  - Baar baar get(i) mat call karo");
    }
}