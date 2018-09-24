package kartollika.hw2_list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList implements List<Object> {

    private Node first;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (size == 0) {
            return false;
        }

        Iterator listIterator = getIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().equals(o)) {
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
        Node newNode = new Node(o, null, null);

        if (size == 0) {
            first = newNode;
            size++;
            return true;
        }

        Node curNode = first;
        while (curNode.next != null) {
            curNode = curNode.next;
        }

        curNode.next = newNode;
        newNode.previous = curNode;

        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (size == 0) {
            return false;
        }

        for (int i = 0; i < size; ++i) {
            if (get(i).equals(o)) {
                remove(i);
                return true;
            }
        }

        return false;
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
    public boolean addAll(int index, Collection<?> c) {
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
    public Object get(int index) {
        checkIndexInBounds(index);
        Node curNode = first;
        for (int i = 0; i < index; ++i) {
            curNode = curNode.next;
        }
        return curNode.content;
    }

    @Override
    public Object set(int index, Object element) {
        checkIndexInBounds(index);
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public void add(int index, Object element) {
        checkIndexInBounds(index);

        Node curNode = first;
        for (int i = 0; i < index; ++i) {
            curNode = curNode.next;
        }

        Node prev = curNode.previous;
        Node next = curNode.next;

        if (prev == null) {
            curNode.next = first;
            first = curNode;
            return;
        }

        prev.next = curNode;
        curNode.previous = prev;
        curNode.next = next;
        next.previous = curNode;
    }

    private void checkIndexInBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bound: index: " + index + " size: " + size);
        }
    }

    @Override
    public Object remove(int index) {
        checkIndexInBounds(index);

        Node curNode = first;
        for (int i = 0; i < index; ++i) {
            curNode = curNode.next;
        }

        Node prev = curNode.previous;
        Node next = curNode.next;
        Object content = curNode.content;

        if (prev == null && next == null) {
            first = null;
            size--;
            return content;
        }

        if (prev == null) {
            first = next;
            next.previous = null;
            size--;
            return content;
        }

        if (next == null) {
            prev.next = null;
            size--;
            return content;
        }

        prev.next = next;
        next.previous = prev;
        size--;
        return content;
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Unsupported");
    }

    Iterator<Object> getIterator() {
        return new Iterator<>() {

            Node curNode = first;

            @Override
            public boolean hasNext() {
                return curNode.next != null;
            }

            @Override
            public Object next() {
                Object content = curNode.next;
                curNode = curNode.next;
                return content;
            }
        };
    }

    @Override
    public ListIterator<Object> listIterator() {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public ListIterator<Object> listIterator(int index) {
        throw new UnsupportedOperationException("Unsupported");

    }

    @Override
    public List<Object> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "Empty list";
        }
        Node curNode = first;
        StringBuilder stringBuilder = new StringBuilder();
        while (curNode != null) {
            stringBuilder.append(curNode.content).append(" ");
            curNode = curNode.next;
        }
        return stringBuilder.toString();
    }

    private class Node {
        private Object content;
        private Node previous;
        private Node next;

        Node(Object content, Node previous, Node next) {
            this.content = content;
            this.previous = previous;
            this.next = next;
        }

    }
}
