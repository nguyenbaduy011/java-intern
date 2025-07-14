// Full demo: Creating threads and synchronizing access to shared resource
public class ThreadDemo {
    public static void main(String[] args) {
        // Shared counter
        Counter counter = new Counter();

        // Create thread using Runnable (Lambda)
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.increment("T1");
            }
        });

        // Create thread using custom Thread subclass
        Thread t2 = new MyThread(counter);

        t1.start();
        t2.start();

        try {
            t1.join(); // Wait for both to finish
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Count: " + counter.getCount());
    }
}

// Shared resource class with synchronized method
class Counter {
    private int count = 0;

    // synchronized to prevent race condition
    public synchronized void increment(String threadName) {
        count++;
        System.out.println(threadName + " incremented count to " + count);
        try {
            Thread.sleep(50); // simulate some work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int getCount() {
        return count;
    }
}

// Thread subclass
class MyThread extends Thread {
    private Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.increment("T2");
        }
    }
}
