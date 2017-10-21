package leetcode;

/**
 * Created by alexisherrera on 10/21/17.
 */
public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) { return false; }
        int col = matrix[0].length - 1;
        int row = 0;

        //iterate from right to left
        while (col >= 0 && row < matrix.length) {
            if (matrix[row][col] == target) { return true; }
            if (matrix[row][col] > target) { col--; }
            //search the bottom
            else if (matrix[row][col] < target) { row ++; }
        }

        return false;
    }
}
