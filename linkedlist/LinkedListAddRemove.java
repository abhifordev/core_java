package dev.abhi.linkedlist;
import java.util.LinkedList;
import java.util.Collections;

public class LinkedListAddRemove {
    public static void main(String[] args) {

        System.out.println("LinkedList - Add/Remove Operations\n");

        LinkedList<String> playlist = new LinkedList<>();

        // ADD OPERATIONS - Bahut tarike hain elements add karne ke

        System.out.println("--- Add Operations ---\n");

        // 1. Basic add() - last mein add hota hai
        playlist.add("Song 1");
        playlist.add("Song 2");
        playlist.add("Song 3");
        System.out.println("1. Basic add: " + playlist);

        // 2. Specific position par add karna
        playlist.add(1, "New Song");
        System.out.println("2. Index 1 par add: " + playlist);

        // 3. addFirst() - sabse pehle (ye special LinkedList method hai)
        playlist.addFirst("Opening Track");
        System.out.println("3. addFirst: " + playlist);

        // 4. addLast() - last mein (same as add())
        playlist.addLast("Closing Track");
        System.out.println("4. addLast: " + playlist);

        // 5. Multiple elements ek saath add karna
        LinkedList<String> moreSongs = new LinkedList<>();
        moreSongs.add("Bonus 1");
        moreSongs.add("Bonus 2");

        playlist.addAll(moreSongs);
        System.out.println("5. addAll: " + playlist);

        // 6. Specific index par multiple add
        LinkedList<String> intermission = new LinkedList<>();
        intermission.add("Break 1");
        intermission.add("Break 2");

        playlist.addAll(3, intermission);
        System.out.println("6. addAll at index 3: " + playlist);

        // 7. offer() - Queue method, last mein add karta hai
        // Ye true/false return karta hai
        boolean added = playlist.offer("Offer Song");
        System.out.println("7. offer: " + added + " | " + playlist);

        // 8. offerFirst() - first position mein
        playlist.offerFirst("First Offer");
        System.out.println("8. offerFirst: " + playlist);

        // 9. offerLast() - last position mein
        playlist.offerLast("Last Offer");
        System.out.println("9. offerLast: " + playlist);

        // 10. push() - Stack jaisa, first mein add karta hai
        playlist.push("Pushed Song");
        System.out.println("10. push (Stack style): " + playlist);

        System.out.println("\nTotal songs: " + playlist.size());

        // REMOVE OPERATIONS - Elements hatane ke different ways

        System.out.println("\n\n--- Remove Operations ---\n");

        LinkedList<Integer> numbers = new LinkedList<>();
        Collections.addAll(numbers, 10, 20, 30, 40, 50, 60, 70, 80, 90);
        System.out.println("Original: " + numbers);

        // 1. remove() without parameter - first element remove karta
        Integer removed1 = numbers.remove();
        System.out.println("\n1. remove() first: " + removed1 + " | Baaki: " + numbers);

        // 2. remove(index) - specific index se remove
        Integer removed2 = numbers.remove(2);
        System.out.println("2. remove(2): " + removed2 + " | Baaki: " + numbers);

        // 3. remove(Object) - value ke basis par
        boolean removed3 = numbers.remove(Integer.valueOf(50));
        System.out.println("3. remove value 50: " + removed3 + " | Baaki: " + numbers);

        // 4. removeFirst() - pehla element
        Integer removed4 = numbers.removeFirst();
        System.out.println("4. removeFirst: " + removed4 + " | Baaki: " + numbers);

        // 5. removeLast() - last element
        Integer removed5 = numbers.removeLast();
        System.out.println("5. removeLast: " + removed5 + " | Baaki: " + numbers);

        // 6. Duplicate values ke saath example
        numbers.add(60);
        numbers.add(60);
        System.out.println("\n6. Duplicates add kiye: " + numbers);

        // removeFirstOccurrence - pehli matching value
        boolean removed6 = numbers.removeFirstOccurrence(60);
        System.out.println("   removeFirstOccurrence(60): " + removed6 + " | Baaki: " + numbers);

        // removeLastOccurrence - aakhri matching value
        boolean removed7 = numbers.removeLastOccurrence(60);
        System.out.println("   removeLastOccurrence(60): " + removed7 + " | Baaki: " + numbers);

        // 7. poll() - first element remove (Queue method)
        // Agar list empty hai toh null return karega, exception nahi
        Integer polled = numbers.poll();
        System.out.println("\n7. poll: " + polled + " | Baaki: " + numbers);

        // 8. pollFirst() - same as poll
        Integer polled2 = numbers.pollFirst();
        System.out.println("8. pollFirst: " + polled2 + " | Baaki: " + numbers);

        // 9. pollLast() - last element remove
        Integer polled3 = numbers.pollLast();
        System.out.println("9. pollLast: " + polled3 + " | Baaki: " + numbers);

        // 10. pop() - Stack jaisa, first element remove
        Integer popped = numbers.pop();
        System.out.println("10. pop: " + popped + " | Baaki: " + numbers);

        // 11. removeIf() - condition ke basis par (Java 8+)
        numbers.add(5);
        numbers.add(15);
        numbers.add(25);
        System.out.println("\n11. Before removeIf: " + numbers);
        numbers.removeIf(num -> num < 50);  // 50 se kam remove
        System.out.println("    After removeIf (<50): " + numbers);

        // 12. clear() - saare elements remove
        LinkedList<String> temp = new LinkedList<>();
        temp.add("A");
        temp.add("B");
        temp.add("C");
        System.out.println("\n12. Before clear: " + temp);
        temp.clear();
        System.out.println("    After clear: " + temp + " (empty? " + temp.isEmpty() + ")");

        // Important differences yaad rakho:
        System.out.println("\n--- Important Differences ---");
        System.out.println("add() vs offer() vs push():");
        System.out.println("  add/addFirst/addLast - exception throw karte if problem");
        System.out.println("  offer/offerFirst/offerLast - false return karte, safer");
        System.out.println("  push - Stack behavior, addFirst jaisa");

        System.out.println("\nremove() vs poll() vs pop():");
        System.out.println("  remove/removeFirst/removeLast - exception throw karte if empty");
        System.out.println("  poll/pollFirst/pollLast - null return karte, safer");
        System.out.println("  pop - Stack behavior, removeFirst jaisa");
    }
}