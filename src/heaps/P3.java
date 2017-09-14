package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by alexisherrera on 9/13/17.
 */
public class P3 {
    //sort an almost sorted array

    //write program which takes as input long seq of numbers and prints the numbers in sorted order.
    //each number is at most k away from its correctly sorted position


    //we can solve this by iterating through an array and always keeping k elements in our minheap and
    //only and at each iterating removing the smallest printing it out and moving to the next index and adding the
    //kth element

    public static void printKSortedArray(int k, int[] nums) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        //put the first k elements in the minheap
        for (int i = 0; i < k; i++) {
            minheap.add(nums[i]);
        }

        //iterate from 0 until the end of the array printing the top of the min heap and adding
        //the element the new kth element
        for (int i = 0; i < nums.length; i++) {
            int minAtPosition = minheap.remove();
            System.out.println(minAtPosition);
            if (i + k < nums.length) {
                minheap.add(nums[i + k]);
            }
        }

        //now print everything in minheap till empty
        while (!minheap.isEmpty()) {
            int min = minheap.remove();
            System.out.print(min + " ");
        }

        //running time is O(nlgk). we keep a heap of size k and remove one el and add another n times.
        //space is O(k) bc heap is max of size k

    }

    public static void main(String[] args) {
        int[] nums = {3, -1, 2, 6, 4, 5, 8};
        printKSortedArray(2, nums);
    }

}
