package leetcode;
import java.util.*;

/**
 * Created by alexisherrera on 10/15/17.
 */
public class SortByFrequency {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();

        //populate the map
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //create heap
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
                    public int compare(Map.Entry<Character, Integer> m1, Map.Entry<Character, Integer> m2) {
                        return Integer.compare(m1.getValue(), m2.getValue()) * -1;
                    }
                });

        //put entries in the heap
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }

        char[] result = new char[s.length()];
        int index = 0;

        //iterate while the heap is not empty
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                result[index] = entry.getKey();
                index++;
            }
        }

        return new String(result);

    }
}
