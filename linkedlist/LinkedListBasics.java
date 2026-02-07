package dev.abhi.linkedlist;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

public class LinkedListBasics {
    public static void main(String[] args) {

        System.out.println("LINKED LIST KYA HAI?\n");

        // LinkedList aur ArrayList mein kya difference hai?
        // ArrayList: Saare elements ek continuous memory block mein hote hain
        //            [10][20][30][40][50] - sab ek saath
        // LinkedList: Har element ek Node hai, jo next element ka address store karta hai
        //             [10]-->[20]-->[30]-->[40]-->[50]
        //
        // Fayda: Beech mein add/remove karna bahut fast hai
        // Nuksaan: Index se element nikalna slow hai

        // Tarika 1: Khaali LinkedList banana
        LinkedList<String> fruits = new LinkedList<>();
        System.out.println("Khaali LinkedList: " + fruits);
        System.out.println("Kya khaali hai? " + fruits.isEmpty());

        // Tarika 2: Elements ke saath banao
        LinkedList<Integer> numbers = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("\nElements ke saath: " + numbers);
        System.out.println("Size: " + numbers.size());

        // Tarika 3: Existing list se copy karna
        ArrayList<String> cityList = new ArrayList<>(Arrays.asList("Delhi", "Mumbai", "Bangalore"));
        LinkedList<String> cities = new LinkedList<>(cityList);
        System.out.println("\nArrayList se copy: " + cities);

        System.out.println("\n--- ArrayList vs LinkedList Performance ---\n");

        // Ab dekhte hain kaunsa operation kahan fast hai
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println("1. END MEIN ADD KARNA:");
        System.out.println("   ArrayList: Fast - O(1)");
        System.out.println("   LinkedList: Fast - O(1)");
        System.out.println("   Winner: Dono barabar");

        System.out.println("\n2. BEECH MEIN ADD KARNA:");
        System.out.println("   ArrayList: Slow - sabko shift karna padta - O(n)");
        System.out.println("   LinkedList: Fast - sirf links change karne hain - O(1)");
        System.out.println("   Winner: LinkedList");

        // Example dikhate hain
        for(int i = 0; i < 5; i++) {
            linkedList.add(i * 10);
        }
        System.out.println("\n   Pehle: " + linkedList);
        linkedList.add(2, 999);  // Index 2 par add - bahut fast!
        System.out.println("   999 add karne ke baad: " + linkedList);

        System.out.println("\n3. INDEX SE ELEMENT NIKALNA:");
        System.out.println("   ArrayList: Fast - direct access - O(1)");
        System.out.println("   LinkedList: Slow - har node ko traverse karna padta - O(n)");
        System.out.println("   Winner: ArrayList");

        System.out.println("\n4. BEECH SE REMOVE KARNA:");
        System.out.println("   ArrayList: Slow - sabko shift - O(n)");
        System.out.println("   LinkedList: Fast - sirf links change - O(1)");
        System.out.println("   Winner: LinkedList");

        System.out.println("\n5. MEMORY USAGE:");
        System.out.println("   ArrayList: Kam - sirf data");
        System.out.println("   LinkedList: Zyada - har node mein pointers bhi");
        System.out.println("   Winner: ArrayList");

        // Ab LinkedList ke special features dekhte hain
        System.out.println("\n--- LinkedList Special Features ---\n");

        LinkedList<String> names = new LinkedList<>();

        // Ye methods sirf LinkedList mein hain, ArrayList mein nahi
        names.addFirst("Amit");   // Sabse pehle add karo
        names.addLast("Rahul");   // Last mein add karo
        names.add("Priya");       // By default last mein hi add hota hai

        System.out.println("Names: " + names);

        String first = names.getFirst();  // Pehla element
        String last = names.getLast();    // Last element

        System.out.println("Pehla: " + first);
        System.out.println("Last: " + last);

        names.removeFirst();  // Pehla hatao
        names.removeLast();   // Last hatao

        System.out.println("Remove karne ke baad: " + names);

        // Important points yaad rakho:
        // - LinkedList teen interfaces implement karta hai: List, Queue, Deque
        // - Ye doubly linked list hai (har node previous aur next dono track karta)
        // - Random access slow hai, sequential access fast hai
        // - Thread-safe nahi hai

        System.out.println("\nKya ye Queue hai? " + (linkedList instanceof java.util.Queue));
        System.out.println("Kya ye Deque hai? " + (linkedList instanceof java.util.Deque));

        // Conclusion: Kab kya use karein?
        System.out.println("\n--- Kab kya use karein? ---\n");
        System.out.println("ArrayList use karo jab:");
        System.out.println("  - Mostly reading/accessing karni ho");
        System.out.println("  - Memory save karni ho");
        System.out.println("  - Random access chahiye");

        System.out.println("\nLinkedList use karo jab:");
        System.out.println("  - Bahut zyada beech mein add/remove ho");
        System.out.println("  - Queue/Deque behavior chahiye");
        System.out.println("  - First/Last operations zyada ho");
    }
}