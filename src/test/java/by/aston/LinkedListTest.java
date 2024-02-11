package by.aston;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    @Test
    public void testAddSingleElementAndGetSingleElement() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.add(1));
        assertEquals(1, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
    }

    @Test
    public void testAddMultipleElements() {
        LinkedList<String> list = new LinkedList<>();
        assertTrue(list.add("apple"));
        assertTrue(list.add("banana"));
        assertEquals(2, list.size());
        assertEquals("apple", list.get(0));
        assertEquals("banana", list.get(1));
    }

    @Test
    public void testRemoveInvalidIndex() {
        ArrayList<Boolean> list = new ArrayList<>();
        list.add(true);
        list.add(false);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(2));
    }
    @Test
    public void testAddAll() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);

        LinkedList<Integer> otherList = new LinkedList<>();
        otherList.add(3);
        otherList.add(4);

        assertTrue(list.addAll(otherList));
        assertEquals(4, list.size());
        assertEquals(3, (int)list.get(2));
        assertEquals(4, (int)list.get(3));
    }
    @Test
    public void testAddAllEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();

        LinkedList<Integer> otherList = new LinkedList<>();
        otherList.add(1);
        otherList.add(2);

        assertTrue(list.addAll(otherList));
        assertEquals(2, list.size());
        assertEquals(1, (int)list.get(0));
        assertEquals(2, (int)list.get(1));
    }

    @Test
    void testIsEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testConstructor() {
        List<Integer> initList = new ArrayList<>();
        initList.add(1);
        initList.add(2);
        initList.add(3);

        LinkedList<Integer> linkedList = new LinkedList<>(initList);

        assertEquals(initList.size(), linkedList.size());
        for (int i = 0; i < initList.size(); i++) {
            assertEquals(initList.get(i), linkedList.get(i));
        }
    }
}
