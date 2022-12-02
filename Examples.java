
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class Examples {
    HeapChecker HT = new HeapChecker();


    /*
    Random Heap I made up
                     2
                   /   \
                  8     4
                 / \   / \
                10 11 4   6
     */

    //The above heap
    IHeap heapFourEmpty = new DataHeap(4);
    IHeap heapSix = new DataHeap(6);
    IHeap heapFour = new DataHeap(4, heapFourEmpty, heapSix);
    IHeap heapTen = new DataHeap(10);
    IHeap heapEleven = new DataHeap(11);
    IHeap heapEight = new DataHeap(8, heapTen, heapEleven);
    IHeap rootHeap = new DataHeap(2, heapEight, heapFour);

    /*
       Random Heap I made up but the root does not uphold the LAW
                       100
                      /   \
                     8     4
                    / \   / \
                   10 11 4   6
     */
    IHeap badHeap = new DataHeap(100, heapEight, heapFour);

    /*
       Random Heap I made up but the root does not uphold the LAW
                        2
                      /   \
                     8     4
                    / \   / \
                   10  1  4   6
     */

    IHeap badHeapTwo1 = new DataHeap(1);
    IHeap badHeapTwo10 = new DataHeap(10);
    IHeap badHeapTwo8 = new DataHeap(8, badHeapTwo10, badHeapTwo1);
    IHeap badHeapTwo = new DataHeap(2,badHeapTwo8, heapFour);

    /*
   Heap where all the elements are the same
                    4
                  /   \
                 4     4
                / \   / \
               4   4 4   4
    */
    IHeap heapFourFour = new DataHeap(4, heapFourEmpty, heapFourEmpty);
    IHeap sameHeap = new DataHeap(4, heapFourFour, heapFourFour);


    /*
    Heap with 3 of the same values but in different sub heaps
                     2
                   /   \
                  4     4
                 / \   / \
                8  11 4   6
               /
              10
     */
    IHeap edgeLevelTwoRLeft = new DataHeap(4);
    IHeap edgeLevelTwoRRight = new DataHeap(6);
    IHeap edgeRightRootHeap = new DataHeap(4,edgeLevelTwoRLeft, edgeLevelTwoRRight);
    IHeap edgeLevelTwoLLeft = new DataHeap(8, new DataHeap(10), new MtHeap());
    IHeap edgeLeftRootHeap = new DataHeap(4, edgeLevelTwoLLeft, new DataHeap(11));
    IHeap edgeCaseRootHeap = new DataHeap(2, edgeLeftRootHeap,edgeRightRootHeap);


     /*
        First Heap but with the two removed
                     4
                   /   \
                  8     4
                 / \     \
                10 11     6
     */

    IHeap heapFourRemoved = new DataHeap(4, new MtHeap(), heapSix);
    IHeap rootHeapRemoved = new DataHeap(4, heapEight, heapFourRemoved);

      /*
        Previous Heap but with the four removed
                     4
                   /   \
                  8     6
                 / \
                10 11
     */

    public Examples() {
    }

    //Sorry that my naming conventions are terrible to whoever is grading this I also hate how I named things


    //Helper Tests
    @Test
    public void testGoodHeap() {
        assertTrue(rootHeap.isHeap());
    }

    @Test
    public void testBadHeap() {
        assertFalse(badHeap.isHeap());
    }

    @Test
    public void testSameHeap() {
        assertTrue(sameHeap.isHeap());
    }

    @Test
    public void countOccurrencesSameHeap4() {
        assertEquals(7, sameHeap.countOccurrences(4));
    }

    @Test
    public void countOccurrencesSameHeap0() {
        assertEquals(0, sameHeap.countOccurrences(0));
    }

    @Test
    public void countOccurrencesRootHeap4() {
        assertEquals(2, rootHeap.countOccurrences(4));
    }

    @Test
    public void countOccurrencesEdgeCase() {
        assertEquals(3, edgeCaseRootHeap.countOccurrences(4));
    }

    @Test
    public void addEltsToListRootHeap1() {
        HashSet<Integer> expectedResult = new HashSet<>();
        expectedResult.add(2);
        expectedResult.add(8);
        expectedResult.add(10);
        expectedResult.add(11);
        expectedResult.add(4);
        expectedResult.add(6);
        assertEquals(expectedResult, rootHeap.createElementsList());
    }



    // HeapChecker Functions


    //addEltTester() Tests
    @Test
    /* Heap is based off of "rootHeap" but adding a 2
       Expecting a tree like the one below

                     2
                   /   \
                  8     2
                 / \   / \
                10 11 4   6
                     /
                    4
     */
    public void addEltTesterTestHeap1(){
        assertTrue(HT.addEltTester(rootHeap, 2 , rootHeap.addElt(2)));
    }

    @Test
    /*
    When given the "rootHeap" we expect something like the above test.
    In this test we are instead given a bad heap where somehow the root becomes 100
    Immediately terminates when checking if the resulting tree is a heap
     */
    public void addEltBadHeapTesterTest(){
        assertFalse(HT.addEltTester(rootHeap, 4, badHeap.addElt(2)));
    }

    @Test
    /*
    Same idea as the above test.
     */
    public void addEltTesterReturnABadHeap() {
        assertFalse(HT.addEltTester(rootHeap, 10, badHeap.addElt(10)));
    }

    @Test
    /*
    Adding another 4 to the tree of 4s, it can go literally anywhere.
     */
    public void addEltSameHeapTester() {
        assertTrue(HT.addEltTester(sameHeap, 4, sameHeap.addElt(4)));
    }

    @Test
    /*
    Adds a 9 to the tree of 4s, can be on any one of the end nodes.
     */
    public void addEltSameHeapTester2() {
        assertTrue(HT.addEltTester(sameHeap, 9, sameHeap.addElt(9)));
    }

    @Test
    /*
    Tests the heap where the data that doesn't make the tree a heap is further at the bottom
     */
    public void addEltBadHeapTester3() {
        assertFalse(HT.addEltTester(badHeapTwo, 4, badHeapTwo.addElt(3)));
    }


    //remMinEltTester() Tests

    @Test
    /*
    Removes the top of the tree from the "rootHeap" heap.
    Expected to return something like:
                     4
                   /   \
                  8     4
                 / \     \
                10 11     6

     */
    public void remMinNumFromRootHeapTester() {
        assertTrue(HT.remMinEltTester(rootHeap, rootHeapRemoved));
    }

    @Test
    /*
    Remove the 4 from the test from above
     */
    public void contRemMinNumFromRootHeapTester() {
        assertTrue(HT.remMinEltTester(rootHeapRemoved,rootHeapRemoved.remMinElt()));
    }

    @Test
    /*
    Remove the final 4 from the test from above
     */
    public void removeLastFourFromRootHeap() {
        assertTrue(HT.remMinEltTester(rootHeapRemoved.remMinElt(), rootHeapRemoved.remMinElt().remMinElt()));
    }

    @Test
    /*
    Immediately terminates because given heap "badHeap" is not a heap.
     */
    public void remMinNumFromBadHeapTester() {
        assertFalse(HT.remMinEltTester(badHeap, rootHeapRemoved));
    }

    @Test
    /*
    Immediately terminates because resulting heap "badHeap" is not a heap.
     */
    public void remMinNumFromBadHeapTester2() {
        assertFalse(HT.remMinEltTester(rootHeap, badHeap));
    }

    @Test
    /*
    Removes a 4 from the tree of 4s
     */
    public void remMinNumFromSameHeap() {
        assertTrue(HT.remMinEltTester(sameHeap, sameHeap.remMinElt()));
    }


}

