package dev.abhi.arraylist;
import java.util.ArrayList;

public class AccessingElements {
    public static void main(String[] args) {

        ArrayList<String> movies = new ArrayList<>();
        movies.add("Sholay");
        movies.add("DDLJ");
        movies.add("3 Idiots");
        movies.add("Dangal");
        movies.add("PK");

        System.out.println("Saari movies: " + movies);

        // METHOD 1: get(index) - Kisi specific index ka element nikalna
        String firstMovie = movies.get(0);
        System.out.println("\nPehli movie: " + firstMovie);

        String lastMovie = movies.get(movies.size() - 1);  // Last element
        System.out.println("Aakhri movie: " + lastMovie);

        // METHOD 2: set(index, element) - Kisi index ki value change karna
        // Index 2 ki value change kar rahe hain
        String oldMovie = movies.set(2, "Bahubali");
        System.out.println("\nPurani movie jo replace hui: " + oldMovie);
        System.out.println("Update ke baad: " + movies);

        // METHOD 3: size() - Kitne elements hain ye check karna
        int totalMovies = movies.size();
        System.out.println("\nTotal movies: " + totalMovies);

        // METHOD 4: isEmpty() - Kya list khaali hai ye check karna
        boolean khaaliHai = movies.isEmpty();
        System.out.println("Kya list khaali hai? " + khaaliHai);

        /*
         * COMMON MISTAKES:
         * 1. movies.get(movies.size()) - Ye error dega! Kyunki last index size-1 hota hai
         * 2. Negative index use karna - Ye bhi error dega
         * 3. get() ke baad element automatically remove nahi hota
         */

        // SAFE WAY: Index check karke access karna
        int index = 10;
        if(index >= 0 && index < movies.size()) {
            System.out.println(movies.get(index));
        } else {
            System.out.println("\nIndex " + index + " valid nahi hai!");
        }
    }
}