package dynamic_programming;

/**
 * Created by alexisherrera on 9/21/17.
 */
public class P3 {
    //count the number of ways to traverse a 2D array
    //from top left corner to the bottom right
    public static int traverse(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < memo.length; row++) {
            for (int col = 0; col < memo[0].length; col++) {
                memo[row][col] = -1;
            }
        }

        return traverse(matrix, 0, 0, memo);
    }

    //function that will solve this for us using recursion
    public static int traverse(int[][] matrix, int row, int col, int[][] memo) {

        //check basecases
        if (row >= matrix.length || col >= matrix[0].length) { return 0; }


        //check if we are at the bottom right
        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
            return 1;
        }

        //traverse to the right and down
        else {
            if (memo[row][col] != -1) { return memo[row][col]; }
            int sol = traverse(matrix, row + 1, col, memo) + traverse(matrix, row, col + 1, memo);
            memo[row][col] = sol;
            return sol;
        }


        //this running time is at least 2^(Nm). we need to memo because we repeat same problem. consider diagonal squares

        //for this we can use a second matrix and memo the results

        //now running time is O(mn). further O(mn) space;
    }



    public static void main(String[] args) {
        int[][] m = new int[5][5];

        System.out.println(traverse(m));
    }
}
