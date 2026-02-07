package dev.abhi.arraylist;
import java.util.ArrayList;
import java.util.Comparator;

public class ArrayListWithObjects {
    public static void main(String[] args) {

        // Real-world example: Book management system
        ArrayList<Book> library = new ArrayList<>();

        // Books add kar rahe hain
        library.add(new Book("Harry Potter", "J.K. Rowling", 350, 499));
        library.add(new Book("Wings of Fire", "APJ Abdul Kalam", 280, 299));
        library.add(new Book("The Alchemist", "Paulo Coelho", 200, 199));
        library.add(new Book("Rich Dad Poor Dad", "Robert Kiyosaki", 336, 399));
        library.add(new Book("Atomic Habits", "James Clear", 320, 499));

        System.out.println("=== Library ki saari books ===\n");
        displayBooks(library);

        // OPERATION 1: Specific book search karna
        System.out.println("\n=== 'Harry Potter' search kar rahe hain ===");
        Book found = findBookByTitle(library, "Harry Potter");
        if(found != null) {
            System.out.println("Book mil gayi: " + found);
        }

        // OPERATION 2: Price range ke basis par books nikalna
        System.out.println("\n=== 300 se kam price wali books ===");
        ArrayList<Book> affordableBooks = getBooksByPriceRange(library, 0, 300);
        displayBooks(affordableBooks);

        // OPERATION 3: Author ke saari books nikalna
        System.out.println("\n=== APJ Abdul Kalam ki books ===");
        ArrayList<Book> kalamBooks = getBooksByAuthor(library, "APJ Abdul Kalam");
        displayBooks(kalamBooks);

        // OPERATION 4: Price ke basis par sort karna
        System.out.println("\n=== Price ke basis par sorted ===");
        library.sort(Comparator.comparingInt(book -> book.price));
        displayBooks(library);

        // OPERATION 5: Book remove karna
        System.out.println("\n=== 'The Alchemist' remove kar rahe hain ===");
        library.removeIf(book -> book.title.equals("The Alchemist"));
        displayBooks(library);

        // OPERATION 6: Total library value calculate karna
        int totalValue = calculateTotalValue(library);
        System.out.println("\nLibrary ki total value: ₹" + totalValue);

        // OPERATION 7: Sabse mehngi book find karna
        Book expensive = library.stream()
                .max(Comparator.comparingInt(b -> b.price))
                .orElse(null);
        System.out.println("Sabse mehngi book: " + expensive);

        /*
         * REAL-WORLD USE CASES:
         * - E-commerce: Product management
         * - School: Student records
         * - Hospital: Patient records
         * - Company: Employee management
         * - Restaurant: Menu items
         */
    }

    // Helper method: Books display karne ke liye
    static void displayBooks(ArrayList<Book> books) {
        if(books.isEmpty()) {
            System.out.println("  Koi book nahi hai!");
            return;
        }
        for(Book book : books) {
            System.out.println("  " + book);
        }
    }

    // Helper method: Title se book find karna
    static Book findBookByTitle(ArrayList<Book> books, String title) {
        for(Book book : books) {
            if(book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Helper method: Price range ke books nikalna
    static ArrayList<Book> getBooksByPriceRange(ArrayList<Book> books, int min, int max) {
        ArrayList<Book> result = new ArrayList<>();
        for(Book book : books) {
            if(book.price >= min && book.price <= max) {
                result.add(book);
            }
        }
        return result;
    }

    // Helper method: Author ki saari books
    static ArrayList<Book> getBooksByAuthor(ArrayList<Book> books, String author) {
        ArrayList<Book> result = new ArrayList<>();
        for(Book book : books) {
            if(book.author.equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // Helper method: Total value calculate karna
    static int calculateTotalValue(ArrayList<Book> books) {
        int total = 0;
        for(Book book : books) {
            total += book.price;
        }
        return total;
    }
}

// Book class - Custom object
class Book {
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

    // toString() - Object ko print karne ke liye
    @Override
    public String toString() {
        return String.format("'%s' by %s (%d pages) - ₹%d",
                title, author, pages, price);
    }
}