package dev.abhi.threads;
class Worker extends Thread {
    String taskName;

    Worker(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(taskName + " started by " + Thread.currentThread().getName());

        for(int i = 1; i <= 3; i++) {
            System.out.println(taskName + " - Step " + i);
            try {
                Thread.sleep(1000);  // 1 second pause
            } catch(InterruptedException e) {
                System.out.println(taskName + " interrupted!");
            }
        }

        System.out.println(taskName + " completed!");
    }
}

public class ThreadLifecycle {
    public static void main(String[] args) {

        System.out.println("Main thread: " + Thread.currentThread().getName());

        // Thread creation
        Worker w1 = new Worker("Task-A");
        Worker w2 = new Worker("Task-B");
        Worker w3 = new Worker("Task-C");

        // Thread states:
        // NEW -> RUNNABLE -> RUNNING -> WAITING/BLOCKED -> TERMINATED

        System.out.println("\n--- Thread Priority ---");
        // Priority: 1 (MIN) to 10 (MAX), default = 5 (NORM)
        w1.setPriority(Thread.MIN_PRIORITY);   // 1
        w2.setPriority(Thread.NORM_PRIORITY);  // 5
        w3.setPriority(Thread.MAX_PRIORITY);   // 10

        System.out.println("W1 Priority: " + w1.getPriority());
        System.out.println("W2 Priority: " + w2.getPriority());
        System.out.println("W3 Priority: " + w3.getPriority());

        // Start threads
        System.out.println("\n--- Starting Threads ---");
        w1.start();
        w2.start();
        w3.start();

        // isAlive() - check if thread running
        System.out.println("\nW1 alive? " + w1.isAlive());

        // join() - wait for thread to complete
        System.out.println("\n--- Using join() ---");
        try {
            System.out.println("Main waiting for Task-A to finish...");
            w1.join();  // Main thread waits for w1 to complete
            System.out.println("Task-A finished, main continues");

            System.out.println("Main waiting for all tasks...");
            w2.join();
            w3.join();
            System.out.println("All tasks completed!");

        } catch(InterruptedException e) {
            System.out.println("Main interrupted!");
        }

        System.out.println("\nW1 alive now? " + w1.isAlive());

        // Thread methods demo
        System.out.println("\n--- Thread Methods ---");

        Thread demoThread = new Thread(() -> {
            System.out.println("Demo thread running");
            System.out.println("Thread name: " + Thread.currentThread().getName());
            System.out.println("Thread ID: " + Thread.currentThread().getId());
            System.out.println("Is daemon? " + Thread.currentThread().isDaemon());
        });

        demoThread.setName("MyDemoThread");
        demoThread.start();

        try {
            demoThread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        // Key methods:
        // start() - thread start karo
        // run() - thread ka code
        // sleep(ms) - pause for milliseconds
        // join() - wait for thread to finish
        // setPriority()/getPriority() - priority manage
        // isAlive() - check if running
        // currentThread() - current thread reference
        // getName()/setName() - thread name
        // interrupt() - thread ko interrupt signal

        System.out.println("\nMain thread finished!");
    }
}