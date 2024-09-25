package cs271.lab.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerformance {

    // TODO run test and record running times for SIZE = 10, 100, 1000, 10000, ...
    // (choose in conjunction with REPS below up to an upper limit where the clock
    // running time is in the tens of seconds)
    // this will declare the size of each test
    private final int[] SIZES = {10, 100, 1000, 10000};
    // TODO (optional) refactor to DRY
    // which of the two lists performs better as the size increases?
    // private final int SIZE = 10;

    // TODO choose this value in such a way that you can observe an actual effect
    // for increasing problem sizes
    private final int REPS = 1000000; // choose this one, this will perform better because it is larger

    private List<Integer> arrayList;

    private List<Integer> linkedList;

    @Before
    public void setUp() throws Exception {
        // calculate length of array - 1, creates them all
        arrayList = new ArrayList<Integer>(SIZES[SIZES.length - 1]);
        linkedList = new LinkedList<Integer>();
        for (var i = 0; i < SIZES[SIZES.length - 1]; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    @After
    public void tearDown() throws Exception {
        // don't need to change
        arrayList = null;
        linkedList = null;
    }

    @Test
    public void testLinkedListAddRemove() {
        for (int size : SIZES) {
            long startTime = System.nanoTime(); // starts timer
            linkedList.clear(); // clears linkedList
            for (var r = 0; r < REPS; r++) {
                linkedList.add(0, 77);
                linkedList.remove(0);
            }
            long endTime = System.nanoTime(); // end timer
            // subtracting start time to end time to get total seconds
            // dividing by 1e6 for proper time display
            System.out.println("LinkedList Add/Remove with SIZE " + size + ": " + (endTime - startTime) / 1e6 + " ms");
        }
    }

    @Test
    public void testArrayListAddRemove() {
        for (int size : SIZES) {
            long startTime = System.nanoTime(); // start timer
            arrayList.clear(); // clear list
            for (var r = 0; r < REPS; r++) {
                arrayList.add(0, 77);
                arrayList.remove(0);
            }
            long endTime = System.nanoTime(); // end timer
            System.out.println("ArrayList Add/Remove with SIZE " + size + ": " + (endTime - startTime) / 1e6 + " ms");
        }
    }

    @Test
    public void testLinkedListAccess() {
        for (int size : SIZES) {
            long startTime = System.nanoTime(); // start timer
            var sum = 0L;
            for (var r = 0; r < REPS; r++) {
                sum += linkedList.get(r % size);
            }
            long endTime = System.nanoTime(); // end timer
            System.out.println("LinkedList Access with SIZE " + size + ": " + (endTime - startTime) / 1e6 + " ms");
        }
    }

    @Test
    public void testArrayListAccess() {
        for (int size : SIZES) {
            long startTime = System.nanoTime(); // start timer
            var sum = 0L;
            for (var r = 0; r < REPS; r++) {
                sum += arrayList.get(r % size);
            }
            long endTime = System.nanoTime(); // end timer
            System.out.println("ArrayList Access with SIZE " + size + ": " + (endTime - startTime) / 1e6 + " ms");
        }
    }
}