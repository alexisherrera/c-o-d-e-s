package leetcode;
import java.util.*;

/**
 * Created by alexisherrera on 10/16/17.
 */
public class KthSmallestElementSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
    //no systematic way to do this. Instead we need to use a brute forcy approach.

    PriorityQueue<int[]> minheap = new PriorityQueue<>(new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
            //natural ordering
            int aVal = matrix[a[0]][a[1]];
            int bVal = matrix[b[0]][b[1]];

            return Integer.compare(aVal, bVal);
        }
    });


    //fill the priority queue with the first k elements in the top roww
        for (int i = 0; i < Math.min(matrix[0].length, k); i++) {
        minheap.add(new int[] {0, i});
            //at most k entries (klogk).
    }

    //for k-1 times remove the top element from the heap. After this the kth smallest is at top of the heap
        while (!minheap.isEmpty() && k > 1) {
        int[] temp = minheap.poll();
        if (temp[0] != matrix.length - 1) {
            minheap.add(new int[] {temp[0] + 1, temp[1]});
        }
        k--;

    }

    int[] resultArr = minheap.poll();

        //remove k total removals and up to k - 1 insertions. THerefore r.t. is O(klgk)
        return matrix[resultArr[0]][resultArr[1]];

}
}
