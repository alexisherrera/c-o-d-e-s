package hashtables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by alexisherrera on 10/4/17.
 */
public class P9 {
    //find longest subarray with distinct entries
    //will do with string/characters because it is an analogous problem and we can check with leetcode

    public static int lengthLongestSubDistinct(String s) {
        //we will create a map that maps the last occurrence of a character
        if (s.length() == 0) { return 0; }
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        int maxLength = 0;
        int startOfSubarray = 0;

        for (int i = 0; i < s.length(); i++) {
            //if map does not contain the key, we just add it
            if (lastOccurrence.containsKey(s.charAt(i))) {
                startOfSubarray = Math.max(startOfSubarray, lastOccurrence.get(s.charAt(i)) + 1);
            }
            //we need to recalculate the max length even when the lastOccurance contains the key because
            //if we have already encountered all possible different characters in the array, then we will ALWAYS
            //find a last occurance which contains a key, therefore, we always need to recalculate the maximum length
            lastOccurrence.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - startOfSubarray);
        }
        return maxLength + 1;
    }
}
