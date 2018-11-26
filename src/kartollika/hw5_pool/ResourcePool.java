package kartollika.hw5_pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class ResourcePool<T> {

    private int fullSize;
    private Stack<T> resources = new Stack<>();

    public ResourcePool(T[] resources) {
        for (T resource : resources) {
            this.resources.push(resource);
        }
        fullSize = this.resources.size();
    }

    public synchronized List<T> get(int neededCount) {
        List<T> requested = new ArrayList<>();
        while (resources.size() < neededCount) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < neededCount; ++i) {
            requested.add(resources.pop());
        }
        return requested;
    }

    public synchronized void release(List<T> released) {
        resources.addAll(released);
        notifyAll();
    }

    public synchronized int getSize() {
        return fullSize;
    }
}
