package dynamic_programming;

import java.util.HashMap;

/**
 * Created by alexisherrera on 9/18/17.
 */
public class P2 {
    //compute the levenshtein distance

    //essentially compute the minmum number of edits in order to make 2 strings the same
    public static int minEdits(String s1, String s2) {

        return minEdits(s1, s2,s1.length() - 1, s2.length() - 1, new HashMap<>());
        //min edits

    }
    public static int minEdits(String s1, String s2, int index1, int index2, HashMap<String, Integer> memo) {
        //check if either string is null or index surpasses one of them. this also takes care of inserting
        //characters to our string
        if (index1 < 0 && index2 < 0) { return 0; }
        if (index1 < 0) {
            return index2 + 1;
        }
        if (index2 < 0) {
            return index1 + 1;
        }

        String k = "" + index1 + "-" + index2 +"";

        if (memo.containsKey(k)) {
            return memo.get(k);
        }


        int solution = 0;
        //check at the current index: check the significane of either doing a sub, deletion, which is skipping
        if (s1.charAt(index1) != s2.charAt(index2)) {
            int sub = 1 + minEdits(s1, s2, index1 - 1, index2 - 1, memo);
            int deletion1 = 1 + minEdits(s1, s2, index1 - 1, index2, memo);
            int deletion2 = 1 + minEdits(s1, s2, index1, index2 - 1, memo);
            solution = Math.min(sub, Math.min(deletion1, deletion2));
        }
        else {
            solution = minEdits(s1, s2, index1 - 1, index2 - 1, memo);
        }

        memo.put(k, solution);
        return solution;


        //the number of subproblems reduces to the numbers of index pairs which are s1.length * s2.length
        //therefore the running time is O(nm)

        //further we have O(nm) space complexity


        //why does this work when you consider characters from the end rather than from the front?
        //they both work similarly.


        //now we have to memoize, this will allow us to reduce the running time from O(3(^n)) to
        //O(number of subproblems * time to complete each subproblem)
    }

    public static int minEditsForward(String s1, String s2, int index1, int index2) {
        //check if either string is null or index surpasses one of them. this also takes care of inserting
        //characters to our string
        if (index1 >= s1.length() && index2 >= s2.length()) { return 0; }
        if (index1 >= s1.length()) {
            return s2.length() - index2;
        }
        if (index2 >= s2.length()) {
            return s1.length() - index1;
        }

        //check at the current index: check the significance of either doing a sub, deletion, which is skipping
        if (s1.charAt(index1) != s2.charAt(index2)) {
            int sub = 1 + minEditsForward(s1, s2, index1 + 1, index2 + 1);
            int deletion1 = 1 + minEditsForward(s1, s2, index1 + 1, index2);
            int deletion2 = 1 + minEditsForward(s1, s2, index1, index2 + 1);
            return Math.min(sub, Math.min(deletion1, deletion2));
        }
        else {
            return minEditsForward(s1, s2, index1 + 1, index2 + 1);
        }

        //why does this work when you consider characters from the end rather than from the front?
        //they both work similarly
    }


    public static void main(String[] args) {
        System.out.println(minEdits("Saturday", "Sundays"));
    }


}
