package dynamic_programming;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by alexisherrera on 9/21/17.
 */
public class P5 {

    //find if a sequence exists in a 2D array
    public static boolean searchSequence(int[][] matrix, int[] seq) {
        //the technique is to iterate through all values in the matrix. if the seq starts at a seq[1] do bfs

        HashSet<String> memo = new HashSet<String>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == seq[0] && search(matrix, seq, 0, row, col, memo)) { return true; }
            }
        }
        return false;
    }



    public static boolean search(int[][] matrix, int[] seq, int index, int row, int col, HashSet<String> memo) {
        if (index >= seq.length) { return true; }

        //error checking
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) {
            return false;
        }

        if (matrix[row][col] != seq[index]) { return false; }

        String k = "" + row + "-" + col + "-" + index + "";
        if (memo.contains(k)) { return false; }

        //check for every adjacent element
        boolean left = search(matrix, seq, index + 1, row, col - 1, memo);
        boolean up = search(matrix, seq, index + 1, row - 1, col, memo);
        boolean right = search(matrix, seq, index + 1, row, col + 1, memo);
        boolean bottom = search(matrix, seq, index + 1, row + 1, col, memo);

        if (!(left || up || right || bottom)) {
            memo.add(k);
            return false;
        }
        return true;
        //how can we optimize this? well we can cache the result of the subproblem which takes place at the particular
        //row, col, and index. Because we cannot "repeat places we've already visited this stops us from back tracking
        //to our original placement. Further, it allows us to use work previously computed to right away throw a
        //a possibility that is not worth searching for. We do this with a map.

        //this reduces our running time to at least O(row*col). Since at each
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {3, 4, 5},
                {5, 6, 7}
        };

        int[] seq = {1, 3, 4, 6, 7, 5, 3, 2};

        //should be true
        System.out.println(searchSequence(matrix, seq));
    }


}
