package dev.abhi.threads;
// Method 1: Extends Thread class
class MyThread extends Thread {
    String name;

    MyThread(String name) {
        this.name = name;
    }

    // run() method - thread ka kaam
    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println(name + " - Count: " + i);
            try {
                Thread.sleep(500);  // 500ms pause
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(name + " finished!");
    }
}

// Method 2: Implements Runnable interface
class MyRunnable implements Runnable {
    String name;

    MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println(name + " - Count: " + i);
            try {
                Thread.sleep(500);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(name + " finished!");
    }
}

public class ThreadBasics {
    public static void main(String[] args) {

        System.out.println("Main thread started\n");

        // Method 1: Using Thread class
        System.out.println("--- Creating threads by extending Thread ---");
        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");

        t1.start();  // start() method thread ko execute karta
        t2.start();  // NOT run() - run() direct call synchronous hoga

        // Method 2: Using Runnable interface (RECOMMENDED)
        System.out.println("\n--- Creating threads using Runnable ---");
        MyRunnable r1 = new MyRunnable("Runnable-1");
        MyRunnable r2 = new MyRunnable("Runnable-2");

        Thread t3 = new Thread(r1);
        Thread t4 = new Thread(r2);

        t3.start();
        t4.start();

        // Method 3: Using Lambda (Java 8+) - Shortest way
        System.out.println("\n--- Using Lambda ---");
        Thread t5 = new Thread(() -> {
            for(int i = 1; i <= 3; i++) {
                System.out.println("Lambda Thread - " + i);
                try {
                    Thread.sleep(500);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t5.start();

        // Main thread continues
        System.out.println("\nMain thread doing other work...");

        // Key points:
        // 1. Thread = independent execution path
        // 2. start() creates new thread and calls run()
        // 3. run() direct call = no new thread, normal method call
        // 4. Multiple threads run parallelly (concurrently)
        // 5. Runnable better than Thread (multiple inheritance issue)

        System.out.println("Main thread finished!");
    }
}