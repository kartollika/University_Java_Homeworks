package kartollika.hw3_tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void testAdd() {
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        tree.add(2, "second");
        tree.add(1, "first");
        tree.add(3, "third");
        tree.add(0, "zero");

        String result = tree.toString();
        String expected = "zero first second third ";
        assertEquals(expected, result);
    }

    @Test
    public void testRemove() {
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        tree.add(2, "second");
        tree.add(1, "first");
        tree.add(3, "third");
        tree.add(0, "zero");

        tree.remove(3);
        String result = tree.toString();
        String expected = "zero first second ";
        assertEquals(expected, result);
    }

    @Test
    public void testContains() {
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        tree.add(2, "second");
        tree.add(1, "first");
        tree.add(3, "third");
        tree.add(0, "zero");

        boolean result = tree.contains(1);
        assertTrue(result);

        result = tree.contains(5);
        assertFalse(result);
    }
}
