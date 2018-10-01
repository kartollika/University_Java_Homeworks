package kartollika.hw3_tree;

public class BinaryTree<K extends Comparable<K>, V> {

    private Node root;

    public boolean isEmpty() {
        return root == null;
    }

    public V add(K key, V value) {
        V oldValue = getNodeValue(key);
        root = addNodeRecursive(root, key, value);
        return oldValue;
    }

    private Node addNodeRecursive(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }

        int valuesCompared = key.compareTo(node.getKey());
        if (valuesCompared < 0) {
            node.setLeftChild(addNodeRecursive(node.getLeftChild(), key, value));
        } else if (valuesCompared > 0) {
            node.setRightChild(addNodeRecursive(node.getRightChild(), key, value));
        } else {
            node.setValue(value);
            return node;
        }

        return node;
    }

    public V getNodeValue(K key) {
        Node found = getNodeValueRecursive(root, key);
        if (found == null) {
            return null;
        }
        return found.getValue();
    }

    public Node getNodeValueRecursive(Node node, K key) {
        if (node == null) {
            return null;
        }

        int compareResult = key.compareTo(node.getKey());
        if (compareResult == 0) {
            return node;
        }
        if (compareResult < 0) {
            return getNodeValueRecursive(node.getLeftChild(), key);
        }

        return getNodeValueRecursive(node.getRightChild(), key);
    }

    public void remove(K key) {
        root = removeRecursive(root, key);
    }

    private Node removeRecursive(Node node, K key) {
        if (node == null) return null;

        int valuesCompared = key.compareTo(node.getKey());
        if (valuesCompared == 0) {
            if (node.getLeftChild() == null && node.getRightChild() == null) {
                return null;
            }

            if (node.getLeftChild() == null) {
                return node.getRightChild();
            }

            if (node.getRightChild() == null) {
                return node.getLeftChild();
            }

            Node target = findSmallestInTree(node.getRightChild());
            node.setValue(target.getValue());
            node.setKey(target.getKey());
            node.setRightChild(removeRecursive(node.getRightChild(), target.getKey()));
        }

        if (valuesCompared < 0) {
            node.setLeftChild(removeRecursive(node.getLeftChild(), key));
            return node;
        }

        node.setRightChild(removeRecursive(node.getRightChild(), key));
        return node;
    }

    private Node findSmallestInTree(Node node) {
        if (node.getLeftChild() == null) {
            return node;
        } else {
            return findSmallestInTree(node.getLeftChild());
        }
    }

    public boolean contains(K key) {
        return containsRecursive(root, key);
    }

    private boolean containsRecursive(Node node, K key) {
        if (node == null) {
            return false;
        }

        int valuesCompared = key.compareTo(node.getKey());
        if (valuesCompared < 0) {
            return containsRecursive(node.getLeftChild(), key);
        } else if (valuesCompared > 0) {
            return containsRecursive(node.getRightChild(), key);
        } else {
            return true;
        }
    }

    private String passLNR(StringBuilder stringBuilder, Node curNode) {
        if (curNode.getLeftChild() != null) {
            passLNR(stringBuilder, curNode.getLeftChild());
        }

        stringBuilder.append(curNode).append(" ");

        if (curNode.getRightChild() != null) {
            passLNR(stringBuilder, curNode.getRightChild());
        }

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return passLNR(new StringBuilder(), root);
    }

    private class Node {
        private K key;
        private V value;
        private Node leftChild;
        private Node rightChild;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }

        private K getKey() {
            return key;
        }

        private void setKey(K key) {
            this.key = key;
        }

        private V getValue() {
            return value;
        }

        private void setValue(V value) {
            this.value = value;
        }

        private Node getLeftChild() {
            return leftChild;
        }

        private void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        private Node getRightChild() {
            return rightChild;
        }

        private void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
