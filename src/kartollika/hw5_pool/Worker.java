package kartollika.hw5_pool;

import java.util.List;
import java.util.Random;

public class Worker<T> extends Thread {

    private ResourcePool<T> resourcePool;

    Worker(ResourcePool<T> resourcePool) {
        this.resourcePool = resourcePool;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            int needed = new Random().nextInt(resourcePool.getSize()) + 1;
            List<T> requestedFromPool = resourcePool.get(needed);
            System.out.println(this.getName() + ": got from pool list of " + requestedFromPool.size() + " resources");

            for (int i = 0; i < requestedFromPool.size(); ++i) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            resourcePool.release(requestedFromPool);
            System.out.println(this.getName() + ": released list of " + requestedFromPool.size() + " resources");

            if (new Random().nextBoolean()) {
                return;
            }
        }
    }
}
