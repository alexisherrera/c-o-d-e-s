package leetcode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by alexisherrera on 10/12/17.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        //one approach is to create a map of string -> list<String> and sort all entries in the array.
        //This would give us a running time of O(nlgn). Better is if we just sort and group equal elements. O(1) space

        //we need to sort each entry in the array and

        HashMap<String, List<String>> map = new HashMap<>();

        //sort individual strings
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] s = str.toCharArray();
            Arrays.sort(s);

            String updated = new String(s);

            if (map.containsKey(updated)) {
                List<String> l = map.get(updated);
                l.add(str);
                map.put(updated, l);
            }
            else {
                List<String> l = new ArrayList<>();
                l.add(str);
                map.put(updated, l);
            }
        }

        List<List<String>> results = new ArrayList<>();

        for (String s : map.keySet()) {
            results.add(map.get(s));
        }

        //running time is O(n * slgs). space is O(n * s)
        return results;

    }
}
