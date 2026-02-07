package dev.abhi.threads;
// Producer-Consumer problem
class SharedResource {
    private int data;
    private boolean hasData = false;

    // Producer calls this
    public synchronized void produce(int value) {
        // Wait if data already present
        while(hasData) {
            try {
                System.out.println("Producer waiting... (buffer full)");
                wait();  // Release lock and wait
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Produce data
        this.data = value;
        hasData = true;
        System.out.println("Produced: " + data);

        notify();  // Wake up consumer
    }

    // Consumer calls this
    public synchronized int consume() {
        // Wait if no data available
        while(!hasData) {
            try {
                System.out.println("Consumer waiting... (buffer empty)");
                wait();  // Release lock and wait
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Consume data
        hasData = false;
        System.out.println("Consumed: " + data);

        notify();  // Wake up producer
        return data;
    }
}

// Simple example: Message passing
class Message {
    private String message;
    private boolean available = false;

    public synchronized void send(String msg) {
        while(available) {
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.message = msg;
        available = true;
        System.out.println("Sent: " + msg);
        notify();
    }

    public synchronized String receive() {
        while(!available) {
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        available = false;
        System.out.println("Received: " + message);
        notify();
        return message;
    }
}

public class InterThreadCommunication {
    public static void main(String[] args) {

        System.out.println("--- Producer-Consumer Problem ---\n");

        SharedResource resource = new SharedResource();

        // Producer thread
        Thread producer = new Thread(() -> {
            for(int i = 1; i <= 5; i++) {
                resource.produce(i * 10);
                try {
                    Thread.sleep(500);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            for(int i = 1; i <= 5; i++) {
                int value = resource.consume();
                try {
                    Thread.sleep(1000);  // Consumer slower
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        // Message passing example
        System.out.println("\n--- Message Passing Example ---\n");

        Message msg = new Message();

        // Sender thread
        Thread sender = new Thread(() -> {
            String[] messages = {"Hello", "How are you?", "Goodbye"};
            for(String m : messages) {
                msg.send(m);
                try {
                    Thread.sleep(500);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Receiver thread
        Thread receiver = new Thread(() -> {
            for(int i = 0; i < 3; i++) {
                String received = msg.receive();
                try {
                    Thread.sleep(700);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        sender.start();
        receiver.start();

        try {
            sender.join();
            receiver.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        // wait(), notify(), notifyAll() explanation
        System.out.println("\n--- Inter-Thread Communication Methods ---");
        System.out.println("\nwait():");
        System.out.println("  - Current thread wait karta hai");
        System.out.println("  - Lock release karta hai");
        System.out.println("  - synchronized block mein hi call kar sakte");

        System.out.println("\nnotify():");
        System.out.println("  - Ek waiting thread ko wake up karta");
        System.out.println("  - Kaunsa thread wake hoga - not guaranteed");
        System.out.println("  - synchronized block mein hi call kar sakte");

        System.out.println("\nnotifyAll():");
        System.out.println("  - Saare waiting threads ko wake up karta");
        System.out.println("  - Best practice when multiple threads wait");
        System.out.println("  - synchronized block mein hi call kar sakte");

        System.out.println("\n--- Key Points ---");
        System.out.println("1. wait/notify must be in synchronized block");
        System.out.println("2. wait() releases lock, sleep() doesn't");
        System.out.println("3. Producer-Consumer pattern uses wait/notify");
        System.out.println("4. Prevents busy waiting (CPU waste)");
        System.out.println("5. Coordination between threads");

        System.out.println("\n--- Thread States ---");
        System.out.println("NEW -> RUNNABLE -> RUNNING");
        System.out.println("            ↓");
        System.out.println("      WAITING (wait/join)");
        System.out.println("            ↓");
        System.out.println("       TERMINATED");
    }
}
//```
//
//        **Output:**
//        ```
//        --- Producer-Consumer Problem ---
//
//Produced: 10
//Consumed: 10
//Produced: 20
//Consumed: 20
//Produced: 30
//Consumed: 30
//Produced: 40
//Consumed: 40
//Produced: 50
//Consumed: 50
//
//        --- Message Passing Example ---
//
//Sent: Hello
//Received: Hello
//Sent: How are you?
//Received: How are you?
//Sent: Goodbye
//Received: Goodbye
//
//--- Inter-Thread Communication Methods ---
//
//wait():
//        - Current thread wait karta hai
//  - Lock release karta hai
//  - synchronized block mein hi call kar sakte
//
//notify():
//        - Ek waiting thread ko wake up karta
//  - Kaunsa thread wake hoga - not guaranteed
//  - synchronized block mein hi call kar sakte
//
//notifyAll():
//        - Saare waiting threads ko wake up karta
//  - Best practice when multiple threads wait
//  - synchronized block mein hi call kar sakte
//```
//
//        ---
//
//        **Quick Summary:**
//        ```
//Thread Concepts:
//
//        1. THREAD CREATION:
//        - extends Thread
//   - implements Runnable (better)
//   - Lambda expression (shortest)
//   - start() to begin, NOT run()
//
//        2. THREAD METHODS:
//        - sleep(ms) - pause
//   - join() - wait for completion
//   - setPriority() - hint to scheduler
//   - interrupt() - signal to stop
//   - isAlive() - check status
//
//3. SYNCHRONIZATION:
//        - Race condition - multiple threads, shared data
//   - synchronized method - lock entire method
//   - synchronized block - lock specific code
//   - Prevents data corruption
//   - One thread at a time
//
//4. INTER-THREAD COMMUNICATION:
//        - wait() - release lock and wait
//   - notify() - wake one thread
//   - notifyAll() - wake all threads
//   - Must be in synchronized block
//   - Producer-Consumer pattern
//
//Thread States:
//NEW → RUNNABLE → RUNNING → WAITING/BLOCKED → TERMINATED
//
//Remember:
//        - Use Runnable over Thread
//- Synchronize shared data
//- wait() releases lock, sleep() doesn't
//        - Always join() if need to wait for completion