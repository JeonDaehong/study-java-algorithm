import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ThreadTest {
    private static final Logger log = Logger.getGlobal();
    private static final int MAX_ITEMS = 200;
    private static final Queue<Integer> sharedQueue = new LinkedList<>();
    private static final Object lock = new Object();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            for (int i = 1; i <= MAX_ITEMS; i++) {
                synchronized (lock) {
                    sharedQueue.add(i);
                    //log.info("Pushed: " + i);
                    // Simulate some work being done
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.submit(() -> {
            for (int i = 0; i < MAX_ITEMS; i++) {
                synchronized (lock) {
                    if (!sharedQueue.isEmpty()) {
                        int item = sharedQueue.poll();
                        log.info("Popped: " + item);
                        // Simulate some work being done
                    }
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.shutdown();
    }
}
