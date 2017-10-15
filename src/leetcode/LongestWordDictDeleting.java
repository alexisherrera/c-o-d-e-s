package leetcode;
import java.util.*;

/**
 * Created by alexisherrera on 10/14/17.
 */
public class LongestWordDictDeleting {
    //524. Longest Word in Dictionary through Deleting

    public String findLongestWord(String s, List<String> d) {

        //sort by length and lex ordering
        Collections.sort(d, new Comparator<String>() {

            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                return Integer.compare(s1.length(), s2.length()) * -1;
            }
        });

        //find the first string in D that is a subsequence of s. then return that string in D.
        for (String str : d) {

            char[] cArr = str.toCharArray();
            char[] sArr = s.toCharArray();

            int length = 0;

            for (int i = 0; i < sArr.length; i++) {
                if (sArr[i] == cArr[length]) {
                    length++;
                    if (length == str.length()) { return str; }
                }
            }
        }

        return "";
        //time complexity is O(n * s *lgn), n is length of d and s is the length of the longest string in d.
    }
}
