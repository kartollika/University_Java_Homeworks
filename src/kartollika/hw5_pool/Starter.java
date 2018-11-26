package kartollika.hw5_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Starter {

    public static void main(String[] args) throws InterruptedException {
        ResourcePool<Integer> pool = new ResourcePool<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});

        ExecutorService es = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 15; ++i) {
            Worker worker = new Worker<>(pool);
            es.execute(worker);
        }

        if (!es.awaitTermination(5, TimeUnit.SECONDS)) {
            es.shutdownNow();
        }
    }
}
