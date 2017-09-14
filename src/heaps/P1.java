package heaps;

import java.util.ArrayList;
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


    //function to merge the files
    public static List<Integer> mergeOrderedSequnces(List<List<Integer>> sequences) {

        //make our heap bring the smallest value to the top by the HeapEntrys value!!!
        PriorityQueue<HeapEntry> minHeap = new PriorityQueue<>(sequences.size(), new Comparator<HeapEntry>() {
            @Override
            public int compare(HeapEntry o1, HeapEntry o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });


        //lets fill the heap with the top element from each sequench
        for (int i = 0; i < sequences.size(); i++) {
            List<Integer> seq = sequences.get(i);
            minHeap.add(new HeapEntry(seq.get(0), i, 0));
        }


        //now our merging step: lets first initialize a list for our result
        List<Integer> result = new ArrayList<>();

        //now the merging step
        while (!minHeap.isEmpty()) {
            HeapEntry smallestEntry = minHeap.remove();
            int originList = smallestEntry.listOrigin;
            int indexAtList = smallestEntry.listIndex;

            //check that we can retrieve an element from the list it came from. if so add to heap
            if (indexAtList + 1 < sequences.get(originList).size()) {
                minHeap.add(new HeapEntry(sequences.get(originList).get(indexAtList + 1), originList, indexAtList + 1));
            }

            //if not, that sequence is empty and we can just ignore it. Now lets add the minheap entry to our result list.
            result.add(smallestEntry.value);
        }



        return result;

    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(3);
        l1.add(5);
        l1.add(7);

        List<Integer> l2 = new ArrayList<>();
        l2.add(0);
        l2.add(6);

        List<Integer> l3 = new ArrayList<>();
        l3.add(0);
        l3.add(6);
        l3.add(28);

        List<List<Integer>> sequences = new ArrayList<>();
        sequences.add(l1);
        sequences.add(l2);
        sequences.add(l3);

        List<Integer> mergedLists = mergeOrderedSequnces(sequences);

        //WEEWEWEW DID IT ~!!!!~!
        System.out.println(mergedLists);
    }

}
