package dev.abhi.arraylist;
import java.util.ArrayList;
import java.util.Collections;

public class AdvancedArrayListOperations {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 10, 20, 30, 40, 50, 60, 70, 80);

        System.out.println("Original list: " + numbers + "\n");

        // OPERATION 1: subList() - List ka ek part nikalna
        // subList(startIndex, endIndex) - endIndex included nahi hota
        ArrayList<Integer> subPart = new ArrayList<>(numbers.subList(2, 5));
        System.out.println("=== SubList (index 2 to 4) ===");
        System.out.println("SubList: " + subPart);

        // OPERATION 2: clone() - List ki copy banana
        @SuppressWarnings("unchecked")
        ArrayList<Integer> clonedList = (ArrayList<Integer>) numbers.clone();
        System.out.println("\n=== Clone Operation ===");
        System.out.println("Cloned list: " + clonedList);

        // Original list change karne par clone affected nahi hoga
        numbers.set(0, 999);
        System.out.println("Original changed: " + numbers);
        System.out.println("Clone (unchanged): " + clonedList);

        // OPERATION 3: toArray() - ArrayList ko array mein convert karna
        System.out.println("\n=== Convert to Array ===");
        Integer[] numbersArray = clonedList.toArray(new Integer[0]);
        System.out.print("Array: ");
        for(int num : numbersArray) {
            System.out.print(num + " ");
        }

        // OPERATION 4: retainAll() - Common elements rakhna
        System.out.println("\n\n=== RetainAll Operation ===");
        ArrayList<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, 10, 20, 30, 40, 50);

        ArrayList<Integer> list2 = new ArrayList<>();
        Collections.addAll(list2, 30, 40, 50, 60, 70);

        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);

        list1.retainAll(list2);  // List1 mein sirf common elements rahenge
        System.out.println("Common elements (retainAll): " + list1);

        // OPERATION 5: ensureCapacity() - Performance optimization
        System.out.println("\n=== Capacity Management ===");
        ArrayList<String> bigList = new ArrayList<>();
        bigList.ensureCapacity(1000);  // Pehle se capacity set kar rahe hain
        System.out.println("Capacity ensure kar di for better performance");

        // OPERATION 6: trimToSize() - Extra memory free karna
        ArrayList<Integer> wasteful = new ArrayList<>(100);
        wasteful.add(1);
        wasteful.add(2);
        wasteful.add(3);
        System.out.println("\nBefore trimToSize: capacity = 100, size = 3");
        wasteful.trimToSize();
        System.out.println("After trimToSize: extra memory freed");

        // OPERATION 7: replaceAll() - Saare elements ko modify karna (Java 8+)
        System.out.println("\n=== ReplaceAll Operation ===");
        ArrayList<Integer> values = new ArrayList<>();
        Collections.addAll(values, 1, 2, 3, 4, 5);
        System.out.println("Original: " + values);

        values.replaceAll(n -> n * 2);  // Har element ko double kar do
        System.out.println("After doubling: " + values);

        // OPERATION 8: Collections utility methods
        System.out.println("\n=== Collections Utility Methods ===");
        ArrayList<Integer> nums = new ArrayList<>();
        Collections.addAll(nums, 5, 2, 8, 1, 9, 3);

        System.out.println("Original: " + nums);

        Collections.shuffle(nums);  // Random order mein kar do
        System.out.println("Shuffled: " + nums);

        Collections.reverse(nums);  // Reverse kar do
        System.out.println("Reversed: " + nums);

        Collections.rotate(nums, 2);  // 2 positions right rotate
        System.out.println("Rotated by 2: " + nums);

        int max = Collections.max(nums);
        int min = Collections.min(nums);
        System.out.println("Max: " + max + ", Min: " + min);

        int freq = Collections.frequency(nums, 5);
        System.out.println("Frequency of 5: " + freq);

        /*
         * PERFORMANCE TIPS:
         * - ensureCapacity() use karo agar bahut saare elements add karne hain
         * - trimToSize() use karo memory save karne ke liye
         * - subList() view return karta hai, modify karne se original list change hogi
         * - clone() shallow copy banata hai
         */
    }
}