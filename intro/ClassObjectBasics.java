package dev.abhi.intro;
// Class - blueprint/template
class Student {
    // Instance variables - har object ki apni copy
    String name;
    int rollNo;
    int marks;

    // Instance method - object par action
    void display() {
        System.out.println(name + " (Roll: " + rollNo + ") - Marks: " + marks);
    }

    void updateMarks(int newMarks) {
        marks = newMarks;
        System.out.println(name + "'s marks updated to " + marks);
    }

    boolean isPassed() {
        return marks >= 40;
    }

    String getGrade() {
        if(marks >= 90) return "A";
        if(marks >= 75) return "B";
        if(marks >= 60) return "C";
        if(marks >= 40) return "D";
        return "F";
    }
}

// Class with different data
class BankAccount {
    String accountNumber;
    String holderName;
    double balance;

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: ₹" + amount + " | Balance: ₹" + balance);
    }

    void withdraw(double amount) {
        if(amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount + " | Balance: ₹" + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void displayBalance() {
        System.out.println(holderName + " - Balance: ₹" + balance);
    }
}

public class ClassObjectBasics {
    public static void main(String[] args) {

        System.out.println("--- Creating Objects ---");

        // Object creation - new keyword
        Student s1 = new Student();

        // Setting values - direct access (not recommended, use methods)
        s1.name = "Rahul";
        s1.rollNo = 101;
        s1.marks = 85;

        // Calling methods
        s1.display();
        System.out.println("Passed? " + s1.isPassed());
        System.out.println("Grade: " + s1.getGrade());

        System.out.println();

        // Multiple objects - each has own copy of instance variables
        Student s2 = new Student();
        s2.name = "Priya";
        s2.rollNo = 102;
        s2.marks = 92;

        s2.display();

        // Objects are independent
        System.out.println("\n--- Objects are Independent ---");
        s1.updateMarks(95);
        System.out.println("S1 marks: " + s1.marks);
        System.out.println("S2 marks: " + s2.marks);  // Unchanged

        // Another class example
        System.out.println("\n--- Bank Account Example ---");

        BankAccount acc1 = new BankAccount();
        acc1.accountNumber = "ACC001";
        acc1.holderName = "Amit";
        acc1.balance = 5000;

        acc1.displayBalance();
        acc1.deposit(2000);
        acc1.withdraw(3000);
        acc1.withdraw(10000);  // Insufficient

        System.out.println();

        BankAccount acc2 = new BankAccount();
        acc2.accountNumber = "ACC002";
        acc2.holderName = "Neha";
        acc2.balance = 10000;

        acc2.displayBalance();

        // Key points:
        // 1. Class = blueprint, Object = instance
        // 2. new keyword se object create hota
        // 3. Har object ki apni memory
        // 4. Instance variables - object specific
        // 5. Instance methods - object par call karte
        // 6. Dot operator (.) se access
    }
}