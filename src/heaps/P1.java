package heaps;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by alexisherrera on 9/12/17.
 */
public class P1 {
    //merge sorted files

    //one approach is to maintain a heap of size(number of files). Since each line in each file is sorted
    //we just to need to compute the min of all of them.

    //algorithm goes like this: we use a minheap and add 1 line from each file. At the end of this the line
    //at the top of the min heap will contain the smallest value. We add this to our final list. We then
    //grab a line from the file that the previous extracted element was from. We can do this by marking
    //each file using an index variable. We can wrap each entry in the priority queue with a value and an index (what array
    //it comes from and the index of that array).

    //do this with numbers instead of files
    public static List<Integer> mergeOrderedSequnces(List<List<Integer>> sequences) {

        //make our heap bring the smallest value to the top by the HeapEntrys value!!!
        PriorityQueue<HeapEntry> minHeap = new PriorityQueue<>(sequences.size(), new Comparator<HeapEntry>() {
            @Override
            public int compare(HeapEntry o1, HeapEntry o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });









    }



    //class for the entries in our min heap that tell us where this value came from, and the index from which it was
    //taken.
    private static class HeapEntry {
        int value;
        int listOrigin;
        int listIndex;
        public HeapEntry(int v, int lO, int lI) {
            value = v;
            listOrigin = lO;
            listIndex = lI;
        }
    }

}
