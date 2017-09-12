package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by alexisherrera on 9/12/17.
 */
public class Practice {
    //practice with priority queues as heaps
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        int[] array = {10000, 4,6 ,7, 8, 100};
        for (int i : array) {
            pq.add(i);
        }

        //as we can see, the smallest elements are by default at the top oft he priority queue. This suggests
        //that by default puts thing at the top in accordance to its natural ordering.
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
     }
}
