package leetcode;

/**
 * Created by alexisherrera on 10/26/17.
 */
public class SpiralMatrixTwo {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int start = 1;

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        while (true) {

            //top row imp
            for (int col = left; col <= right; col++) {
                result[top][col] = start++;
            }
            top++;

            if (top > bottom) { break; }


            //right col
            for (int row = top; row <= bottom; row++) {
                result[row][right] = start++;
            }
            right--;

            if (right < left) { break; }

            //bottom row
            for (int col = right; col >= left; col--) {
                result[bottom][col] = start++;
            }
            bottom--;

            if (bottom < top) { break; }

            //left col
            for (int row = bottom; row >= top; row--) {
                result[row][left] = start++;
            }
            left++;
            if (left > right) { break; }
        }
        return result;
    }
}
