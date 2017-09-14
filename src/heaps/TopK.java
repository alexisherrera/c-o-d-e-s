package heaps;

import java.util.*;

/**
 * Created by alexisherrera on 9/13/17.
 */
public class TopK {

    //method to find the top k elements of a stream, or in this case an iterator

    public static List<Integer> topK(int k, Iterator<Integer> iter) {


        //to keep track of the topK elements, we can simply store the topK elements in a heap. One strategy
        //is to use a min heap and every time we encounter a new element, we can simply check the value of the top element
        //if the value we are currently handling is larger than the min, then we remove the min and insert the
        //value which we are handling. This works because if an element is larger than the minimum then the minimum
        //that is currently in the heap, then there is no way for this element to be a part of the top k. Of course
        //we first need to fill our minheap with k elements.

        PriorityQueue<Integer> minheap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        System.out.println(minheap.size());

        //find the top k elements
        while (iter.hasNext()) {
            int element = iter.next();
            if (minheap.size() < k) {
                minheap.add(element);
            }
            else {
                int minimum = minheap.peek();
                if (minimum < element) {
                    minheap.remove();
                    minheap.add(element);
                }
            }
        }

        List<Integer> topK = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            topK.add(0);
        }

        int i = k - 1;
        while(!minheap.isEmpty()) {
            topK.set(i, minheap.remove());
            i--;
        }

        return topK;


        //adding into a heap takes O(lgn) time, and we do it O(lg1) + O(lg2) + O(lg3) ... up to O(nLg(k)) if
        //all elements are given to us in ascending order. Final running time is O(nlgK). Space is O(k).
    }

    public static void main(String[] args) {

        List<Integer> elements= new ArrayList<>();
        elements.add(10);
        elements.add(2);
        elements.add(99);
        elements.add(199);
        elements.add(2);
        elements.add(94);
        elements.add(-2);
        elements.add(9);
        elements.add(110000000);
        elements.add(232000000);
        elements.add(32);

        List<Integer> topK = topK(3, elements.iterator());
        System.out.println(topK);
    }
}
