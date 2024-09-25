package cs271.lab.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestList {

    private List<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new ArrayList<Integer>();
        // TODO also try with a LinkedList - does it make any difference?
        // list = new LinkedList<Integer>();
        // just like testiterator.java, we can keep the ArrayList
    }

    @After
    public void tearDown() throws Exception {
        list = null;
    }

    @Test
    public void testSizeEmpty() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        try {
            list.get(0);
            fail("there should not be any items in the list");
        } catch (Exception ex) {
        }
    }

    @Test
    public void testSizeNonEmpty() {
        // TODO fix the expected values in the assertions below
        list.add(77);
        // false, size is not empty
        assertEquals(false, list.isEmpty());
        // only 1 element in the list, 77
        assertEquals(1, list.size());
        // 77 is the value of the first element as declared in line 45
        assertEquals(77, list.get(0).intValue());
    } // done

    @Test
    public void testContains() {
        // TODO write assertions using
        // list.contains(77)
        // that hold before and after adding 77 to the list
        assertFalse(list.contains(77)); // 77 has not yet been added to the list
        list.add(77);
        assertTrue(list.contains(77)); // 77 has now been added
    } // done

    @Test
    public void testAddMultiple() {
        list.add(77);
        list.add(77);
        list.add(77);
        // TODO fix the expected values in the assertions below
        // 3 elements have been added
        assertEquals(3, list.size());
        // first element starts at 0
        assertEquals(0, list.indexOf(77));
        // second element's value is 77
        assertEquals(77, list.get(1).intValue());
        // 3 elements = 0, 1, 2
        assertEquals(2, list.lastIndexOf(77));
    } // done

    @Test
    public void testAddMultiple2() {
        list.add(33);
        list.add(77);
        list.add(44);
        list.add(77);
        list.add(55);
        list.add(77);
        list.add(66);
        // TODO fix the expected values in the assertions below
        // there are 7 elements
        assertEquals(7, list.size());
        // 77 is the second element at index 1
        assertEquals(1, list.indexOf(77));
        // the last 77 is the sixth element at index 5
        assertEquals(5, list.lastIndexOf(77));
        // index 2 holds 44
        assertEquals(44, list.get(2).intValue());
        // index 3 holds 77
        assertEquals(77, list.get(3).intValue());
        // correction on the list
        assertEquals(List.of(33, 77, 44, 77, 55, 77, 66), list);
    } // done

    @Test
    public void testRemoveObject() {
        list.add(3);
        list.add(77);
        list.add(4);
        list.add(77);
        list.add(5);
        list.add(77);
        list.add(6);
        list.remove(5); // what does this method do?
        // this method removes the integer at index 5
        // TODO fix the expected values in the assertions below
        // size is 6 after removing element in index 5
        assertEquals(6, list.size());
        // the first 77 appears at index 1
        assertEquals(1, list.indexOf(77));
        // after removing index 5, the last 77 is at index 3
        assertEquals(3, list.lastIndexOf(77));
        // value 4 is at index 2
        assertEquals(4, list.get(2).intValue());
        // value 77 is at index 3
        assertEquals(77, list.get(3).intValue());
        list.remove(Integer.valueOf(5)); // what does this one do?
        // this method removes the element that holds the value of 5, at index 4
        // after removing index 4 and 5, it is now size 5
        assertEquals(5, list.size());
        // first instance of 77 is still at index 1
        assertEquals(1, list.indexOf(77));
        // last instance after removing index 5 and 6 is 3
        assertEquals(3, list.lastIndexOf(77));
        // value 4 is still at index 2
        assertEquals(4, list.get(2).intValue());
        // value 77 is still at index 3
        assertEquals(77, list.get(3).intValue());
    } // done

    @Test
    public void testContainsAll() {
        list.add(33);
        list.add(77);
        list.add(44);
        list.add(77);
        list.add(55);
        list.add(77);
        list.add(66);
        // TODO using containsAll and List.of (see above),
        // 1) assert that list contains all five different numbers added
        // 2) assert that list does not contain all of 11, 22, and 33
        // list has unique values, true
        assertTrue(list.containsAll(List.of(33, 77, 44, 55, 66)));
        // list has the following values, false
        assertFalse(list.containsAll(List.of(11, 22, 33)));

    } // done

    @Test
    public void testAddAll() {
        // TODO in a single statement using addAll and List.of,
        // add items to the list to make the following assertions pass
        // (without touching the assertions themselves)
        list.addAll(List.of(33, 77, 44, 77, 55, 77, 66)); // adding all elements in one line in order
        assertEquals(7, list.size());
        assertEquals(33, list.get(0).intValue());
        assertEquals(77, list.get(1).intValue());
        assertEquals(44, list.get(2).intValue());
        assertEquals(77, list.get(3).intValue());
        assertEquals(55, list.get(4).intValue());
        assertEquals(77, list.get(5).intValue());
        assertEquals(66, list.get(6).intValue());
    } // done

    @Test
    public void testRemoveAll() {
        list.add(33);
        list.add(77);
        list.add(44);
        list.add(77);
        list.add(55);
        list.add(77);
        list.add(66);
        // TODO in a single statement using removeAll and List.of,
        // remove items from the list to make the following assertions pass
        // (without touching the assertions themselves)
        list.removeAll(List.of(33, 44, 55, 66)); // removing by referencing the values themselves
        assertEquals(3, list.size());
        assertEquals(List.of(77, 77, 77), list);
    } // done

    @Test
    public void testRetainAll() {
        list.add(33);
        list.add(77);
        list.add(44);
        list.add(77);
        list.add(55);
        list.add(77);
        list.add(66);
        // TODO in a single statement using retainAll and List.of,
        // remove items from the list to make the following assertions pass
        // (without touching the assertions themselves)
        list.retainAll(List.of(77)); // only keep the values of 77
        assertEquals(3, list.size());
        assertEquals(List.of(77, 77, 77), list);
    }

    @Test
    public void testSet() {
        list.add(33);
        list.add(77);
        list.add(44);
        list.add(77);
        list.add(55);
        list.add(77);
        list.add(66);
        // TODO use the set method to change specific elements in the list
        // such that the following assertions pass
        // (without touching the assertions themselves)
        // index 1, 3, 5 need to be set to value 99
        list.set(1, 99);
        list.set(3, 99);
        list.set(5, 99);
        assertEquals(7, list.size());
        assertEquals(33, list.get(0).intValue());
        assertEquals(99, list.get(1).intValue());
        assertEquals(44, list.get(2).intValue());
        assertEquals(99, list.get(3).intValue());
        assertEquals(55, list.get(4).intValue());
        assertEquals(99, list.get(5).intValue());
        assertEquals(66, list.get(6).intValue());
    } // done

    @Test
    public void testSubList() {
        list.add(33);
        list.add(77);
        list.add(44);
        list.add(77);
        list.add(55);
        list.add(77);
        list.add(66);
        // TODO fix the arguments in the subList method so that the assertion
        // passes
        //  refers to the index of the start and end of the sublist
        assertEquals(List.of(44, 77, 55), list.subList(2, 5));
    }
}
