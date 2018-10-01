package kartollika.hw3_tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeMapTest {

    @Test
    public void testPut() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 2);
        treeMap.put(2, 3);
        treeMap.put(3, 4);

        Integer resultOldValue = treeMap.put(4, 5);
        String resultString = treeMap.toString();
        String expectedString = "2 3 4 5 ";
        assertEquals(expectedString, resultString);
        assertNull(resultOldValue);

        treeMap.put(0, 0);
        resultOldValue = treeMap.put(1, 4);
        Integer expected = 2;
        resultString = treeMap.toString();
        expectedString = "0 4 3 4 5 ";
        assertEquals(expectedString, resultString);
        assertEquals(resultOldValue, expected);
    }

    @Test
    public void testContainsKey() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 2);
        treeMap.put(2, 3);
        treeMap.put(3, 4);

        boolean result = treeMap.containsKey(2);
        assertTrue(result);

        result = treeMap.containsKey(5);
        assertFalse(result);
    }

    @Test
    public void testGet() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 2);
        treeMap.put(2, 3);
        treeMap.put(3, 4);

        Integer result = treeMap.get(2);
        Integer expected = 3;
        assertEquals(result, expected);

        result = treeMap.get(4);
        assertNull(result);
    }

    @Test
    public void testIsEmpty() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        boolean result = treeMap.isEmpty();
        assertTrue(result);

        treeMap.put(1, 2);
        result = treeMap.isEmpty();
        assertFalse(result);
    }

}
