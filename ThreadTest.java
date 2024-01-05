import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ThreadTest {
    private static final Logger log = Logger.getGlobal();
    private static final int MAX_ITEMS = 200;
    private static final Queue<Integer> sharedQueue = new LinkedList<>();
    private static final ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        CompletableFuture<Void> producerFuture = CompletableFuture.runAsync(() -> {
            //sharedQueue.add(1);
            for (int i = 1; i <= MAX_ITEMS; i++) {
                synchronized (sharedQueue) {
                    sharedQueue.add(i);
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, executorService);

        CompletableFuture<Void> consumerFuture = CompletableFuture.runAsync(() -> {
            while (!sharedQueue.isEmpty()) {
                synchronized (sharedQueue) {
                    if (!sharedQueue.isEmpty()) {
                        int item = sharedQueue.poll();
                        log.info("Popped: " + item);
                        // Simulate some work being done
                    } else {
                        log.info("Empty");
                    }
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, executorService);

        CompletableFuture<Void> allOf = CompletableFuture.allOf(producerFuture, consumerFuture);

        // Block until both tasks are completed
        allOf.join();

        executorService.shutdown();
    }
}
