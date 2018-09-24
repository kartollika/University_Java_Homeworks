package kartollika.hw2_list;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class MyQueue implements Queue<Object> {

    private MyLinkedList queue = new MyLinkedList();

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        Iterator queueIterator = queue.getIterator();
        while (queueIterator.hasNext()) {
            if (queueIterator.next().equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Object> iterator() {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public boolean add(Object o) {
        return queue.add(o);
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public boolean addAll(Collection<?> c) {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public boolean offer(Object o) {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public Object remove() {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public Object poll() {
        return queue.remove(0);
    }

    /*private int lastIndex() {
        return size() - 1;
    }*/

    @Override
    public Object element() {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public Object peek() {
        return queue.get(0);
    }
}
