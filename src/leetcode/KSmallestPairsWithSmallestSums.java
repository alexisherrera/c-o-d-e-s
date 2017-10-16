package leetcode;
import java.util.*;

/**
 * Created by alexisherrera on 10/16/17.
 */
public class KSmallestPairsWithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0) { return new ArrayList<>(); }
        //brute force is find all pairs and sort by sum.
        //better use minheap to keep the first k pairs with numbers starting in nums1 (this ensures we use k elements at most)

        //note that it is important to note that we can access nums1 and nums 2 from the outside the scope of the comparator.
        PriorityQueue<int[]> minheap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                int sumA = nums1[a[0]] + nums2[a[1]];
                int sumB = nums1[b[0]] + nums2[b[1]];

                //we want to return smallest first therefore use natural ordering
                return Integer.compare(sumA, sumB);
            }
        });

        //put k elements in minheap with 0 --> k elements in nums1 and nums2[0]
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minheap.add(new int[] {i, 0});
        }

        List<int[]> result = new ArrayList<>();

        while (!minheap.isEmpty() && k > 0) {
            int[] res = minheap.poll();
            result.add(new int[] {nums1[res[0]], nums2[res[1]]});
            if (res[1] < nums2.length - 1) {
                res[1] = res[1] + 1;
                minheap.add(res);
            }
            k--;
        }


        //runningtime to put k elements in heap is O(klgk). At all times we keep at mostk elements in the
        //heap and we remove items k items making O(klgk)
        return result;
    }
}
