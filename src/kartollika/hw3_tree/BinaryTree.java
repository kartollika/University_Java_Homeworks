package kartollika.hw3_tree;

public class BinaryTree<T extends Comparable<T>> {

    private Node root;

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(-2);
        binaryTree.add(-3);
        binaryTree.add(-1);
        binaryTree.add(0);
        binaryTree.remove(-2);
        System.out.println(binaryTree.contains(-1));
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(T value) {
        root = addNodeRecursive(root, value);
    }

    private Node addNodeRecursive(Node node, T value) {
        if (node == null) {
            return new Node(value);
        }

        int valuesCompared = value.compareTo(node.getValue());
        if (valuesCompared < 0) {
            node.setLeftChild(addNodeRecursive(node.getLeftChild(), value));
        } else if (valuesCompared > 0) {
            node.setRightChild(addNodeRecursive(node.getRightChild(), value));
        } else {
            return node;
        }

        return node;
    }


    public void remove(T value) {
        root = removeRecursive(root, value);
    }

    private Node removeRecursive(Node node, T value) {
        if (node == null) return null;

        int valuesCompared = value.compareTo(node.getValue());
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

            Node target = findBiggestInLeftTree(node.getRightChild());
            node.setValue(target.getValue());
            node.setLeftChild(removeRecursive(node.getLeftChild(), target.getValue()));

        }

        if (valuesCompared < 0) {
            node.setLeftChild(removeRecursive(node.getLeftChild(), value));
            return node;
        }

        node.setRightChild(removeRecursive(node.getRightChild(), value));
        return node;
    }

    private Node findBiggestInLeftTree(Node node) {
        if (node.getLeftChild() == null) {
            return node;
        } else {
            return findBiggestInLeftTree(node.getLeftChild());
        }
    }

    public boolean contains(T value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node node, T value) {
        if (node == null) {
            return false;
        }

        int valuesCompared = value.compareTo(node.getValue());
        if (valuesCompared < 0) {
            return containsRecursive(node.getLeftChild(), value);
        } else if (valuesCompared > 0) {
            return containsRecursive(node.getRightChild(), value);
        } else {
            return true;
        }
    }

    private class Node {
        private T value;
        private Node leftChild;
        private Node rightChild;

        Node(T value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }

        T getValue() {
            return value;
        }

        void setValue(T value) {
            this.value = value;
        }

        Node getLeftChild() {
            return leftChild;
        }

        void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        Node getRightChild() {
            return rightChild;
        }

        void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }
}
