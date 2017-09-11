package hashtables;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by alexisherrera on 8/31/17.
 */
public class P1 {

    //test for palindromic permutations

    //we will iterate through the characters in the string and we will place them in a set. If the character
    //is not in the set then we will add it to the set. IF it is we will remove it from the set. At the end
    //of iterating through the character array if the set does not have a size of 1 or 0 then we cannot form a
    //permutation

    public static boolean canFormPerm(String s) {
        char[] str = s.toCharArray();
        HashSet<Character> set = new HashSet<>();

        //place items in the set
        for (char c: str) {
            if (set.contains(c)) {
                set.remove(c);
            }
            else {
                set.add(c);
            }
        }

        return set.size() == 1 || set.size() == 0;

    }

    //runs in O(n) time and takes o(c), c is distinct characters in stirng, space.

    public static void main(String[] args) {
        String s = "racecar";
        System.out.println(canFormPerm(s)); //should be true
        String r = "nope";
        System.out.println(canFormPerm(r)); //should be false;

    }
}
