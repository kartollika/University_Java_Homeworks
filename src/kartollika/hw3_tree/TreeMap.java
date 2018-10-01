package kartollika.hw3_tree;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class TreeMap<K extends Comparable<K>, V> implements Map<K, V> {

    private BinaryTree<K, V> binaryTree = new BinaryTree<>();

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        return binaryTree.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        if (get(key) == null) {
            return false;
        }

        return true;
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V get(Object key) {
        try {
            return binaryTree.getNodeValue((K) key);
        } catch (ClassCastException cce) {
            return null;
        }
    }

    @Override
    public V put(K key, V value) {
        return binaryTree.add(key, value);
    }

    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return binaryTree.toString();
    }
}
