import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListBasics {
    public static void main(String[] args) {

        // PEHLA TARIKA: Khaali ArrayList banana (Empty ArrayList)
        ArrayList<String> fruits = new ArrayList<>();
        System.out.println("Khaali ArrayList: " + fruits);

        // DUSRA TARIKA: Starting capacity ke saath banana
        // Isse performance thodi better hoti hai agar aapko pata hai kitne elements honge
        ArrayList<Integer> numbers = new ArrayList<>(50);
        System.out.println("Capacity 50 wali ArrayList: " + numbers);

        // TISRA TARIKA: Existing collection se initialize karna
        ArrayList<String> cities = new ArrayList<>(Arrays.asList("Delhi", "Mumbai", "Bangalore"));
        System.out.println("Pre-filled ArrayList: " + cities);

        // CHAUTHA TARIKA: List.of() se initialize karna (Java 9+)
        // Dhyan rahe: Ye immutable list return karta hai, toh ArrayList mein convert karna padega
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Green", "Blue"));
        System.out.println("Colors ArrayList: " + colors);

        /*
         * IMPORTANT BAATEIN:
         * 1. ArrayList dynamic hai - size automatically badhta hai
         * 2. Generic type <String>, <Integer> use karo type safety ke liye
         * 3. Primitive types (int, double) directly nahi use kar sakte, wrapper class use karo
         */

        // GALAT: ArrayList<int> wrong = new ArrayList<>();  // Ye error dega!
        // SAHI: ArrayList<Integer> correct = new ArrayList<>();  // Ye sahi hai!
    }
}