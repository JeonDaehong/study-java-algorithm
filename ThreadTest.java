import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadTest {
    private static final int MAX_ITEMS = 500;
    private static final Queue<Integer> sharedQueue = new LinkedList<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            for (int i = 1; i <= MAX_ITEMS; i++) {
                sharedQueue.add(i);
                System.out.println("Pushed: " + i);
                // Simulate some work being done
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.submit(() -> {
            for (int i = 0; i < MAX_ITEMS; i++) {
                if (!sharedQueue.isEmpty()) {
                    int item = sharedQueue.poll();
                    System.out.println("Popped: " + item);
                    // Simulate some work being done
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        executorService.shutdown();
    }
}
