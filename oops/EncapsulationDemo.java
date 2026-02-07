package dev.abhi.oops;
// Encapsulation = Data ko private rakhna aur methods se access dena
// Data hiding + controlled access

class BankAccount {
    // Private data - bahar se direct access nahi ho sakta
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Public methods - controlled access (Getters/Setters)
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if(amount > 0) {  // Validation - ye encapsulation ka fayda hai
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {

        BankAccount account = new BankAccount("ACC123", 5000);

        // Direct access nahi kar sakte - GOOD!
        // account.balance = -1000;  // ERROR - private hai

        // Methods se hi access kar sakte - SAFE!
        System.out.println("Initial Balance: " + account.getBalance());

        account.deposit(2000);
        System.out.println("Balance: " + account.getBalance());

        account.withdraw(3000);
        System.out.println("Balance: " + account.getBalance());

        account.withdraw(10000);  // Insufficient - validation kaam karega

        // Encapsulation benefits:
        // 1. Data safe hai - validation apply kar sakte
        // 2. Internal implementation change kar sakte, bahar kuch affect nahi
        // 3. Better control over data
    }
}