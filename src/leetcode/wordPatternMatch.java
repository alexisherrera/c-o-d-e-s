package leetcode;
import java.util.*;

/**
 * Created by alexisherrera on 11/11/17.
 */
public class wordPatternMatch {
    public static boolean wordPatternMatch(String pattern, String str) {
        return helper(pattern, str, new HashMap<>(), new HashSet<>());
    }

    //helper external function
    public static boolean helper(String pattern, String str, Map<Character, String> map, Set<String> s) {
        if (pattern.length() == 0 && str.length() == 0) { return true; }
        if (pattern.length() == 0 || str.length() == 0) { return false; }


        for (int i = 1; i <= str.length(); i++) {

            //we need to define a pattern
            if (!map.containsKey(pattern.charAt(0))) {

                if (!s.contains(str.substring(0, i))) {
                    map.put(pattern.charAt(0), str.substring(0, i));
                    s.add(str.substring(0, i));
                    if (helper(pattern.substring(1), str.substring(i), map, s)) return true;
                    s.remove(map.get(pattern.charAt(0)));
                    map.remove(pattern.charAt(0));
                }
                else { continue; }
            }

            //we have already defined a pattern
            else {
                String sub = map.get(pattern.charAt(0));

                if (str.length() < sub.length()) { return false; }

                for (int j = 0; j < sub.length(); j++) {
                    if (sub.charAt(j) != str.charAt(j)) { return false; }
                }

                return helper(pattern.substring(1), str.substring(sub.length()), map, s);
            }
        }

        return false;
        //return the bool

    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "redbluebluered";

        System.out.println(wordPatternMatch(pattern, str));

    }

}
