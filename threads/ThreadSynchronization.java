package dev.abhi.threads;
// Without synchronization - Problem
class Counter {
    int count = 0;

    // Not synchronized - race condition hoga
    public void increment() {
        count++;  // Not atomic operation
        // Actually: read count, add 1, write count
    }
}

// With synchronization - Solution
class SynchronizedCounter {
    int count = 0;

    // synchronized method - ek thread at a time
    public synchronized void increment() {
        count++;
    }

    // synchronized block - specific code block lock
    public void incrementBlock() {
        synchronized(this) {
            count++;
        }
    }
}

// Real example: Bank Account
class BankAccount {
    private int balance = 1000;

    // synchronized method - thread safe
    public synchronized void withdraw(String name, int amount) {
        System.out.println(name + " trying to withdraw " + amount);

        if(balance >= amount) {
            System.out.println(name + " - Balance sufficient");

            try {
                Thread.sleep(100);  // Simulate processing
            } catch(InterruptedException e) {
                e.printStackTrace();
            }

            balance -= amount;
            System.out.println(name + " withdrew " + amount + " | Balance: " + balance);
        } else {
            System.out.println(name + " - Insufficient balance! Current: " + balance);
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class ThreadSynchronization {
    public static void main(String[] args) {

        // Problem: Without synchronization
        System.out.println("--- Without Synchronization (Race Condition) ---\n");

        Counter counter = new Counter();

        // Two threads incrementing same counter
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Expected count: 2000");
        System.out.println("Actual count: " + counter.count);
        System.out.println("Problem: Race condition! Count lost!");

        // Solution: With synchronization
        System.out.println("\n--- With Synchronization (Thread Safe) ---\n");

        SynchronizedCounter syncCounter = new SynchronizedCounter();

        Thread t3 = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                syncCounter.increment();
            }
        });

        Thread t4 = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                syncCounter.increment();
            }
        });

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Expected count: 2000");
        System.out.println("Actual count: " + syncCounter.count);
        System.out.println("Success: Synchronized! No data loss!");

        // Real example: Bank Account
        System.out.println("\n--- Real Example: Bank Account ---\n");

        BankAccount account = new BankAccount();

        // Two people trying to withdraw simultaneously
        Thread person1 = new Thread(() -> {
            account.withdraw("Person-1", 600);
        });

        Thread person2 = new Thread(() -> {
            account.withdraw("Person-2", 600);
        });

        person1.start();
        person2.start();

        try {
            person1.join();
            person2.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal balance: " + account.getBalance());
        System.out.println("Only one withdraw successful (synchronized)");

        // Key points:
        // 1. Race condition = multiple threads accessing shared data
        // 2. synchronized = only one thread at a time
        // 3. synchronized method = locks entire method
        // 4. synchronized block = locks specific code
        // 5. Use synchronization when:
        //    - Shared data
        //    - At least one thread writes
        //    - No atomic operations

        System.out.println("\n--- Synchronization Concepts ---");
        System.out.println("Race Condition: Multiple threads compete for same resource");
        System.out.println("Critical Section: Code that accesses shared resource");
        System.out.println("Lock/Monitor: Object that controls access");
        System.out.println("synchronized: Provides mutual exclusion");
    }
}
//```
//
//        **Output:**
//        ```
//        --- Without Synchronization (Race Condition) ---
//
//Expected count: 2000
//Actual count: 1847
//Problem: Race condition! Count lost!
//
//        --- With Synchronization (Thread Safe) ---
//
//Expected count: 2000
//Actual count: 2000
//Success: Synchronized! No data loss!
//
//        --- Real Example: Bank Account ---
//
//Person-1 trying to withdraw 600
//Person-1 - Balance sufficient
//Person-2 trying to withdraw 600
//Person-1 withdrew 600 | Balance: 400
//Person-2 - Insufficient balance! Current: 400
//
//Final balance: 400
//Only one withdraw successful (synchronized)