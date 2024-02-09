package by.aston;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ArrayListTest {

    @Test
    public void testAddSingleElementAndGetSingleElement() {
        ArrayList<Integer> list = new ArrayList<>();
        assertTrue(list.add(1));
        assertEquals(1, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
    }
    @Test
    public void testAddMultipleElements() {
        ArrayList<String> list = new ArrayList<>();
        assertTrue(list.add("apple"));
        assertTrue(list.add("banana"));
        assertEquals(2, list.size());
        assertEquals("apple", list.get(0));
        assertEquals("banana", list.get(1));
    }

    @Test
    public void testAddMoreThenTenElements() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            list.add("banana");
        }
        assertEquals(13,list.size());
    }

    @Test
    public void testGetInvalidIndex() {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
    }


    @Test
    public void testRemove() {
        ArrayList<Character> list = new ArrayList<>(1,2);
        list.add('a');
        list.add('b');
        assertEquals('a', (char) list.remove(0));
        assertEquals(1, list.size());
        assertEquals('b', (char) list.get(0));
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
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        ArrayList<Integer> otherList = new ArrayList<>();
        otherList.add(3);
        otherList.add(4);

        assertTrue(list.addAll(otherList));
        assertEquals(4, list.size());
        assertEquals(3, (int)list.get(2));
        assertEquals(4, (int)list.get(3));
    }

    @Test
    public void testAddAllEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();

        ArrayList<Integer> otherList = new ArrayList<>();
        otherList.add(1);
        otherList.add(2);

        assertTrue(list.addAll(otherList));
        assertEquals(2, list.size());
        assertEquals(1, (int)list.get(0));
        assertEquals(2, (int)list.get(1));
    }
    @Test
    void testSortArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(15);
        list.add(4);
        list.add(8);

        ArrayList<Integer> sortedList = (ArrayList<Integer>) MyCollection.sort(list);
        ArrayList<Integer> expectedList = new ArrayList<>();
        expectedList.add(4);
        expectedList.add(8);
        expectedList.add(15);

        assertArrayEquals(expectedList.toArray(), sortedList.toArray());
    }


    @Test
    void testResize() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        int initialCapacity = list.size();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertTrue(list.size() > initialCapacity);
    }


    @Test
    void testIsEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void testIndexOfValue() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(0, list.indexOf(1));
        assertEquals(1, list.indexOf(2));
        assertEquals(2, list.indexOf(3));
        assertEquals(-1, list.indexOf(5));
    }

    @Test
    public void testConstructorWithStringList() {
        List<String> initList = new ArrayList<>();
        initList.add("a");
        initList.add("b");
        initList.add("c");

        LinkedList<String> linkedList = new LinkedList<>(initList);

        assertEquals(initList.size(), linkedList.size());
        for (int i = 0; i < initList.size(); i++) {
            assertEquals(initList.get(i), linkedList.get(i));
        }
    }
}