package dynamic_programming;

/**
 * Created by alexisherrera on 9/18/17.
 */
public class P2 {
    //compute the levenshtein distance

    //essentially compute the minmum number of edits in order to make 2 strings the same
    public static int minEdits(String s1, String s2) {

        return minEdits(s1, s2,s1.length() - 1, s2.length() - 1);


    }

    public static int minEdits(String s1, String s2, int index1, int index2) {
        //check if either string is null or index surpasses one of them. this also takes care of inserting
        //characters to our string
        if (index1 < 0 && index2 < 0) { return 0; }
        if (index1 < 0) {
            return index2 + 1;
        }
        if (index2 < 0) {
            return index1 + 1;
        }

        //check at the current index: check the significane of either doing a sub, deletion, which is skipping
        if (s1.charAt(index1) != s2.charAt(index2)) {
            int sub = 1 + minEdits(s1, s2, index1 - 1, index2 - 1);
            int deletion1 = 1 + minEdits(s1, s2, index1 - 1, index2);
            int deletion2 = 1 + minEdits(s1, s2, index1, index2 - 1);
            return Math.min(sub, Math.min(deletion1, deletion2));
        }
        else {
            return minEdits(s1, s2, index1 - 1, index2 - 1);
        }

        //why does this work when you consider characters from the end rather than from the front?
    }


    public static void main(String[] args) {
        System.out.println(minEdits("Carthorse", "Orchestra"));
    }


}
