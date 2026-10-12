
import java.util.concurrent.atomic.AtomicLong;

public class Ashik_Thread extends Thread {

    static AtomicLong safeCounter = new AtomicLong(0);
    static long unsafeCounter = 0;

    int increments;
    boolean threadSafe;
    long localCounter = 0;

    public Ashik_Thread(int increments, boolean threadSafe) {
        this.increments = increments;
        this.threadSafe = threadSafe;
    }

    @Override
    public void run() {
        for (int i = 0; i < increments; i++) {
            if (threadSafe) {
                safeCounter.incrementAndGet();
            } else {
                unsafeCounter++;
            }

            localCounter++;
        }
    }

    public static void main(String[] args)
            throws InterruptedException {

        if (args.length != 3) {
            System.out.println(
                "Usage: java Ashik_Thread <threads> <increments> <true/false>"
            );
            return;
        }

        int numberOfThreads;
        int increments;
        boolean threadSafe;

        try {
            numberOfThreads = Integer.parseInt(args[0]);
            increments = Integer.parseInt(args[1]);

            if (!args[2].equalsIgnoreCase("true")
                    && !args[2].equalsIgnoreCase("false")) {
                System.out.println("Invalid input!");
                return;
            }

            threadSafe = Boolean.parseBoolean(args[2]);

        } catch (NumberFormatException e) {
            System.out.println("Threads and increments must be integers!");
            return;
        }

        if (numberOfThreads <= 0 || increments < 0) {
            System.out.println("Invalid input!");
            return;
        }

        safeCounter.set(0);
        unsafeCounter = 0;

        Ashik_Thread[] threads =
                new Ashik_Thread[numberOfThreads];

        long startTime = System.nanoTime();

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Ashik_Thread(increments, threadSafe);
            threads[i].start();
        }

        long nonStaticTotal = 0;

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i].join();
            nonStaticTotal += threads[i].localCounter;
        }

        long endTime = System.nanoTime();

        long expectedCount =
                (long) numberOfThreads * increments;

        long staticCount;

        if (threadSafe) {
            staticCount = safeCounter.get();
        } else {
            staticCount = unsafeCounter;
        }

        long difference = Math.abs(staticCount - nonStaticTotal);

        double percentageDifference = 0.0;

        if (nonStaticTotal != 0) {
            percentageDifference =
                    (difference * 100.0) / nonStaticTotal;
        }

        System.out.println("\n===== THREAD COUNTER RESULT =====");
        System.out.println("Number of Threads: " + numberOfThreads);
        System.out.println("Increments per Thread: " + increments);
        System.out.println("Thread-Safe Mode: " + threadSafe);
        System.out.println("Expected Count: " + expectedCount);
        System.out.println("Static Count: " + staticCount);
        System.out.println("Non-Static Total: " + nonStaticTotal);
        System.out.println("Absolute Difference: " + difference);

        System.out.printf(
                "Percentage Difference: %.4f%%%n",
                percentageDifference
        );

        System.out.printf(
                "Execution Time: %.3f ms%n",
                (endTime - startTime) / 1_000_000.0
        );
    }
}
